package Day2;

// Main — точка запуска. Здесь ТОЛЬКО создаём объекты и вызываем методы.
// Никакой логики поиска/подсчёта прямо тут нет — всё это делает Library.
public class Main {
    public static void main(String[] args) {
        // 1. Создаём одну библиотеку (пока пустую).
        Library library = new Library();

        // 2. Создаём три книги — каждая отдельный объект.
        Book book1 = new Book("Война и мир", "Толстой");
        Book book2 = new Book("Преступление и наказание", "Достоевский");
        Book book3 = new Book("Идиот", "Достоевский");

        // 3. Отдаём книги библиотеке — она кладёт их в свой список.
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // 4. Двум книгам ставим статус "прочитана".
        book1.setRead(true);
        book3.setRead(true);

        // 5. Просим библиотеку распечатать все книги.
        System.out.println("=== Все книги ===");
        library.printAll();

        // 6. Просим посчитать прочитанные.
        System.out.println("Прочитано книг: " + library.countRead());

        // 7. Просим найти книгу по названию.
        Book found = library.findByTitle("идиот");
        if (found != null) {   // если что-то вернулось (не null) — книга есть
            System.out.println("Найдена книга: " + found.getTitle() + " - " + found.getAuthor());
        } else {               // если вернулся null — не нашли
            System.out.println("Книга не найдена");
        }
    }
}
