package DAO;

import connection.DBConnection;
import tables.Movie;

import java.sql.*;

public class MovieDAO {
    static Connection con = DBConnection.getConnection();

    public void add(Movie movie, int movieID) throws SQLException {
        String query = "insert into movies values (?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, movieID);
        ps.setString(2, movie.getTitle());
        ps.setString(3, movie.getReleaseDate());
        ps.setInt(4, movie.getDurationSecounds());
        ps.setFloat(5, movie.getScore());
        ps.executeUpdate();
    }

    public Movie getMovie(int id) throws SQLException {

        String query = "select * from movies where id= ?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, id);
        Movie movie = new Movie();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            movie.setTitle(rs.getString("title"));
            movie.setReleaseDate(rs.getString("release_date"));
            movie.setDurationSecounds(rs.getInt("duration"));
            movie.setScore(rs.getFloat("score"));
        }

        if (check) {
            return movie;
        } else
            return null;
    }
}
