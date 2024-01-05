package imdb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Movie {
    int id;
    String title;
    double imdbRate;
    String trailer;
    String summry;
    String poster;
    String realeseYear;
    ArrayList<Report> reports;
    ArrayList<Review> reviews;
    String soundTrack;
    ArrayList<Cast> casts;
    String play;
    int numberOfReviews;
    String photos;
    MovieGenres movieGenres;
    String language;
    ArrayList<Integer> userRates = new ArrayList<Integer>();
    int like;
    ArrayList<String> comment;

    public Movie(int id, String title, double rate, String trailer, String summry, String poster, String realeseYear, ArrayList<Report> reports, ArrayList<Review> reviews, String soundTrack, ArrayList<Cast> casts, String play, int numberOfReviews, String photos, MovieGenres movieGenres, String language, ArrayList<Integer> userRates, int like,ArrayList<String> comment) {
        this.id = id;
        this.title = title;
        this.imdbRate = rate;
        this.trailer = trailer;
        this.summry = summry;
        this.poster = poster;
        this.realeseYear = realeseYear;
        this.reports = reports;
        this.reviews = reviews;
        this.soundTrack = soundTrack;
        this.casts = casts;
        this.play = play;
        this.numberOfReviews = numberOfReviews;
        this.photos = photos;
        this.movieGenres = movieGenres;
        this.language = language;
        this.userRates = userRates;
        this.like = like;
        this.comment = comment;
    }

    public int getLike() {
        return like;
    }

    public double getImdbRate() {
        return imdbRate;
    }

    public static void setAndCalculateUserRatesForImdbRate(Movie desiredMovie) {
        double avg = 0;
        for (int userRate : desiredMovie.userRates) {
            avg += userRate;
        }
        avg = avg / desiredMovie.userRates.size();
        desiredMovie.imdbRate = avg;
    }

    public static void sortAndReverse() {
        Collections.sort(main.moviesDb, Comparator.comparingDouble(Movie::getImdbRate));
        Collections.reverse(main.moviesDb);
    }

    private static ArrayList<Movie> findTop3Movies(ArrayList<Movie> movies) {
        Collections.sort(movies, Comparator.comparingDouble(Movie::getLike));
        Collections.reverse(movies);
        return movies;
    }

    public static void charts() {
        System.out.println("-------------------------------------------------------------");
        System.out.println("highest rated movies : (top 3) ");
        System.out.println("1. " + main.moviesDb.get(0).title + " - imdbRate: " + main.moviesDb.get(0).imdbRate);
        System.out.println("2. " + main.moviesDb.get(1).title + " - imdbRate: " + main.moviesDb.get(1).imdbRate);
        System.out.println("3. " + main.moviesDb.get(2).title + " - imdbRate: " + main.moviesDb.get(2).imdbRate);
        System.out.println();

        System.out.println("most popular movies based on movies like: (top 3) ");
        ArrayList<Movie> top3Movies = findTop3Movies(new ArrayList<>(main.moviesDb));
        System.out.println("1. " + top3Movies.get(0).title + " - Like: " + top3Movies.get(0).like);
        System.out.println("2. " + top3Movies.get(1).title + " - Like: " + top3Movies.get(1).like);
        System.out.println("3. " + top3Movies.get(2).title + " - Like: " + top3Movies.get(2).like);
        System.out.println();

    }


}

