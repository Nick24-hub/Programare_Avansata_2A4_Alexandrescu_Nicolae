package DAO;

import connection.DBConnection;
import tables.Genre;

import java.sql.*;

public class GenreDAO {
    static Connection con = DBConnection.getConnection();

    public void add(Genre genre, int genreID) throws SQLException {
        String query = "insert into genres values (?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, genreID);
        ps.setString(2, genre.getName());
        ps.executeUpdate();
    }

    public Genre getGenre(int id) throws SQLException {

        String query = "select * from genres where id= ?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, id);
        Genre genre = new Genre();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            genre.setName(rs.getString("name"));
        }

        if (check) {
            return genre;
        } else
            return null;
    }
}
