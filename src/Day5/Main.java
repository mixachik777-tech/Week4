package Day5;

public class Main {
    public static void main(String[] args) {
        MovieList list = new MovieList();

        list.addMovie(new Movie("Интерстеллар", MovieGenre.DRAMA, 9));
        list.addMovie(new Movie("Мальчишник в Вегасе", MovieGenre.COMEDY, 7));
        list.addMovie(new Movie("Крепкий орешек", MovieGenre.ACTION, 8));

        System.out.println("=== Все фильмы ===");
        list.printAll();

        System.out.println("Боевиков: " + list.countByGenre(MovieGenre.ACTION));
        System.out.println("Комедий: " + list.countByGenre(MovieGenre.COMEDY));

        Movie found = list.findByTitle("интерстеллар");
        if (found != null) {
            System.out.println("Найден: " + found.getTitle() + ", высокий рейтинг? " + found.isHighRated());
        } else {
            System.out.println("Фильм не найден");
        }

        Movie m = list.findByTitle("Мальчишник в Вегасе");
        if (m != null) {
            m.setGenre(MovieGenre.DRAMA);
        }

        System.out.println("=== После смены жанра ===");
        list.printAll();
    }
}
