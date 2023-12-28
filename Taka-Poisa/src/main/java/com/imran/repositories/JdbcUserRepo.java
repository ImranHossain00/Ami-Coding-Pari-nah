package com.imran.repositories;

import com.imran.domain.User;
import com.imran.jdbcPool.ConnectionPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Timestamp;

public class JdbcUserRepo implements UserRepo{
    private static final Logger LOGGER
            = LoggerFactory.getLogger(JdbcUserRepo.class);
    private DataSource dataSource
            = ConnectionPool.getConnectionPool().getDatasource();
    private final String INSERT_USER
            = "INSERT INTO users (" +
            " first_name," +
            " last_name," +
            " account_no, " +
            " account_password, " +
            " user_image," +
            " version, " +
            " date_last_updated, " +
            " date_created" +
            ")" +
            " values (?, ?, ?, ?, ?, ?, ?, ?)";
    @Override
    public void insertUser(User user) {
        try (var connection = dataSource.getConnection();
             var prstmnt = connection.prepareStatement(INSERT_USER)){
          prstmnt.setString(1, user.getFirstName());
          prstmnt.setString(2, user.getLastName());
          prstmnt.setString(3, user.getAccountNo());
          prstmnt.setString(4, user.getAccountPassword());
          prstmnt.setBlob(5, user.getPhoto());
          user.setVersion(user.getVersion() + 1L);
          prstmnt.setLong(6, user.getVersion());
          prstmnt.setTimestamp(7, Timestamp.valueOf(user.getDateLastUpdated()));
          prstmnt.setTimestamp(8, Timestamp.valueOf(user.getDateCreated()));

          prstmnt.execute();
        } catch (SQLException e) {
            LOGGER.error("Unable to insert data");
            throw new RuntimeException("Unable to insert data into database");
        }
    }
}
