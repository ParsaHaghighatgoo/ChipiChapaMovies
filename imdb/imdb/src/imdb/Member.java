package imdb;

import java.util.ArrayList;

public class Member extends User{
    ArrayList<Report> reports;
    ArrayList<Review> reviews;
    ArrayList<Movie> classicsToSee;
    ArrayList<Movie> watchList;
    ArrayList<Movie> favorites;
    ArrayList<Member> followers;
    ArrayList<Member> following;
    ArrayList<Cast> castsFollowing;


    public Member(int id, String name, String lastName, String userName, String passWord, int nationalID, String email, int age, Sex sex, Address address, ArrayList<User> followers, ArrayList<User> following, ArrayList<Report> reports, ArrayList<Review> reviews, ArrayList<Movie> classicsToSee, ArrayList<Movie> watchList, ArrayList<Movie> favorites, ArrayList<Member> followers1, ArrayList<Member> following1, ArrayList<Cast> castsFollowing) {
        super(id, name, lastName, userName, passWord, nationalID, email, age, sex, address, followers, following);
        this.reports = reports;
        this.reviews = reviews;
        this.classicsToSee = classicsToSee;
        this.watchList = watchList;
        this.favorites = favorites;
        this.followers = followers1;
        this.following = following1;
        this.castsFollowing = castsFollowing;
    }

}
