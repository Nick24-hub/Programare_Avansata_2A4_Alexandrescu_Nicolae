package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection con = null;
    private DBConnection() {};

    public static Connection getConnection()
    {
        if(con == null)
        {
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electroway", "root", "root");
            } catch (SQLException e) {
                System.err.println("Cannot connect to DB: " + e);
            }
        }
        return con;
    }
}

