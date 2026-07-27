package Day4;

public class Book {
    private String title;
    private String author;
    private BookStatus status;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.status = BookStatus.PLANNED;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public BookStatus getStatus() {
        return status;
    }
}
