package imdb;

public class AprovalEdits {
    Movie orignalMovie;
    Movie editedMovie;
    User editor;
    String about;

    public AprovalEdits(Movie orignalMovie, Movie editedMovie, User editor, String about) {
        this.orignalMovie = orignalMovie;
        this.editedMovie = editedMovie;
        this.editor = editor;
        this.about = about;
    }

    public static void editMovieWithAproval(User logedInUser) {
        System.out.println("enter the name of movie you wanna edit: ");
        String nameOfOriginalMovie = main.scanner.nextLine();
        System.out.println("whats your edit:");
        String whatedit = main.scanner.nextLine();
        for (Movie movie : main.moviesDb) {
            if (movie.title.equals(nameOfOriginalMovie)) {
                Movie copiedMovie = new Movie(movie.id, movie.title, movie.imdbRate, movie.trailer, movie.summry, movie.poster, movie.realeseYear,
                        movie.reports, movie.reviews, movie.soundTrack, movie.casts, movie.play, movie.numberOfReviews, movie.photos
                        , movie.movieGenres, movie.language, movie.userRates, movie.like, movie.comment);
                copiedMovie.title = movie.title + "InQueue";
                main.moviesDb.add(copiedMovie);
                Movie.sortAndReverse();
                User.editMovie(copiedMovie.title);
                String editAbout = logedInUser + " edits " + whatedit + " in " + movie.title + " and saved it to " + copiedMovie.title;
                AprovalEdits newaprovalEdits = new AprovalEdits(movie, copiedMovie, logedInUser, editAbout);
                main.usersDb.get(0).adminAproves.add(newaprovalEdits);
                logedInUser.aprovesQueue.add(newaprovalEdits);
                main.aprovalEditsDb.add(newaprovalEdits);
                break;
            }
        }
    }


    public static void adminMethod(User logedInUser) {
        int counter = 0;
        for (AprovalEdits aprovalEdits : logedInUser.adminAproves) {
            System.out.println(counter + ". " + aprovalEdits.about);
        }
        System.out.println("chose one or write back: ");
        String command = main.scanner.nextLine();
        if (command.equals("back")){
            return;
        }
        else{
            int numOfEdit = Integer.parseInt(command);
            System.out.println("do u want to aprove it(1) or not(2): ");
            int aproveCommand = Integer.parseInt(main.scanner.nextLine());
            if (aproveCommand == 2){
                int cnt2 = 0;
                for (AprovalEdits aprovalEdits:logedInUser.adminAproves){
                    if (cnt2 == numOfEdit){
                        main.aprovalEditsDb.remove(aprovalEdits);
                        logedInUser.adminAproves.remove(aprovalEdits);
                        aprovalEdits.editor.aprovesQueue.remove(aprovalEdits);
                        Movie.sortAndReverse();
                        System.out.println("edit rejected");
                        break;
                    }
                    cnt2++;
                }
            } else if (aproveCommand == 1) {
                int cnt3 = 0;
                for (AprovalEdits aprovalEdits:logedInUser.adminAproves){
                    if (cnt3 == numOfEdit){
                        String orgTitle = aprovalEdits.orignalMovie.title;
                        main.moviesDb.remove(aprovalEdits.orignalMovie);
                        aprovalEdits.editedMovie.title = orgTitle;
                        main.aprovalEditsDb.remove(aprovalEdits);
                        logedInUser.adminAproves.remove(aprovalEdits);
                        aprovalEdits.editor.aprovesQueue.remove(aprovalEdits);
                        Movie.sortAndReverse();
                        System.out.println("edit aproved :D");
                        break;
                    }
                    cnt3++;
                }

            }
        }
    }
}
