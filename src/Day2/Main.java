package Day2;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Война и мир", "Толстой");
        Book book2 = new Book("Преступление и наказание", "Достоевский");
        Book book3 = new Book("Идиот", "Достоевский");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        book1.setRead(true);
        book3.setRead(true);

        System.out.println("=== Все книги ===");
        library.printAll();

        System.out.println("Прочитано книг: " + library.countRead());

        Book found = library.findByTitle("идиот");
        if (found != null) {
            System.out.println("Найдена книга: " + found.getTitle() + " - " + found.getAuthor());
        } else {
            System.out.println("Книга не найдена");
        }
    }
}
