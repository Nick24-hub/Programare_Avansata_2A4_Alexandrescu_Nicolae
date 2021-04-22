package lab8.main.DAO;

import lab8.main.connection.DBConnection;
import lab8.main.tables.Director;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DirectorDAO {
    static Connection con = DBConnection.getConnection();

    public void add(Director director, int directorID) throws SQLException {
        String query = "insert into directors values (?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, directorID);
        ps.setString(2, director.getName());
        ps.executeUpdate();
    }

    public Director getDirector(int id) throws SQLException {

        String query = "select * from directors where id= ?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, id);
        Director director = new Director();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            director.setName(rs.getString("name"));
        }

        if (check) {
            return director;
        } else
            return null;
    }
}
