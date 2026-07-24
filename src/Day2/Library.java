package Day2;

import java.util.ArrayList;

// Класс Library — БИБЛИОТЕКА. Он держит список книг и умеет с ним работать.
// Сам список книг живёт ЗДЕСЬ, внутри библиотеки.
public class Library {
    // Поле — список книг этой библиотеки. Тоже private.
    private ArrayList<Book> books;

    // Конструктор — при создании библиотеки список ПУСТОЙ.
    public Library() {
        books = new ArrayList<>();
    }

    // Положить книгу в список. Объект book приходит снаружи (из main).
    public void addBook(Book book) {
        books.add(book);
    }

    // Распечатать все книги: идём по списку и печатаем каждую.
    public void printAll() {
        for (Book book : books) {          // берём книги по очереди
            String status;                 // готовим текст статуса
            if (book.isRead()) {           // спрашиваем у книги через геттер
                status = "прочитана";
            } else {
                status = "не прочитана";
            }
            // печатаем данные книги — снова через геттеры, т.к. поля у Book private
            System.out.println(book.getTitle() + " - " + book.getAuthor() + " (" + status + ")");
        }
    }

    // Найти книгу по названию. Возвращаем найденную книгу или null, если такой нет.
    public Book findByTitle(String title) {
        for (Book book : books) {                          // перебираем все книги
            if (book.getTitle().equalsIgnoreCase(title)) { // сравниваем название без учёта регистра
                return book;                               // нашли — сразу отдаём и выходим
            }
        }
        return null;                                       // дошли до конца, ничего не нашли
    }

    // Посчитать прочитанные книги. Счётчик, как в третьей неделе.
    public int countRead() {
        int count = 0;                 // копилка
        for (Book book : books) {      // идём по всем книгам
            if (book.isRead()) {       // если книга прочитана
                count++;               // прибавляем 1
            }
        }
        return count;                  // отдаём итог
    }
}
