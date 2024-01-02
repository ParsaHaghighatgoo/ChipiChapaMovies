package imdb;

public class Review {
    int id;
    String title;
    String about;
    User user;
    boolean ishelpful;
    boolean isspoiler;
    int like;
    Movie movie;

    public Review(int id, String title, String about, User user, boolean ishelpful, boolean isspoiler,int like,Movie movie) {
        this.id = id;
        this.title = title;
        this.about = about;
        this.user = user;
        this.ishelpful = ishelpful;
        this.isspoiler = isspoiler;
        this.like = like;
        this.movie = movie;
    }


    public static Review createAReview(Movie movie , User logedInUser) {
        boolean nspoil;
        boolean nhelp;
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
                newtitle, newabout, logedInUser, nhelp, nspoil, 0,movie);
        movie.reviews.add(newreview);
        main.reviewsDb.add(newreview);
        logedInUser.reviews.add(newreview);

        return newreview;
    }
}

