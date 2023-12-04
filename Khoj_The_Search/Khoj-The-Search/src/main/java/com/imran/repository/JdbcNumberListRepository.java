package com.imran.repository;

import com.imran.domain.NumberList;
import com.imran.domain.RESTApi;
import com.imran.jdbc.ConnectionPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

public class JdbcNumberListRepository implements NumberListRepository{
    private static final Logger LOGGER
            = LoggerFactory.getLogger(JDBCUserRepositoryImpl.class);
    private DataSource dataSource
            = ConnectionPool.getInstance().getDataSource();

    private static final String SELECT_VALUES_WITHIN_GIVEN_TIME
            = "select user_id, insert_time, user_values " +
             " from user_values1 " +
             " where user_id=? and insert_time between ? and ?";

    @Override
    public void save(NumberList list) {
        final String INSERT_NUMBER_LIST = makeInsertionQuery(list.getNumberList().size());

        try (var connection = dataSource.getConnection();
             var prstmnt = connection.prepareStatement(INSERT_NUMBER_LIST)){

            int cnt = 1;
            for (Integer val : list.getNumberList()) {
                prstmnt.setLong(cnt++, list.getUser().getId());
                prstmnt.setTimestamp(cnt++, Timestamp.valueOf(list.getInsertTime()));
                prstmnt.setLong(cnt++, val);
                prstmnt.setLong(cnt++, list.getVersion());
                prstmnt.setTimestamp(cnt++, Timestamp.valueOf(list.getDateCreated()));
                prstmnt.setTimestamp(cnt++, Timestamp.valueOf(list.getDateLastUpdated()));
            }

            prstmnt.execute();

        } catch (SQLException e) {
            throw new RuntimeException("Unable to insert the values");
        }
    }

    @Override
    public void findByTimeAndUserId(RESTApi restApi) {
        try (var connection = dataSource.getConnection();
             var prstmt = connection.prepareStatement(SELECT_VALUES_WITHIN_GIVEN_TIME)) {
            prstmt.setLong(1, restApi.getUserId());
            prstmt.setTimestamp(2 , Timestamp.valueOf(restApi.getStartTime()));
            prstmt.setTimestamp(3, Timestamp.valueOf(restApi.getEndingTime()));

            var resultSet = prstmt.executeQuery();


            if (resultSet.next()) {
                LOGGER.info("Query fetches some data form database");
            } else {
                LOGGER.info("There have no data for given time");
            }
            // Finding the values and inserting them into a hashmap
            restApi.setListMap(extractResultSet(resultSet));

        } catch (SQLException e) {
            throw new RuntimeException("Unable to search given time");
        }
    }

    private Map<LocalDateTime, String > extractResultSet(ResultSet resultSet)
            throws SQLException {

        Map<LocalDateTime, String > listMap = new HashMap<>();
        StringBuilder numbers = new StringBuilder();

        while (resultSet.next()) {
            LocalDateTime time
                    = resultSet
                    .getTimestamp("insert_time")
                    .toLocalDateTime();
            if (listMap.containsKey(time)) {
                listMap.put(
                        time,
                        numbers.append(
                                resultSet.getLong("user_values")
                        ).append(", ").toString());
            } else {
                numbers = new StringBuilder();
                listMap.put(time, numbers.toString());
            }
        }

        return listMap;
    }

    private static String makeInsertionQuery(int len) {

        StringBuilder query = new StringBuilder(
                "INSERT INTO user_values1 (user_id, insert_time, user_values, version, date_created, date_last_updated)  VALUES ");


        for (int i = 0; i < len; i++) {
            if (i == len-1)
                query.append("(?, ?, ?, ?, ?, ?)");
            else
                query.append("(?, ?, ?, ?, ?, ?),");
        }

        return query.toString();
    }
}
