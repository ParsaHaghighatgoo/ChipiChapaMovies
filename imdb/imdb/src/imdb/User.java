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
    UserRole userRole;
    ArrayList<Report> reports;
    ArrayList<Review> reviews;
    ArrayList<Movie> classicsToSee;
    ArrayList<Movie> watchList;
    ArrayList<Movie> favorites;
    ArrayList<Cast> castsFollowing;

    public User(int id, String name, String lastName, String userName, String passWord, int nationalID, String email, int age, Sex sex, Address address, ArrayList<User> followers, ArrayList<User> following, UserRole userRole, ArrayList<Report> reports, ArrayList<Review> reviews, ArrayList<Movie> classicsToSee, ArrayList<Movie> watchList, ArrayList<Movie> favorites, ArrayList<Cast> castsFollowing) {
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
        this.userRole = userRole;
        this.reports = reports;
        this.reviews = reviews;
        this.classicsToSee = classicsToSee;
        this.watchList = watchList;
        this.favorites = favorites;
        this.castsFollowing = castsFollowing;
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
                ", userRole=" + userRole +
                ", reports=" + reports +
                ", reviews=" + reviews +
                ", classicsToSee=" + classicsToSee +
                ", watchList=" + watchList +
                ", favorites=" + favorites +
                ", castsFollowing=" + castsFollowing +
                '}';
    }
    public static User login(String usreName, String passWord){
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
                return;}
    }
    public static void seeAllUser(){
        int cnt = 1 ;
        for(User user : main.usersDb){
            System.out.println(cnt +"- " + user.userName);
            cnt++;
        }
        System.out.println("-------------------------------------------------------------");
    }

    public static void deleteUser(String username){
        for(User userr : main.usersDb){
            if(userr.userName.equals(username)){
                main.usersDb.remove(userr);
                System.out.println("user " + username + " deleted successfuly!");
                System.out.println("-------------------------------------------------------------");
                return;
            }
        }
    }
    public static Sex newUserSex(int newsex){
        if(newsex == 1)return Sex.MALE;
        else if (newsex == 2) return Sex.FEMALE;
        else if (newsex == 3) return Sex.MALE.OTHER;
        return Sex.OTHER;
    }
    public  static UserRole newUserRole(int newrole){
        if (newrole == 1) return UserRole.ADMIN;
        else if (newrole == 2) return UserRole.EDITOR;
        else if (newrole == 3) return UserRole.MEMBER;
        return UserRole.MEMBER;
    }
    public static void addUser(int id,
                               String name,
                               String lastName,
                               String userName,
                               String passWord,
                               int nationalID,
                               String email,
                               int age,
                               Sex sex,
                               Address address,
                               ArrayList<User> followers,
                               ArrayList<User> following,
                               UserRole userRole,
                               ArrayList<Report> reports,
                               ArrayList<Review> reviews,
                               ArrayList<Movie> classicsToSee,
                               ArrayList<Movie> watchList,
                               ArrayList<Movie> favorites,
                               ArrayList<Cast> castsFollowing){
        User newUser = new User(id, name, lastName, userName, passWord,
                nationalID, email, age, sex, address, followers, following,userRole,reports
        ,reviews,classicsToSee,watchList,favorites,castsFollowing);
        main.usersDb.add(newUser);
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

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public ArrayList<Report> getReports() {
        return reports;
    }

    public void setReports(ArrayList<Report> reports) {
        this.reports = reports;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    public ArrayList<Movie> getClassicsToSee() {
        return classicsToSee;
    }

    public void setClassicsToSee(ArrayList<Movie> classicsToSee) {
        this.classicsToSee = classicsToSee;
    }

    public ArrayList<Movie> getWatchList() {
        return watchList;
    }

    public void setWatchList(ArrayList<Movie> watchList) {
        this.watchList = watchList;
    }

    public ArrayList<Movie> getFavorites() {
        return favorites;
    }

    public void setFavorites(ArrayList<Movie> favorites) {
        this.favorites = favorites;
    }

    public ArrayList<Cast> getCastsFollowing() {
        return castsFollowing;
    }

    public void setCastsFollowing(ArrayList<Cast> castsFollowing) {
        this.castsFollowing = castsFollowing;
    }

}

