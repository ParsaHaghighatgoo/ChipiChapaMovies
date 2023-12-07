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
    Date realeseDate;
    ArrayList<Report> reports;
    ArrayList<Review> reviews;
    String soundTrack;
    ArrayList<Cast> casts;
    String play;
    int numberOfReviews;
    String photos;

    MovieGenres movieGenres;
}
