package imdb;

import java.util.ArrayList;

public class Cast {
    int id;
    String name;
    String lastName;
    int age;
    Sex sex;
    ArrayList<Movie> movies;
    CastRole role;
    ArrayList<User> userFollowers;

    @Override
    public String toString() {
        return "Cast{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", movies=" + movies +
                ", role=" + role +
                ", userFollowers=" + userFollowers +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
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

    public ArrayList<User> getuserFollowers() {
        return userFollowers;
    }

    public void setuserFollowers(ArrayList<User> memberFollowers) {
        this.userFollowers = memberFollowers;
    }

    public Cast(int id, String name, String lastName, int age, Sex sex, ArrayList<Movie> movies, CastRole role, ArrayList<User> memberFollowers) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.movies = movies;
        this.role = role;
        this.userFollowers = userFollowers;
    }
}
