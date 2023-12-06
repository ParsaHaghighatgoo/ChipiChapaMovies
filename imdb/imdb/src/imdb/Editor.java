package imdb;

import java.util.ArrayList;

public class Editor extends User{

    public Editor(int id, String name, String lastName, String userName, String passWord, int nationalID, String email, int age, Sex sex, Address address, ArrayList<User> followers, ArrayList<User> following) {
        super(id, name, lastName, userName, passWord, nationalID, email, age, sex, address, followers, following);
    }

    @Override
    public String toString() {
        return "Editor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", nationalID=" + nationalID +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", address=" + address +
                '}';
    }
}
