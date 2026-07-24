package Day2;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void printAll() {
        for (Book book : books) {
            String status;
            if (book.isRead()) {
                status = "прочитана";
            } else {
                status = "не прочитана";
            }
            System.out.println(book.getTitle() + " - " + book.getAuthor() + " (" + status + ")");
        }
    }

    public Book findByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public int countRead() {
        int count = 0;
        for (Book book : books) {
            if (book.isRead()) {
                count++;
            }
        }
        return count;
    }
}
