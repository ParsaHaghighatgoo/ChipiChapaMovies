package imdb;

import java.util.ArrayList;

public class User {
    int id;
    String name;
    String lastName;
    String userName;
    String passWord;
    int nationalID;
    String email;
    int age;
    Sex sex;
    Address address;
    ArrayList<User> followers;
    ArrayList<User> following;

    public ArrayList<User> getFollowers() {
        return followers;
    }

    public void setFollowers(ArrayList<User> followers) {
        this.followers = followers;
    }

    public ArrayList<User> getFollowing() {
        return following;
    }

    public void setFollowing(ArrayList<User> following) {
        this.following = following;
    }

    public User(int id, String name, String lastName, String userName, String passWord, int nationalID, String email, int age, Sex sex, Address address, ArrayList<User> followers, ArrayList<User> following) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.userName = userName;
        this.passWord = passWord;
        this.nationalID = nationalID;
        this.email = email;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.followers = followers;
        this.following = following;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getNationalID() {
        return nationalID;
    }

    public void setNationalID(int nationalID) {
        this.nationalID = nationalID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
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
                ", followers=" + followers +
                ", following=" + following +
                '}';
    }

    public static User login(String usreName,String passWord){
        for (User user: main.usersDb) {
            if (user.userName.equals(usreName) && user.passWord.equals(passWord)){
                return user;
            }
        }
        return null;
    }
    public static void menu(int role){
        switch (role){
            case 1:
                System.out.println("Enter your command:");
                System.out.println("-------------------------------------------------------------");
                System.out.println("0.sign out\n1.see all users\n2.delete user\n3.add user");
                return;
            case 2:
                System.out.println("Enter your command:");
                System.out.println("member");
                return;
            case 3 :
                System.out.println("Enter your command:");
                System.out.println("editor");
                return;
            case 4:
                System.out.println("Enter your command:");
                System.out.println("cast");
                return;
            default :
                return;
        }
    }
}

