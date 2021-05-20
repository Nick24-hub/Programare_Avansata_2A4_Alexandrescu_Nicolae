package com.example.lab11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {

    private static Connection connection;
    private static String url = "jdbc:mariadb://localhost:3306/electroway";
    private static  String user = "root";
    private  static String pass = "root";

    private Singleton() {
    }

    public static Connection getConnection() throws SQLException {
        if (connection != null){
            return connection;
        }
        else
        {
            connection = DriverManager.getConnection(url, user, pass);
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {

        if(connection!=null)
        {
            connection.close();
        }

    }
}
