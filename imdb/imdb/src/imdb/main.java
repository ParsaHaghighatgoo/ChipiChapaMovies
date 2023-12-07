package imdb;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class main {
    public static ArrayList<User> usersDb = new ArrayList<>();

    public static void main(String[] args) {
        Random randomIdGen = new Random();
        Scanner scanner = new Scanner(System.in);
        int bound = 1000000;

        Address userAddress= new Address("fars","shiraz","avini",1);

        int userID = randomIdGen.nextInt(bound);
        User user = new User(userID,"user","test","userTest",
                "444",228366,"userTest@gmail.com",18,Sex.OTHER,userAddress,null,null,UserRole.MEMBER,
                null,null,null,null,null
                ,null);
        User user2 = new User(userID+2,"user2","test","userTest",
                "445",228366,"userTest@gmail.com",18,Sex.OTHER,userAddress,null,null,UserRole.MEMBER,
        null,null,null,null,null
                ,null);
        usersDb.add(user);
        usersDb.add(user2);

        String[] rolelist = {"admin","member","editor","cast"};


        int adminId = randomIdGen.nextInt(bound);
        User admin1 = new User(adminId,"Parsa",
                "Haghighatgoo","parca","parca444",228
        ,"prsahahgighatgoo@gmail.com",20,Sex.MALE,userAddress,null,null
        ,UserRole.ADMIN,null,null,null,null,null
        ,null);

        usersDb.add(admin1);

        while (true){
            System.out.println("-------------------------------------------------------------");
            System.out.println("enter your command:");
            System.out.println("1.exit\n2.login\n3.sign up");
            int command = Integer.parseInt(scanner.nextLine());
            if (command == 1){
                System.out.println("-------------------------------------------------------------");
                System.out.println("Bye! :D");
                break;
            }
            else if (command == 2) {
                System.out.println("-------------------------------------------------------------");
                System.out.println("login as:\n1.admin\n2.member\n3.editor\n4.cast");
                int role = Integer.parseInt(scanner.nextLine());
                System.out.println("enter your username:");
                String inpUser = scanner.nextLine();
                System.out.println("enter your password:");
                String inpPass = scanner.nextLine();
                if(User.login(inpUser,inpPass)!= null){
                    User logedInUser = User.login(inpUser,inpPass);
                    System.out.println("Login successful as "+rolelist[role-1]+"\nHi "+logedInUser.name);
                    while (true){
                        User.menu(role);
                        command = Integer.parseInt(scanner.nextLine());
                        if(command == 0){break;}
                        else if (command == 1 ){User.seeAllUser();}
                        else if(command == 2 ){
                            System.out.println("-------------------------------------------------------------");
                            System.out.println("enter the username of user you want delete:");
                            String whichUser = scanner.nextLine();
                            User.deleteUser(whichUser);
                        }
                        else if(command == 3){
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
                            User.addUser(randomIdGen.nextInt(bound),newName
                                    ,newlastname,newuserName,newpassword,newnationalid
                                    ,newemail,newage,User.newUserSex(newsex),null,null,null,User.newUserRole(newrole),
                                    null,null,null,null,null,null);

                            System.out.println("user added successfuly!");
                            System.out.println("-------------------------------------------------------------");
                        }
                    }

                }
                else {
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("user not found!\nTry again :D");
                }
            }
//            System.out.println("enter a key on your keyboard for continue:");
//            String continueKey = scanner.nextLine();
        }
    }
}
