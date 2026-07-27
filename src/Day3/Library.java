package Day3;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public int countByStatus(BookStatus status) {
        int count = 0;
        for (Book book : books) {
            if (book.getStatus() == status) {
                count++;
            }
        }
        return count;
    }

    public String statusText(BookStatus status) {
        switch (status) {
            case PLANNED:
                return "Запланирована";
            case READING:
                return "Читаю";
            case FINISHED:
                return "Прочитана";
            default:
                return "Неизвестно";
        }
    }

    public void printAll() {
        for (Book book : books) {
            System.out.println(book.getTitle() + " - " + book.getAuthor() + " - " + statusText(book.getStatus()));
        }
    }
}
