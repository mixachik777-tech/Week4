package Day2;

// Класс Book — это ОДНА книга. Он только хранит данные про себя.
// Про список и про библиотеку он ничего не знает.
public class Book {
    // Поля — то, что помнит каждая книга. private = снаружи напрямую не влезть.
    private String title;    // название
    private String author;   // автор
    private boolean isRead;   // прочитана или нет

    // Конструктор — создаёт новую книгу и заполняет название и автора.
    // Новая книга всегда сначала НЕ прочитана, поэтому isRead = false.
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isRead = false;
    }

    // Сеттер — единственное, что у книги можно менять снаружи: статус прочитанности.
    public void setRead(boolean isRead) {
        this.isRead = isRead;
    }

    // Геттеры — дают ПРОЧИТАТЬ поля. Менять название и автора нельзя (сеттеров для них нет).
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isRead() {
        return isRead;
    }
}
