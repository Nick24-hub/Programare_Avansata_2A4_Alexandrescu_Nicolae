package tables;

public class MovieGenresJunction {
    private int movieId,genreId;

    public MovieGenresJunction(int movieId, int genreId) {
        this.movieId = movieId;
        this.genreId = genreId;
    }

    public MovieGenresJunction() {
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    @Override
    public String toString() {
        return "MovieGenresJunction{" +
                "movieId=" + movieId +
                ", genreId=" + genreId +
                '}';
    }
}
