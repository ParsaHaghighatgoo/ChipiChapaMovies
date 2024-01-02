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
    ArrayList<String> editorrecoms;

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

    public static void resetpass() {
        System.out.println("enter ur username: ");
        String checkUsername = main.scanner.nextLine();
        System.out.println("enter your email");
        String checkEmail = main.scanner.nextLine();
        for (User user : main.usersDb) {
            if (user.userName.equals(checkUsername)) {
                if (user.email.equals(checkEmail)) {
                    System.out.println("enter new pass:");
                    String newpass = main.scanner.nextLine();
                    user.passWord = newpass;
                    System.out.println("password changed succesfully:D");
                    return;
                }
                System.out.println("email and username dont match!");
                return;
            }
        }
        System.out.println("wrong username!");
    }

    public static void showMyProfile(User logedInUser) {
        System.out.println(logedInUser);
        System.out.println("if you want change ur profile enter: 1.changeProfile's detail 0.back");
        int command = Integer.parseInt(main.scanner.nextLine());
        if (command == 0) {
            return;
        } else if (command == 1) {
            editMyProfile(logedInUser);
        } else {
            System.out.println("wrong command executed!");
            return;
        }
    }

    private static void editMyProfile(User user) {
        System.out.println("you can edit :\n" +
                "1. name\n" +
                "2. lastName\n" +
                "3. userName\n" +
                "4. passWord\n" +
                "5. nationalID\n" +
                "6. String email\n" +
                "7. age\n" +
                "8. sex\n" +
                "9. address\n"
        );
        int command = Integer.parseInt(main.scanner.nextLine());
        if (command == 1) {
            System.out.println("enter new name:");
            String editname = main.scanner.nextLine();
            user.name = editname;
        } else if (command == 2) {
            System.out.println("enter new lastname:");
            String editlastname = main.scanner.nextLine();
            user.lastName = editlastname;
        } else if (command == 3) {
            System.out.println("enter new username:");
            String editusername = main.scanner.nextLine();
            user.userName = editusername;
        } else if (command == 4) {
            System.out.println("enter new password:");
            String editpass = main.scanner.nextLine();
            user.passWord = editpass;
        } else if (command == 5) {
            System.out.println("enter new national id:");
            int editNid = Integer.parseInt(main.scanner.nextLine());
            user.nationalID = editNid;
        } else if (command == 6) {
            System.out.println("enter new email:");
            String editemail = main.scanner.nextLine();
            user.email = editemail;
        } else if (command == 7) {
            System.out.println("enter new age:");
            int editage = Integer.parseInt(main.scanner.nextLine());
            user.age = editage;
        } else if (command == 8) {
            System.out.println("enter new sex:\n1.male\n2.female\n3.others");
            int editsex = Integer.parseInt(main.scanner.nextLine());
            user.sex = newUserSex(editsex);
        } else if (command == 9) {
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
        }
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
                        "4.ban user\n5.edit user" +
                        "\n6.list of movies\n7.delete movie\n8.add movie\n9.edit movie\n10.search a user" +
                        "\n11.search a movie\n12.approve editor's edit\n13.see all casts\n14.delete casts" +
                        "\n15.add cast\n16.edit cast\n17.show my profile and profile edit setting\n18.search a cast\n19.setImdbRate");
                return;
            case 2:
                System.out.println("Enter your command:");
                System.out.println("0.signout\n1.show my profile and profile edit setting\n2.search a movie\n3.search a cast" +
                        "\n4.search a user\n5.search a movie with filters(advance search)");
                return;
            case 3:
                System.out.println("Enter your command:");
                System.out.println("0.signout\n1.suggest an edit to admin\n2.show my profile and profile edit setting");
                return;
            default:
                return;
        }
    }

    public static void listOfMovie() {
        int cnt = 1;
        for (Movie movie : main.moviesDb) {
            System.out.println(cnt + "- " + movie.title);
            cnt++;
        }
        System.out.println("-------------------------------------------------------------");
    }

    public static void suggestToAdmin(User user) {
        System.out.println("write your suggestion: ");
        String newsug = main.scanner.nextLine();
        newsug = user.userName + "suggest this to admin :" + newsug;
        main.usersDb.get(0).editorrecoms.add(newsug);
    }


    public static void suggestToAdminAsMember(User user, String newsug) {
        newsug = user.userName + "as member for contribution suggest this to admin :" + newsug;
        main.usersDb.get(0).editorrecoms.add(newsug);
    }


    public static void seeAllUser() {
        int cnt = 1;
        for (User user : main.usersDb) {
            System.out.println(cnt + "- " + user.userName);
            cnt++;
        }
        System.out.println("-------------------------------------------------------------");
    }

    public static void seeAllCasts() {
        int cnt = 1;
        for (Cast cast : main.castDb) {
            System.out.println(cnt + "- " + cast.name + " " + cast.lastName);
            cnt++;
        }
        System.out.println("-------------------------------------------------------------");
    }

    public static void advanceSearch() {
        System.out.println("""
                catgories for advance search:
                1.search with filters
                2.search by keywords
                3.search a user or movie with their name
                4.back:""");
        int whichOne = Integer.parseInt(main.scanner.nextLine());
        if (whichOne == 1) {
            System.out.println("which one: " +
                    "1.search with realsedate" +
                    " 2.search with genre" +
                    " 3.search with rating" +
                    " 4.back");
            int whichFilter = Integer.parseInt(main.scanner.nextLine());
            if (whichFilter == 1) {
                System.out.println("enter ur desired year: like mm/dd/yy ");
                String newYear = main.scanner.nextLine();
                for (Movie movie : main.moviesDb) {
                    if (movie.realeseDate.equals(newYear)) {
                        System.out.println(movie.title);
                    }
                }
            } else if (whichFilter == 2) {
                System.out.println("enter genre:\n1.comedy 2.drama 3.action 4.cartoon 5.horror");
                int newg = Integer.parseInt(main.scanner.nextLine());
                MovieGenres newmoviegenre = User.newgenre(newg);
                for (Movie movie : main.moviesDb) {
                    if (movie.movieGenres.equals(newmoviegenre)) {
                        System.out.println(movie.title);
                    }
                }
            } else if (whichFilter == 3) {
                System.out.println("enter ur desired rate:");
                double newImdbRate = Double.parseDouble(main.scanner.nextLine());
                for (Movie movie : main.moviesDb) {
                    if (movie.imdbRate == newImdbRate) {
                        System.out.println(movie.title);
                    }
                }
            }
        } else if (whichOne == 2) {

        } else if (whichOne == 3) {
            System.out.println("1.movie or 2.user: ");
            int whichtwo = Integer.parseInt(main.scanner.nextLine());
            System.out.println("enter the desired name: ");
            String input = main.scanner.nextLine();
            if (whichtwo == 1) {
                User.seeAMovie(input);
            } else if (whichtwo == 2) {
                User.seeAUser(input);
            }
        }
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public static void editMovie(String title) {
        for (Movie movie : main.moviesDb) {
            if (movie.title.equals(title)) {
                System.out.println(
                        "edit :\n1.id\n2.title\n3.rate\n4.trailer\n5.summry\n6.poster\n7.realeseDate\n8.reports\n9.reviews\n10.soundTrack" +
                                "\n11.casts\n12.play\n13.numberOfReviews\n14.photos\n15.movieGenres"
                );
                int command = Integer.parseInt(main.scanner.nextLine());
                if (command == 1) {
                    System.out.println("enter new id:");
                    int editId = Integer.parseInt(main.scanner.nextLine());
                    movie.id = editId;
                } else if (command == 2) {
                    System.out.println("enter new title:");
                    String editname = main.scanner.nextLine();
                    movie.title = editname;
                } else if (command == 3) {
                    System.out.println("enter new rate:");
                    int editRate = Integer.parseInt(main.scanner.nextLine());
                    movie.imdbRate = editRate;
                } else if (command == 4) {
                    System.out.println("enter new trailer url:");
                    String edittrailer = main.scanner.nextLine();
                    movie.trailer = edittrailer;
                } else if (command == 5) {
                    System.out.println("enter new summry:");
                    String editsummry = main.scanner.nextLine();
                    movie.summry = editsummry;
                } else if (command == 6) {
                    System.out.println("enter new poster:");
                    String editposter = main.scanner.nextLine();
                    movie.poster = editposter;
                } else if (command == 7) {
                    System.out.println("enter new release date:");
                    String editrelease = main.scanner.nextLine();
                    movie.realeseDate = editrelease;
                } else if (command == 8) {
                    System.out.println("there is list of this movie reports:\nif you want to" +
                            "delete one of them or add one report enter your command:" +
                            "\n1.remove one\n2.add one");
                    int cnt = 0;
                    for (Report report : movie.reports) {
                        System.out.println(cnt + "." + report.title);
                        cnt++;
                    }
                    int newcommand = Integer.parseInt(main.scanner.nextLine());
                    if (newcommand == 1) {
                        System.out.println("enter the title of report you want to delete:");
                        String newtitledelete = main.scanner.nextLine();
                        for (Report report : movie.reports) {
                            if (report.title.equals(newtitledelete)) {
                                movie.reports.remove(report);
                                break;
                            }
                        }
                    } else if (newcommand == 2) {
                        System.out.println("enter new title for it:");
                        String newtitle = main.scanner.nextLine();
                        System.out.println("enter new about for it:");
                        String newabout = main.scanner.nextLine();
                        System.out.println("1.spam 2.violence 3.copyright 4.personal 5.other");
                        int newtype = Integer.parseInt(main.scanner.nextLine());
                        Report newreportadd = new Report(main.randomIdGen.nextInt(main.bound),
                                newtitle, newabout, Report.createtype(newtype), main.usersDb.get(0), movie);
                        movie.reports.add(newreportadd);
                        main.reportsDb.add(newreportadd);
                        main.usersDb.get(0).reports.add(newreportadd);
                    }
                } else if (command == 9) {
                    boolean nspoil;
                    boolean nhelp;
                    System.out.println("there is list of this movie reviews:\nif you want to" +
                            "delete one of them or add one report enter your command:" +
                            "\n1.remove one\n2.add one");
                    int cnt = 0;
                    for (Review review : movie.reviews) {
                        System.out.println(cnt + "." + review.title);
                        cnt++;
                    }
                    int newcommand = Integer.parseInt(main.scanner.nextLine());
                    if (newcommand == 1) {
                        System.out.println("enter the title of report you want to delete:");
                        String newtitledelete = main.scanner.nextLine();
                        for (Review review : movie.reviews) {
                            if (review.title.equals(newtitledelete)) {
                                movie.reports.remove(review);
                                break;
                            }
                        }
                    } else if (newcommand == 2) {
                        System.out.println("enter new title for it:");
                        String newtitle = main.scanner.nextLine();
                        System.out.println("enter new about for it:");
                        String newabout = main.scanner.nextLine();
                        System.out.println("is it helpful?\n1.yes\n2.no");
                        int newhelp = Integer.parseInt(main.scanner.nextLine());
                        if (newhelp == 1) {
                            nhelp = true;
                        } else {
                            nhelp = false;
                        }
                        System.out.println("is it spoiler?\n1.yes\n2.no");
                        int newspolier = Integer.parseInt(main.scanner.nextLine());
                        if (newspolier == 1) {
                            nspoil = true;
                        } else {
                            nspoil = false;
                        }
                        Review newreview = new Review(main.randomIdGen.nextInt(main.bound),
                                newtitle, newabout, main.usersDb.get(0), nhelp, nspoil, 0, movie);
                        movie.reviews.add(newreview);
                        main.reviewsDb.add(newreview);
                        //main.usersDb.get(0).reviews.add(newreview);
                    }
                } else if (command == 10) {
                    System.out.println("enter new soundtrack url:");
                    String editsound = main.scanner.nextLine();
                    movie.soundTrack = editsound;
                } else if (command == 11) {
                    System.out.println("there is list of this movie casts:\nif you want to" +
                            "delete one of them or add one cast enter your command:" +
                            "\n1.remove one\n2.add one\n");
                    int cnt = 0;
                    for (Cast cast : movie.casts) {
                        System.out.println(cnt + "." + cast.name);
                        cnt++;
                    }
                    int newcommand = Integer.parseInt(main.scanner.nextLine());
                    if (newcommand == 1) {
                        System.out.println("enter the name of cast you want to delete:");
                        String newtitledelete = main.scanner.nextLine();
                        for (Cast cast : movie.casts) {
                            if (cast.name.equals(newtitledelete)) {
                                movie.casts.remove(cast);
                                break;
                            }
                        }
                    } else if (newcommand == 2) {
                        System.out.println("enter new name for it:");
                        String newname = main.scanner.nextLine();
                        System.out.println("enter new lastname for it:");
                        String newlastname = main.scanner.nextLine();
                        System.out.println("new age");
                        int newage = Integer.parseInt(main.scanner.nextLine());
                        System.out.println("enter your gender:");
                        System.out.println("which one you want\n1.male\n2.female\n3.nonbinary\n4.other");
                        int newsex = Integer.parseInt(main.scanner.nextLine());
                        ArrayList<Movie> movies = new ArrayList<>();
                        ArrayList<User> follewrs = new ArrayList<>();
                        Cast newcast = new Cast(main.randomIdGen.nextInt(main.bound), newname, newlastname, newage, User.newUserSex(newsex), movies
                                , Cast.castRolecreate(), follewrs);
                        main.castDb.add(newcast);
                        movie.casts.add(newcast);
                    } else if (command == 12) {
                        System.out.println("enter new play link:");
                        String editplay = main.scanner.nextLine();
                        movie.play = editplay;
                    } else if (command == 13) {
                        System.out.println("enter new number of reviews:");
                        int newnumor = Integer.parseInt(main.scanner.nextLine());
                        movie.numberOfReviews = newnumor;
                    } else if (command == 14) {
                        System.out.println("enter new photos url:");
                        String editphotos = main.scanner.nextLine();
                        movie.photos = editphotos;
                    } else if (command == 15) {
                        System.out.println("enter new movie genre:\n1.comedy 2.drama 3.action 4.cartoon 5.horror");
                        int newg = Integer.parseInt(main.scanner.nextLine());
                        movie.movieGenres = User.newgenre(newg);
                    }
                    break;
                }
            }
        }
    }

    public static void seeAUser(String userName) {
        for (User user : main.usersDb) {
            if (user.userName.equals(userName)) {
                System.out.println(user.following.get(0));
                break;
            }
        }
    }

    public static User seeAUserForMember(String userName) {
        for (User user : main.usersDb) {
            if (user.userName.equals(userName)) {
                return user;
            }
        }
        return null;
    }


    public static void seeACast(String userName) {
        for (Cast cast : main.castDb) {
            if (cast.name.equals(userName)) {
                System.out.println(cast);
                break;
            }
        }
    }

    public static Cast seeACastForUser(String userName) {
        for (Cast cast : main.castDb) {
            if (cast.name.equals(userName)) {
                return cast;
            }
        }
        return null;
    }


    public static void seeAMovie(String title) {
        for (Movie movie : main.moviesDb) {
            if (movie.title.equals(title)) {
                System.out.println(movie);
                break;
            }
        }
    }

    public static Movie seeAMovieForUser(String title) {
        for (Movie movie : main.moviesDb) {
            if (movie.title.equals(title)) {
                return movie;
            }
        }
        return null;
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
        return;
    }

    public static void editCast(String name) {
        for (Cast cast : main.castDb) {
            if (cast.name.equals(name)) {
                System.out.println("edit :\n" +
                        "1. id\n" +
                        "2. name\n" +
                        "3. lastName\n" +
                        "4. age\n" +
                        "5. sex\n" +
                        "6. role\n"
                );
                int command = Integer.parseInt(main.scanner.nextLine());
                if (command == 1) {
                    System.out.println("enter new id:");
                    int editId = Integer.parseInt(main.scanner.nextLine());
                    cast.id = editId;
                } else if (command == 2) {
                    System.out.println("enter new name:");
                    String editname = main.scanner.nextLine();
                    cast.name = editname;
                } else if (command == 3) {
                    System.out.println("enter new lastname:");
                    String editlastname = main.scanner.nextLine();
                    cast.lastName = editlastname;
                } else if (command == 4) {
                    System.out.println("enter new age:");
                    int editage = Integer.parseInt(main.scanner.nextLine());
                    cast.age = editage;
                } else if (command == 5) {
                    System.out.println("enter new sex:\n1.male\n2.female\n3.others");
                    int editsex = Integer.parseInt(main.scanner.nextLine());
                    cast.sex = newUserSex(editsex);
                } else if (command == 6) {
                    cast.role = Cast.castRolecreate();
                }
                break;
            }
        }
        return;
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

    public static void deleteCast(String name) {
        for (Cast cast : main.castDb) {
            if (cast.name.equals(name)) {
                main.castDb.remove(cast);
                System.out.println("cast " + name + " deleted successfuly!");
                System.out.println("-------------------------------------------------------------");
                return;
            }
        }
    }

    public static void deleteMovie(String title) {
        for (Movie movie : main.moviesDb) {
            if (movie.title.equals(title)) {
                main.moviesDb.remove(movie);
                System.out.println("movie " + title + " deleted successfuly!");
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

    public static MovieGenres newgenre(int newg) {
        if (newg == 1) return MovieGenres.COMEDY;
        else if (newg == 2) return MovieGenres.DARMA;
        else if (newg == 3) return MovieGenres.ACION;
        else if (newg == 4) return MovieGenres.CARTOON;
        else if (newg == 5) return MovieGenres.HORROR;
        return MovieGenres.ACION;
    }

    public static void addmovie(int id,
                                String title,
                                double rate,
                                String trailer,
                                String summry,
                                String poster,
                                String realeseDate,
                                ArrayList<Report> reports,
                                ArrayList<Review> reviews,
                                String soundTrack,
                                ArrayList<Cast> casts,
                                String play,
                                int numberOfReviews,
                                String photos,
                                MovieGenres movieGenres, String language, ArrayList<Integer> userRates) {
        Movie newMovie = new Movie(id, title, rate, trailer, summry, poster, realeseDate, reports
                , reviews, soundTrack, casts, play, numberOfReviews, photos, movieGenres, language, userRates, 0);
        main.moviesDb.add(newMovie);
        for (Cast castmoive : newMovie.casts) {
            for (Cast castdb : main.castDb) {
                if (castdb.equals(castmoive)) {
                    castdb.movies.add(newMovie);
                    break;
                }
            }
        }
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

    @Override
    public String toString() {
        return "User{" +
                ", followers=" + followers +
                ", following=" + following +

                '}';
    }

}

