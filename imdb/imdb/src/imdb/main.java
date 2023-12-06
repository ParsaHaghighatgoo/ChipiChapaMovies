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
        ArrayList<User> followers = null;
        ArrayList<User> following = null;
        int userID = randomIdGen.nextInt(bound);
        User user = new User(userID,"user","test","userTest",
                "444",228366,"userTest@gmail.com",18,Sex.NONBINARY,userAddress,followers,following);
        User user2 = new User(userID+2,"user2","test","userTest",
                "445",228366,"userTest@gmail.com",18,Sex.NONBINARY,userAddress,followers,following);
        usersDb.add(user);
        usersDb.add(user2);

        String[] rolelist = {"admin","member","editor","cast"};

        Address amdinAddress = userAddress;
        int adminId = randomIdGen.nextInt(bound);
        Admin admin1 = new Admin(adminId,"Parsa",
                "Haghighatgoo","parca","parca444",228
        ,"prsahahgighatgoo@gmail.com",20,Sex.MALE,amdinAddress
        ,null,null,null,null,null,null,null);

        usersDb.add(admin1);

        while (true){
            System.out.println("enter your command:");
            System.out.println("1.exit\n2.login\n3.sign up");
            int command = Integer.parseInt(scanner.nextLine());
            if (command == 1){
                System.out.println("Bye! :D");
                break;
            }
            else if (command == 2) {
                System.out.println("login as:\n1.admin\n2.member\n3.editor\n4.cast");
                int role = Integer.parseInt(scanner.nextLine());
                System.out.println("enter your username:");
                String inpUser = scanner.nextLine();
                System.out.println("enter your password:");
                String inpPass = scanner.nextLine();
                if(User.login(inpUser,inpPass)!= null){
                    User logedInUser = User.login(inpUser,inpPass);
                    System.out.println("Login successful as "+rolelist[role-1]+"\nHi "+logedInUser.name);
                    User.menu(role);
                }
                else {
                    System.out.println("user not found!\nTry again :D");
                }
            }
            System.out.println("enter a key on your keyboard for continue:");
            String continueKey = scanner.nextLine();
        }
    }
}
