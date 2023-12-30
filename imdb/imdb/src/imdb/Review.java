package imdb;

public class Review {
    int id;
    String title;
    String about;
    User user;
    boolean ishelpful;
    boolean isspoiler;

    int like;

    public Review(int id, String title, String about, User user, boolean ishelpful, boolean isspoiler,int like) {
        this.id = id;
        this.title = title;
        this.about = about;
        this.user = user;
        this.ishelpful = ishelpful;
        this.isspoiler = isspoiler;
        this.like = like;
    }


}

