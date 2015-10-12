package movieapplication.activity.com.designtesttwo.Classes;

public class DummyReviews {
    String review;
    String author;
    int avatar;

    public DummyReviews(String author, String review) {
        this.author = author;
        this.review = review;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }
}
