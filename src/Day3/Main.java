package Day3;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Война и мир", "Толстой");
        Book book2 = new Book("Преступление и наказание", "Достоевский");
        Book book3 = new Book("Мастер и Маргарита", "Булгаков");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        book1.setStatus(BookStatus.FINISHED);
        book2.setStatus(BookStatus.READING);

        library.printAll();

        System.out.println("Прочитано: " + library.countByStatus(BookStatus.FINISHED));
        System.out.println("Читаю: " + library.countByStatus(BookStatus.READING));
        System.out.println("Запланировано: " + library.countByStatus(BookStatus.PLANNED));
    }
}
