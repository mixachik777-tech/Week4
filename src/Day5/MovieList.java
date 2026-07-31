package Day5;

import java.util.ArrayList;

public class MovieList {
    private ArrayList<Movie> movies;

    public MovieList() {
        movies = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void printAll() {
        if (movies.size() == 0) {
            System.out.println("Список пуст");
            return;
        }
        for (Movie movie : movies) {
            System.out.println(movie.getTitle() + " - " + genreText(movie.getGenre()) + " - рейтинг " + movie.getRating());
        }
    }

    public int countByGenre(MovieGenre genre) {
        int count = 0;
        for (Movie movie : movies) {
            if (movie.getGenre() == genre) {
                count++;
            }
        }
        return count;
    }

    public Movie findByTitle(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie;
            }
        }
        return null;
    }

    public String genreText(MovieGenre genre) {
        switch (genre) {
            case COMEDY:
                return "Комедия";
            case DRAMA:
                return "Драма";
            case ACTION:
                return "Боевик";
            case HORROR:
                return "Ужасы";
            default:
                return "Неизвестно";
        }
    }
}
