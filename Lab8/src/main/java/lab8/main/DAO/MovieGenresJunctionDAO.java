package lab8.main.DAO;

import lab8.main.connection.DBConnection;
import lab8.main.tables.MovieGenresJunction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieGenresJunctionDAO {
    static Connection con = DBConnection.getConnection();

    public void add(MovieGenresJunction movieGenresJunction, int movieGenresJunctionID) throws SQLException {
        String query = "insert into movieGenresJunction values (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, movieGenresJunctionID);
        ps.setInt(2, movieGenresJunction.getMovieId());
        ps.setInt(3, movieGenresJunction.getGenreId());
        ps.executeUpdate();
    }

    public List<String> getMovieGenres(int movieId) throws SQLException {

        String query = "select * from movies join movieGenresJunction on movies.id=movieGenresJunction.movieId join genres on movieGenresJunction.genreId=genres.id where movies.id= ?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, movieId);
        List<String> movieGenres = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            movieGenres.add(rs.getString("name"));
        }

        if (check) {
            return movieGenres;
        } else
            return null;
    }

}
