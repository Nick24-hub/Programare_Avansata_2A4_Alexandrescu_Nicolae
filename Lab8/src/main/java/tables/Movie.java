package tables;

import java.util.Date;

public class Movie {
    private String title;
    private int durationSecounds;
    private String releaseDate;
    private float score;

    public Movie(String title, String releaseDate, int durationSecounds, float score) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.durationSecounds = durationSecounds;
        this.score = score;
    }

    public Movie() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDurationSecounds() {
        return durationSecounds;
    }

    public void setDurationSecounds(int durationSecounds) {
        this.durationSecounds = durationSecounds;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", durationSecounds=" + durationSecounds +
                ", score=" + score +
                '}';
    }
}
