package com.imran.jdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.util.ResourceBundle;

// To create connection Pool
// This is a class designed by Singleton pattern
public class ConnectionPool {
    private static final ConnectionPool CONNECTION_POOL
            = new ConnectionPool();

    private ConnectionPool() {}

    public static ConnectionPool getConnectionPool() {
        return CONNECTION_POOL;
    }

    // to create connection
    public DataSource getConnection() {
        // We utilize the ResourceBundle class
        // for convenient access to data from the db.properties file.
        var dbProp = ResourceBundle.getBundle("db");

        var config = new HikariConfig();
        config.setJdbcUrl(dbProp.getString("db.url"));
        config.setUsername(dbProp.getString("db.user"));
        config.setPassword(dbProp.getString("db.password"));
        config.setDriverClassName(dbProp.getString("db.driver"));
        var maxPoolSize
                = dbProp.getString("db.max.connections");
        config.setMaximumPoolSize(Integer.parseInt(maxPoolSize));

        return new HikariDataSource(config);
    }
}
