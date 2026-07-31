package Day5;

public class Movie {
    private String title;
    private MovieGenre genre;
    private int rating;

    public Movie(String title, MovieGenre genre, int rating) {
        this.title = title;
        this.genre = genre;
        setRating(rating);
    }

    public void setGenre(MovieGenre genre) {
        this.genre = genre;
    }

    public void setRating(int rating) {
        if (rating >= 1 && rating <= 10) {
            this.rating = rating;
        }
    }

    public boolean isHighRated() {
        return rating >= 8;
    }

    public String getTitle() {
        return title;
    }

    public MovieGenre getGenre() {
        return genre;
    }

    public int getRating() {
        return rating;
    }
}
