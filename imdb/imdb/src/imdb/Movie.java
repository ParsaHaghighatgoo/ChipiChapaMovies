package imdb;

import java.util.ArrayList;
import java.util.Date;

public class Movie {
    int id;
    String title;
    double rate;
    String trailer;
    String summry;
    String poster;
    String realeseDate;
    ArrayList<Report> reports;
    ArrayList<Review> reviews;
    String soundTrack;
    ArrayList<Cast> casts;
    String play;
    int numberOfReviews;
    String photos;
    MovieGenres movieGenres;

    public Movie(int id, String title, double rate, String trailer, String summry, String poster, String realeseDate, ArrayList<Report> reports, ArrayList<Review> reviews, String soundTrack, ArrayList<Cast> casts, String play, int numberOfReviews, String photos, MovieGenres movieGenres) {
        this.id = id;
        this.title = title;
        this.rate = rate;
        this.trailer = trailer;
        this.summry = summry;
        this.poster = poster;
        this.realeseDate = realeseDate;
        this.reports = reports;
        this.reviews = reviews;
        this.soundTrack = soundTrack;
        this.casts = casts;
        this.play = play;
        this.numberOfReviews = numberOfReviews;
        this.photos = photos;
        this.movieGenres = movieGenres;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rate=" + rate +
                ", trailer='" + trailer + '\'' +
                ", summry='" + summry + '\'' +
                ", poster='" + poster + '\'' +
                ", realeseDate='" + realeseDate + '\'' +
                ", reports=" + reports +
                ", reviews=" + reviews +
                ", soundTrack='" + soundTrack + '\'' +
                ", casts=" + casts +
                ", play='" + play + '\'' +
                ", numberOfReviews=" + numberOfReviews +
                ", photos='" + photos + '\'' +
                ", movieGenres=" + movieGenres +
                '}';
    }
}











