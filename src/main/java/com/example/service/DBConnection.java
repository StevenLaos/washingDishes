package com.example.service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by User on 6/15/2017.
 */
public class DBConnection {
    public static Connection getConnection() {
        Properties props = new Properties();
        Connection connection = null;
        try (InputStream inputStream = DBConnection.class.getClassLoader().getResourceAsStream("config.properties")){
            props.load(inputStream);
            Class.forName(props.getProperty("driver"));
            connection = DriverManager.getConnection(props.getProperty("url"), props.getProperty("user"),
                    props.getProperty("password"));
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void closeConnection(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("Closing database connection has failed");
            e.printStackTrace();
        }
    }
}
