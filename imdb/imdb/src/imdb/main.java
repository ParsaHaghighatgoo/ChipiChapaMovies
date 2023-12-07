package imdb;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class main {
    public static ArrayList<User> usersDb = new ArrayList<>();
    public static Random randomIdGen = new Random();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int bound = 1000000;

        Address userAddress = new Address("iran", "fars", "shiraz", "avini", 1);

        int userID = randomIdGen.nextInt(bound);
        User user = new User(userID, "user", "test", "userTest",
                "444", 228366, "userTest@gmail.com", 18, Sex.OTHER, userAddress, null, null, UserRole.MEMBER,
                null, null, null, null, null
                , null, 1);
        User user2 = new User(userID + 2, "user2", "test", "userTest",
                "445", 228366, "userTest@gmail.com", 18, Sex.OTHER, userAddress, null, null, UserRole.MEMBER,
                null, null, null, null, null
                , null, 1);
        usersDb.add(user);
        usersDb.add(user2);

        String[] rolelist = {"admin", "member", "editor", "cast"};


        int adminId = randomIdGen.nextInt(bound);
        User admin1 = new User(adminId, "Parsa",
                "Haghighatgoo", "parca", "parca444", 228
                , "prsahahgighatgoo@gmail.com", 20, Sex.MALE, userAddress, null, null
                , UserRole.ADMIN, null, null, null, null, null
                , null, 1);
        usersDb.add(admin1);

        while (true) {
            System.out.println("-------------------------------------------------------------");
            System.out.println("enter your command:");
            System.out.println("1.exit\n2.login\n3.sign up");
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
                    User logedInUser = User.login(inpUser, inpPass);
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
                            }
                        }

                    }

                } else {
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("user not found!\nTry again :D");
                }
            }
            System.out.println("enter a key on your keyboard for continue:");
            String continueKey = scanner.nextLine();
        }
    }
}
