package main;

import DAO.GenreDAO;
import DAO.MovieDAO;
import tables.Genre;
import tables.Movie;
import java.sql.SQLException;


public class Main {
    public static int movieID,genreID;
    public static void main(String[] args) throws SQLException {

        // inserez filmele

        MovieDAO movieDao = new MovieDAO();
        movieDao.add(new Movie("Film1", "12/3/2021",6032,8.2f),movieID++);
        movieDao.add(new Movie("Film2", "15/3/2021",5032,9.9f),movieID++);
        movieDao.add(new Movie("Film3", "17/3/2021",5562,5f),movieID++);

        // afisez ceea ce citesc din tabela movies

        System.out.println(movieDao.getMovie(0).toString());
        System.out.println(movieDao.getMovie(1).toString());
        System.out.println(movieDao.getMovie(2).toString());

        // inserez genurile

        GenreDAO genreDao = new GenreDAO();
        genreDao.add(new Genre("Drama"),genreID++);
        genreDao.add(new Genre("Horror"),genreID++);
        genreDao.add(new Genre("Comedy"),genreID++);

        // afisez ceea ce se afla int abela genres

        System.out.println(genreDao.getGenre(0).toString());
        System.out.println(genreDao.getGenre(1).toString());
        System.out.println(genreDao.getGenre(2).toString());
    }
}
