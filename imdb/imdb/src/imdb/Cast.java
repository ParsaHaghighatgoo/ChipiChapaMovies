package imdb;

import java.util.ArrayList;

public class Cast extends User {
    int id;
    ArrayList<Movie> movies;
    CastRole role;

    ArrayList<Member> memberFollowers;

    public Cast(int id, String name, String lastName, String userName, String passWord, int nationalID, String email, int age, Sex sex, Address address, ArrayList<User> followers, ArrayList<User> following, int id1, ArrayList<Movie> movies, CastRole role, ArrayList<Member> memberFollowers) {
        super(id, name, lastName, userName, passWord, nationalID, email, age, sex, address, followers, following);
        this.id = id1;
        this.movies = movies;
        this.role = role;
        this.memberFollowers = memberFollowers;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public CastRole getRole() {
        return role;
    }

    public void setRole(CastRole role) {
        this.role = role;
    }

    public ArrayList<Member> getMemberFollowers() {
        return memberFollowers;
    }

    public void setMemberFollowers(ArrayList<Member> memberFollowers) {
        this.memberFollowers = memberFollowers;
    }

    @Override
    public String toString() {
        return "Cast{" +
                "id=" + id +
                ", movies=" + movies +
                ", role=" + role +
                ", memberFollowers=" + memberFollowers +
                '}';
    }
}
