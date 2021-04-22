package main;

import DAO.*;
import tables.*;

import java.sql.SQLException;


public class Main {
    public static int movieID,genreID,actorID,directorID,movieGenresJunctionID;
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

        //inserez actorii

        ActorDAO actorDao = new ActorDAO();
        actorDao.add(new Actor("Actor1"),actorID++);
        actorDao.add(new Actor("Actor2"),actorID++);
        actorDao.add(new Actor("Actor3"),actorID++);

        //inserez directorii

        DirectorDAO directorDao = new DirectorDAO();
        directorDao.add(new Director("Director1"),directorID++);
        directorDao.add(new Director("Director2"),directorID++);
        directorDao.add(new Director("Director3"),directorID++);

        // afisez ceea ce se afla int abela actori

        System.out.println(actorDao.getActor(0).toString());
        System.out.println(actorDao.getActor(1).toString());
        System.out.println(actorDao.getActor(2).toString());

        // afisez directorii din baza de date

        System.out.println(directorDao.getDirector(0).toString());
        System.out.println(directorDao.getDirector(1).toString());
        System.out.println(directorDao.getDirector(2).toString());

        // inserez genurile filmelor in tabela de asociere "movieGenresJunction"

        MovieGenresJunctionDAO movieGenresJunctionDao = new MovieGenresJunctionDAO();
        movieGenresJunctionDao.add(new MovieGenresJunction(0,2),movieGenresJunctionID++);
        movieGenresJunctionDao.add(new MovieGenresJunction(0,1),movieGenresJunctionID++);
        movieGenresJunctionDao.add(new MovieGenresJunction(1,1),movieGenresJunctionID++);
        movieGenresJunctionDao.add(new MovieGenresJunction(2,0),movieGenresJunctionID++);
        movieGenresJunctionDao.add(new MovieGenresJunction(2,2),movieGenresJunctionID++);

        // afisez toate genurile filmelor

        System.out.println("Film1 are genurile: " + movieGenresJunctionDao.getMovieGenres(0).toString());
        System.out.println("Film2 are genurile: " + movieGenresJunctionDao.getMovieGenres(1).toString());
        System.out.println("Film3 are genurile: " + movieGenresJunctionDao.getMovieGenres(2).toString());
    }
}
