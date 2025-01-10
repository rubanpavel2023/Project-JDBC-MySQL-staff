package org.example.app.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConn {

    static Properties prop = new Properties();

    public static Connection connect() {
        try {
            prop.load(DBConn.class.getResourceAsStream("/resources/jdbc.properties"));
            try (Connection conn = DriverManager.getConnection(prop.getProperty("dbDriver") + prop.getProperty("dbName"),
                    prop.getProperty("username"),
                    prop.getProperty("password"))) {
                return conn;
            }
        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}


