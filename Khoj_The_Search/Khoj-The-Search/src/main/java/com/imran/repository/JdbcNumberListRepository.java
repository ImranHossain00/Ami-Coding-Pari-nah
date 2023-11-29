package com.imran.repository;

import com.imran.domain.NumberList;
import com.imran.jdbc.ConnectionPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public class JdbcNumberListRepository implements NumberListRepository{

    private static final Logger LOGGER
            = LoggerFactory.getLogger(JDBCUserRepositoryImpl.class);
    private DataSource dataSource
            = ConnectionPool.getInstance().getDataSource();

//            "INSERT INTO your_table_name (user_id, user_value, version, date_created, date_last_updated) "
//            + " VALUES ";
//            (1, 2, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
//            (1, 3, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
//            (1, 4, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
//            (1, 5, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
//            (1, -10, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

    // FIXME: 11/28/23 Complete the method
    @Override
    public void save(NumberList list) {
        final String INSERT_NUMBER_LIST = makeInsertionQuery(list.getNumberList().size());

        try (var connection = dataSource.getConnection(); var prstmnt = connection.prepareStatement(INSERT_NUMBER_LIST)){
            // write the rest logic
        } catch (SQLException e) {
            throw new RuntimeException("Unable to insert the values");
        }
    }

    @Override
    public Optional<NumberList> findByTimeAndUserId(Timestamp sTime, Timestamp eTime, Long id) {
        return Optional.empty();
    }

    private static String makeInsertionQuery(int len) {

        StringBuilder query = new StringBuilder(
                "INSERT INTO user_values1 (user_id, insert_time, user_values, version, date_created, date_last_updated)  VALUES ");
//        (1, 2, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

        for (int i = 0; i < len; i++) {
            if (i == len-1)
                query.append("(?, ?, ?, ?, ?, ?)");
            else
                query.append("(?, ?, ?, ?, ?, ?),");
        }

        return query.toString();
    }
}
