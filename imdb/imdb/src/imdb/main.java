//tozih db va main

package imdb;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class main {
    public static ArrayList<User> usersDb = new ArrayList<>();
    public static ArrayList<Movie> moviesDb = new ArrayList<>();
    public static ArrayList<Report> reportsDb = new ArrayList<>();
    public static ArrayList<Review> reviewsDb = new ArrayList<>();
    public static ArrayList<Cast> castDb = new ArrayList<>();
    public static Random randomIdGen = new Random();
    public static Scanner scanner = new Scanner(System.in);
    public static int bound = 1000000;

    public static User logedInUser;

    public static void main(String[] args) {


        Address userAddress = new Address("iran", "fars", "shiraz", "avini", 1);

        int adminId = randomIdGen.nextInt(bound);
        User admin = new User(adminId, "Parsa",
                "Haghighatgoo", "admin", "admin", 228
                , "prsahahgighatgoo@gmail.com", 20, Sex.MALE, userAddress, null, null
                , UserRole.ADMIN, null, null, null, null, null
                , null, 1);
        usersDb.add(admin);


        int userID = randomIdGen.nextInt(bound);
        User user = new User(userID, "user", "test", "userTest",
                "444", 228366, "userTest@gmail.com", 18, Sex.OTHER, userAddress, null, null, UserRole.MEMBER,
                null, null, null, null, null
                , null, 1);
        User user2 = new User(userID + 2, "user2", "test", "userTest",
                "445", 228366, "userTest@gmail.com", 18, Sex.OTHER, userAddress, null, null, UserRole.MEMBER,
                null, null, null, null, null
                , null, 1);
        User editor = new User(userID, "editor", "eidtor", "editor",
                "editor", 1, "eidtor", 1, Sex.MALE, userAddress, null, null
                , UserRole.EDITOR, null, null, null, null, null
                , null, 1);
        usersDb.add(user);
        usersDb.add(user2);

        String[] rolelist = {"admin", "member", "editor", "cast"};

        ArrayList<Movie> castTestMovie = new ArrayList<>();
        Cast castTest= new Cast(userID,"cast","cast",1,Sex.MALE,castTestMovie,CastRole.DIRECTOR,null);
        castDb.add(castTest);

        ArrayList<Cast> movieTestCasts = new ArrayList<>();
        movieTestCasts.add(castTest);
        Movie movieTest = new Movie(randomIdGen.nextInt(bound), "movie", randomIdGen.nextInt(100), "", "", "", "", null
                , null, "", null, "", 0, "", MovieGenres.ACION,"english");
        moviesDb.add(movieTest);

        while (true) {
            System.out.println("-------------------------------------------------------------");
            System.out.println("enter your command:");
            System.out.println("1.exit\n2.login\n3.sign up\n4.reset password");
            int command = Integer.parseInt(scanner.nextLine());
            if (command == 1) {
                System.out.println("-------------------------------------------------------------");
                System.out.println("Bye! :D");
                break;
            } else if (command == 2) {
                System.out.println("-------------------------------------------------------------");
//                System.out.println("login as:\n1.admin\n2.member\n3.editor\n4.cast");
//                int role = Integer.parseInt(scanner.nextLine());
                System.out.println("enter your username:");
                String inpUser = scanner.nextLine();
                System.out.println("enter your password:");
                String inpPass = scanner.nextLine();
                if (User.login(inpUser, inpPass) != null) {
                    logedInUser = User.login(inpUser, inpPass);
                    System.out.println("Login successful as " + logedInUser.userRole + "\nHi " + logedInUser.name);
                    while (true) {
                        if (logedInUser.isActive == 0) {
                            System.out.println("you banned from system for more information contact us!");
                            break;
                        }
                        User.menu(logedInUser);
                        if (logedInUser.userRole.equals(UserRole.ADMIN)) {
                            command = Integer.parseInt(scanner.nextLine());
                            if (command == 0) {
                                break;
                            } else if (command == 1) {
                                User.seeAllUser();
                            } else if (command == 2) {
                                System.out.println("-------------------------------------------------------------");
                                System.out.println("enter the username of user you want delete:");
                                String whichUser = scanner.nextLine();
                                User.deleteUser(whichUser);
                            } else if (command == 3) {
                                System.out.println("-------------------------------------------------------------");
                                System.out.println("enter new user's name:");
                                String newName = scanner.nextLine();
                                System.out.println("enter new user's lastname:");
                                String newlastname = scanner.nextLine();
                                System.out.println("enter new user's username:");
                                String newuserName = scanner.nextLine();
                                System.out.println("enter new user's password:");
                                String newpassword = scanner.nextLine();
                                System.out.println("enter new user's nationalid:");
                                int newnationalid = Integer.parseInt(scanner.nextLine());
                                System.out.println("enter new user's email:");
                                String newemail = scanner.nextLine();
                                System.out.println("enter new user's age:");
                                int newage = Integer.parseInt(scanner.nextLine());
                                System.out.println("enter new user's gender:");
                                System.out.println("which one you want\n1.male\n2.female\n3.nonbinary\n4.other");
                                int newsex = Integer.parseInt(scanner.nextLine());
                                System.out.println("what's newuers's role:\n1.admin\n2.editor\n3.member");
                                int newrole = Integer.parseInt(scanner.nextLine());
                                System.out.println("enter the user's country");
                                String newcountry = scanner.nextLine();
                                System.out.println("enter the user's provience:");
                                String newprovience = scanner.nextLine();
                                System.out.println("enter the user's city:");
                                String newcity = scanner.nextLine();
                                System.out.println("enter the user's street:");
                                String newstreet = scanner.nextLine();
                                System.out.println("enter the user's plaque:");
                                int newplaque = Integer.parseInt(scanner.nextLine());
                                Address newaddress = new Address(newcountry, newprovience, newcity, newstreet, newplaque);
                                ArrayList<User> newfollowers = new ArrayList<>();
                                ArrayList<User> newfollowing = new ArrayList<>();
                                ArrayList<Report> newreports = new ArrayList<>();
                                ArrayList<Review> newreviews = new ArrayList<>();
                                ArrayList<Movie> newclassic = new ArrayList<>();
                                ArrayList<Movie> newwatchlist = new ArrayList<>();
                                ArrayList<Movie> newfavorite = new ArrayList<>();
                                ArrayList<Cast> newcastsfollowing = new ArrayList<>();

                                User.addUser(randomIdGen.nextInt(bound), newName
                                        , newlastname, newuserName, newpassword, newnationalid
                                        , newemail, newage, User.newUserSex(newsex), newaddress, newfollowers, newfollowing, User.newUserRole(newrole),
                                        newreports, newreviews, newclassic, newwatchlist, newfavorite, newcastsfollowing, 1);

                                System.out.println("user added successfuly!");
                                System.out.println("-------------------------------------------------------------");
                            } else if (command == 4) {
                                System.out.println("-------------------------------------------------------------");
                                System.out.println("enter username of user which you wanna ban: ");
                                String whichUser = scanner.nextLine();
                                User.banUser(whichUser);
                            } else if (command == 5) {
                                System.out.println("-------------------------------------------------------------");
                                System.out.println("enter the username of user you wanna edit:");
                                String whichUser = scanner.nextLine();
                                User.editUser(whichUser);
                            } else if (command == 6) {
                                System.out.println("-------------------------------------------------------------");
                                User.listOfMovie();
                            } else if (command == 7) {
                                System.out.println("-------------------------------------------------------------");
                                System.out.println("enter the title of movie you want delete:");
                                String whichMovie = scanner.nextLine();
                                User.deleteMovie(whichMovie);
                            } else if (command == 8) {
                                System.out.println("-------------------------------------------------------------");
                                System.out.println("enter new title:");
                                String newtitle = scanner.nextLine();
                                System.out.println("enter new rate:");
                                int newrate = Integer.parseInt(scanner.nextLine());
                                System.out.println("enter new trailer:");
                                String newtrailer = scanner.nextLine();
                                System.out.println("enter new summry:");
                                String newsummry = scanner.nextLine();
                                System.out.println("enter new poster link:");
                                String newposter = scanner.nextLine();
                                System.out.println("enter new realese date:");
                                String newrealesedare = scanner.nextLine();
                                System.out.println("enter new reports:");
                                ArrayList<Report> newreports = new ArrayList<>();
                                System.out.println("enter new reviews:");
                                ArrayList<Review> newreviews = new ArrayList<>();
                                System.out.println("enter new soundtrack link:");
                                String newsoundtrack = scanner.nextLine();
                                System.out.println("enter new casts:");
                                ArrayList<Cast> newcasts = new ArrayList<>();
                                newcasts.add(castTest);
                                System.out.println("enter new play link:");
                                String newplay = scanner.nextLine();
                                System.out.println("enter new number of reviews");
                                int newnumofr = Integer.parseInt(scanner.nextLine());
                                System.out.println("eneter new photos link:");
                                String newphotos = scanner.nextLine();
                                System.out.println("enter new movie genre:\n1.comedy 2.drama 3.action 4.cartoon 5.horror");
                                int newg = Integer.parseInt(scanner.nextLine());
                                MovieGenres newmoviegenre = User.newgenre(newg);
                                System.out.println("enter the movie language: ");
                                String newLanguage = scanner.nextLine();
                                User.addmovie(randomIdGen.nextInt(bound), newtitle, newrate, newtrailer, newsummry, newposter, newrealesedare
                                        , newreports, newreviews, newsoundtrack, newcasts, newplay, newnumofr, newphotos, newmoviegenre,newLanguage);
                                System.out.println("movie added successfuly!");
                                System.out.println("-------------------------------------------------------------");
                            } else if (command == 9) {
                                System.out.println("-------------------------------------------------------------");
                                System.out.println("enter the title of movie you wanna edit:");
                                String whichMovie = scanner.nextLine();
                                User.editMovie(whichMovie);
                            } else if (command == 10) {
                                System.out.println("-------------------------------------------------------------");
                                System.out.println("enter the name of user you wanna see:");
                                String whichUser = scanner.nextLine();
                                User.seeAUser(whichUser);
                            } else if (command == 11) {
                                System.out.println("-------------------------------------------------------------");
                                System.out.println("enter the name of movie you wanna see:");
                                String whichMovie = scanner.nextLine();
                                User.seeAMovie(whichMovie);
                            } else if (command == 12) {

                            } else if (command == 13) {
                                User.seeAllCasts();
                            } else if (command == 14) {
                                System.out.println("-------------------------------------------------------------");
                                System.out.println("enter the name of cast you want delete:");
                                String whichUser = scanner.nextLine();
                                User.deleteCast(whichUser);
                            } else if (command == 15) {
                                Cast.addCast();
                            } else if (command == 16) {
                                System.out.println("-------------------------------------------------------------");
                                System.out.println("enter the name of cast you wanna edit:");
                                String whichUser = scanner.nextLine();
                                User.editCast(whichUser);
                            } else if (command == 17) {
                                User.showMyProfile(logedInUser);
                            } else if (command == 18) {
                                System.out.println("enter name of the cast you wanna see: ");
                                User.seeACast(scanner.nextLine());
                            }
                        }
                        else if(logedInUser.userRole.equals(UserRole.EDITOR)){
                            command = Integer.parseInt(scanner.nextLine());
                            if(command == 1){
                                User.suggestToAdmin(logedInUser);
                            } else if (command == 2) {
                                User.showMyProfile(logedInUser);
                            }
                        }
                    }


                } else {
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("user not found!\nTry again :D");
                }
            } else if (command == 3) {
                System.out.println("for creating a new account please write your informations:");
                System.out.println("-------------------------------------------------------------");
                System.out.println("enter new your name:");
                String newName = scanner.nextLine();
                System.out.println("enter your lastname:");
                String newlastname = scanner.nextLine();
                System.out.println("enter  your username:");
                String newuserName = scanner.nextLine();
                System.out.println("enter  your password:");
                String newpassword = scanner.nextLine();
                System.out.println("enter  your nationalid:");
                int newnationalid = Integer.parseInt(scanner.nextLine());
                System.out.println("enter your email:");
                String newemail = scanner.nextLine();
                System.out.println("enter your age:");
                int newage = Integer.parseInt(scanner.nextLine());
                System.out.println("enter your gender:");
                System.out.println("which one you want\n1.male\n2.female\n3.nonbinary\n4.other");
                int newsex = Integer.parseInt(scanner.nextLine());
                System.out.println("you are creating account as member!");
                System.out.println("enter your country");
                String newcountry = scanner.nextLine();
                System.out.println("enter your provience:");
                String newprovience = scanner.nextLine();
                System.out.println("enter your city:");
                String newcity = scanner.nextLine();
                System.out.println("enter your street:");
                String newstreet = scanner.nextLine();
                System.out.println("enter your plaque:");
                int newplaque = Integer.parseInt(scanner.nextLine());
                Address newaddress = new Address(newcountry, newprovience, newcity, newstreet, newplaque);
                ArrayList<User> newfollowers = new ArrayList<>();
                ArrayList<User> newfollowing = new ArrayList<>();
                ArrayList<Report> newreports = new ArrayList<>();
                ArrayList<Review> newreviews = new ArrayList<>();
                ArrayList<Movie> newclassic = new ArrayList<>();
                ArrayList<Movie> newwatchlist = new ArrayList<>();
                ArrayList<Movie> newfavorite = new ArrayList<>();
                ArrayList<Cast> newcastsfollowing = new ArrayList<>();
                User.addUser(randomIdGen.nextInt(bound), newName
                        , newlastname, newuserName, newpassword, newnationalid
                        , newemail, newage, User.newUserSex(newsex), newaddress, newfollowers, newfollowing, UserRole.MEMBER,
                        newreports, newreviews, newclassic, newwatchlist, newfavorite, newcastsfollowing, 1);
                System.out.println("your account created as member successfuly!\nfor editor account or admin contact admin Thanks!\nyou can log in now\nhope you enjoy! :D");
                System.out.println("-------------------------------------------------------------");
            }
            else if(command == 4){
                User.resetpass();
            }
            System.out.println("enter a key on your keyboard for continue:");
            String continueKey = scanner.nextLine();
        }
    }
}
