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
    int isActive;

    public User(int id, String name, String lastName, String userName, String passWord, int nationalID, String email, int age, Sex sex, Address address, ArrayList<User> followers, ArrayList<User> following, UserRole userRole, ArrayList<Report> reports, ArrayList<Review> reviews, ArrayList<Movie> classicsToSee, ArrayList<Movie> watchList, ArrayList<Movie> favorites, ArrayList<Cast> castsFollowing, int isActive) {
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
        this.isActive = isActive;
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

    public static User login(String usreName, String passWord) {
        for (User user : main.usersDb) {
            if (user.userName.equals(usreName) && user.passWord.equals(passWord)) {
                return user;
            }
        }
        return null;
    }

    public static void menu(User currentUser) {
        int role = 0;
        if (currentUser.userRole == UserRole.ADMIN) role = 1;
        else if (currentUser.userRole == UserRole.MEMBER) role = 2;
        else if (currentUser.userRole == UserRole.EDITOR) role = 3;

        switch (role) {
            case 1:
                System.out.println("Enter your command:");
                System.out.println("-------------------------------------------------------------");
                System.out.println("0.sign out\n1.see all users\n2.delete user\n3.add user\n" +
                        "4.ban user\n5.edit user");
                return;
            case 2:
                System.out.println("Enter your command:");
                System.out.println("member");
                return;
            case 3:
                System.out.println("Enter your command:");
                System.out.println("editor");
                return;
            default:
                return;
        }
    }

    public static void seeAllUser() {
        int cnt = 1;
        for (User user : main.usersDb) {
            System.out.println(cnt + "- " + user.userName);
            cnt++;
        }
        System.out.println("-------------------------------------------------------------");
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public static void editUser(String userName) {
        for (User user : main.usersDb) {
            if (user.userName.equals(userName)) {
                System.out.println("edit :\n" +
                        "1. id\n" +
                        "2. name\n" +
                        "3. lastName\n" +
                        "4. userName\n" +
                        "5. passWord\n" +
                        "6. nationalID\n" +
                        "7. String email\n" +
                        "8. age\n" +
                        "9. sex\n" +
                        "10. address\n" +
                        "11. userRole\n"
                );
                int command = Integer.parseInt(main.scanner.nextLine());
                if (command == 1) {
                    System.out.println("enter new id:");
                    int editId = Integer.parseInt(main.scanner.nextLine());
                    user.id = editId;
                } else if (command == 2) {
                    System.out.println("enter new name:");
                    String editname = main.scanner.nextLine();
                    user.name = editname;
                } else if (command == 3) {
                    System.out.println("enter new lastname:");
                    String editlastname = main.scanner.nextLine();
                    user.lastName = editlastname;
                } else if (command == 4) {
                    System.out.println("enter new username:");
                    String editusername = main.scanner.nextLine();
                    user.userName = editusername;
                } else if (command == 5) {
                    System.out.println("enter new password:");
                    String editpass = main.scanner.nextLine();
                    user.passWord = editpass;
                } else if (command == 6) {
                    System.out.println("enter new national id:");
                    int editNid = Integer.parseInt(main.scanner.nextLine());
                    user.nationalID = editNid;
                } else if (command == 7) {
                    System.out.println("enter new email:");
                    String editemail = main.scanner.nextLine();
                    user.email = editemail;
                } else if (command == 8) {
                    System.out.println("enter new age:");
                    int editage = Integer.parseInt(main.scanner.nextLine());
                    user.age = editage;
                } else if (command == 9) {
                    System.out.println("enter new sex:\n1.male\n2.female\n3.others");
                    int editsex = Integer.parseInt(main.scanner.nextLine());
                    user.sex = newUserSex(editsex);
                } else if (command == 10) {
                    System.out.println("enter the user's country");
                    String newcountry = main.scanner.nextLine();
                    System.out.println("enter the user's provience:");
                    String newprovience = main.scanner.nextLine();
                    System.out.println("enter the user's city:");
                    String newcity = main.scanner.nextLine();
                    System.out.println("enter the user's street:");
                    String newstreet = main.scanner.nextLine();
                    System.out.println("enter the user's plaque:");
                    int newplaque = Integer.parseInt(main.scanner.nextLine());
                    Address newaddress = new Address(newcountry, newprovience, newcity, newstreet, newplaque);
                    user.address = newaddress;
                } else if (command == 11) {
                    System.out.println("enter new role for user :\n1.admin\n2.editor\n3.member");
                    int newrole = Integer.parseInt(main.scanner.nextLine());
                    user.userRole = newUserRole(newrole);
                }
                break;
            }
        }


    }

    public static void banUser(String userName) {
        for (User user : main.usersDb) {
            if (user.userName.equals(userName)) {
                user.isActive = 0;
                System.out.println("user " + userName + " banned!");
                System.out.println("-------------------------------------------------------------");
                return;
            }
        }
        System.out.println("user not fount for banning!");
        return;
    }

    public static void deleteUser(String username) {
        for (User userr : main.usersDb) {
            if (userr.userName.equals(username)) {
                main.usersDb.remove(userr);
                System.out.println("user " + username + " deleted successfuly!");
                System.out.println("-------------------------------------------------------------");
                return;
            }
        }
    }

    public static Sex newUserSex(int newsex) {
        if (newsex == 1) return Sex.MALE;
        else if (newsex == 2) return Sex.FEMALE;
        else if (newsex == 3) return Sex.MALE.OTHER;
        return Sex.OTHER;
    }

    public static UserRole newUserRole(int newrole) {
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
                               ArrayList<Cast> castsFollowing, int isActive) {
        User newUser = new User(id, name, lastName, userName, passWord,
                nationalID, email, age, sex, address, followers, following, userRole, reports
                , reviews, classicsToSee, watchList, favorites, castsFollowing, isActive);
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

