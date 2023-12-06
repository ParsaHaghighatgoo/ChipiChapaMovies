package imdb;

import java.util.ArrayList;

public class Admin extends User{
    ArrayList<Movie> movies;
    ArrayList<Member> members;
    ArrayList<Review> reviews;
    ArrayList<Report> reports;
    ArrayList<User> users;
    //mhayar koshkhole byad bquasdhin ham add knm


    public Admin(int id, String name, String lastName, String userName, String passWord, int nationalID, String email, int age, Sex sex, Address address, ArrayList<User> followers, ArrayList<User> following, ArrayList<Movie> movies, ArrayList<Member> members, ArrayList<Review> reviews, ArrayList<Report> reports, ArrayList<User> users) {
        super(id, name, lastName, userName, passWord, nationalID, email, age, sex, address, followers, following);
        this.movies = movies;
        this.members = members;
        this.reviews = reviews;
        this.reports = reports;
        this.users = users;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    public ArrayList<Report> getReports() {
        return reports;
    }

    public void setReports(ArrayList<Report> reports) {
        this.reports = reports;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "movies=" + movies +
                ", members=" + members +
                ", reviews=" + reviews +
                ", reports=" + reports +
                ", users=" + users +
                '}';
    }

}
