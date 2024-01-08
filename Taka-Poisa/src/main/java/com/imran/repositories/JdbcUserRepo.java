package com.imran.repositories;

import com.imran.domain.User;
import com.imran.exceptions.UserNotFoundException;
import com.imran.jdbcPool.ConnectionPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Optional;

public class JdbcUserRepo implements UserRepo{
    private static final Logger LOGGER
            = LoggerFactory.getLogger(JdbcUserRepo.class);
    private DataSource dataSource
            = ConnectionPool.getConnectionPool().getDatasource();

    @Override
    public void insertUser(User user) {
        String INSERT_USER = "INSERT INTO users (" +
                " first_name," +
                " last_name," +
                " email, " +
                " login_password, " +
                " version, " +
                " date_last_updated, " +
                " date_created" +
                ")" +
                " values (?, ?, ?, ?, ?, ?, ?)";

        try (var connection = dataSource.getConnection();
             var prstmnt = connection.prepareStatement(INSERT_USER)){
          prstmnt.setString(1, user.getFirstName());
          prstmnt.setString(2, user.getLastName());
          prstmnt.setString(3, user.getEmail());
          prstmnt.setString(4, user.getLoginPassword());
          user.setVersion(user.getVersion() + 1L);
          prstmnt.setLong(5, user.getVersion());
          prstmnt.setTimestamp(6, Timestamp.valueOf(user.getDateLastUpdated()));
          prstmnt.setTimestamp(7, Timestamp.valueOf(user.getDateCreated()));

          prstmnt.execute();
        } catch (SQLException e) {
            LOGGER.error("Unable to insert data");
            throw new RuntimeException("Unable to insert data into database");
        }
    }

    @Override
    public User findByEmail(String email) {
        String FINE_BY_EMAIL = "select * from users where email=?";

        try (var conn = dataSource.getConnection();
             var prstmnt = conn.prepareStatement(FINE_BY_EMAIL)){
            prstmnt.setString(1, email);

            var resultSet = prstmnt.executeQuery();

            return extract(resultSet);
        } catch (SQLException e) {
            LOGGER.error("Unable to search");
            throw new RuntimeException("Unable to search");
        } catch (UserNotFoundException e) {
            LOGGER.error("User not found");
            throw new RuntimeException(e);
        }
    }

    private User extract(ResultSet resultSet)
            throws UserNotFoundException, SQLException {
        if (resultSet.next()) {
            return new User(
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("email"),
                    resultSet.getString("login_password")
            );
        } else  {
            return null;
        }
    }
}
