package Day4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt(scanner);
            switch (choice) {
                case 1:
                    addBook(books, scanner);
                    break;
                case 2:
                    printBooks(books);
                    break;
                case 3:
                    findBook(books, scanner);
                    break;
                case 4:
                    changeStatus(books, scanner);
                    break;
                case 5:
                    deleteBook(books, scanner);
                    break;
                case 6:
                    printStatistics(books);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Нет такого пункта");
            }
        }

        System.out.println("Выход");
        scanner.close();
    }

    static void printMenu() {
        System.out.println();
        System.out.println("=== Меню ===");
        System.out.println("1 - Добавить книгу");
        System.out.println("2 - Вывести все книги");
        System.out.println("3 - Найти книгу по слову");
        System.out.println("4 - Изменить статус книги");
        System.out.println("5 - Удалить книгу по номеру");
        System.out.println("6 - Статистика");
        System.out.println("0 - Выход");
        System.out.print("Выберите пункт: ");
    }

    static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.print("Нужно ввести число. Повторите: ");
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    static void addBook(ArrayList<Book> books, Scanner scanner) {
        System.out.print("Название: ");
        String title = scanner.nextLine();
        System.out.print("Автор: ");
        String author = scanner.nextLine();
        books.add(new Book(title, author));
        System.out.println("Книга добавлена");
    }

    static void printBooks(ArrayList<Book> books) {
        if (books.size() == 0) {
            System.out.println("Список пуст");
            return;
        }
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            System.out.println((i + 1) + ". " + book.getTitle() + " - " + book.getAuthor() + " - " + statusText(book.getStatus()));
        }
    }

    static Book findByTitle(ArrayList<Book> books, String word) {
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(word.toLowerCase())) {
                return book;
            }
        }
        return null;
    }

    static void findBook(ArrayList<Book> books, Scanner scanner) {
        System.out.print("Введите слово для поиска: ");
        String word = scanner.nextLine();
        Book found = findByTitle(books, word);
        if (found != null) {
            System.out.println("Найдена: " + found.getTitle() + " - " + found.getAuthor());
        } else {
            System.out.println("Книга не найдена");
        }
    }

    static void changeStatus(ArrayList<Book> books, Scanner scanner) {
        if (books.size() == 0) {
            System.out.println("Список пуст");
            return;
        }
        printBooks(books);
        System.out.print("Номер книги: ");
        int number = readInt(scanner);
        int index = number - 1;
        if (index < 0 || index >= books.size()) {
            System.out.println("Нет книги с таким номером");
            return;
        }
        System.out.print("Новый статус (1 - запланирована, 2 - читаю, 3 - прочитана): ");
        int s = readInt(scanner);
        switch (s) {
            case 1:
                books.get(index).setStatus(BookStatus.PLANNED);
                break;
            case 2:
                books.get(index).setStatus(BookStatus.READING);
                break;
            case 3:
                books.get(index).setStatus(BookStatus.FINISHED);
                break;
            default:
                System.out.println("Нет такого статуса");
                return;
        }
        System.out.println("Статус изменён");
    }

    static void deleteBook(ArrayList<Book> books, Scanner scanner) {
        if (books.size() == 0) {
            System.out.println("Список пуст");
            return;
        }
        printBooks(books);
        System.out.print("Номер книги для удаления: ");
        int number = readInt(scanner);
        removeByIndex(books, number - 1);
    }

    static void removeByIndex(ArrayList<Book> books, int index) {
        if (index < 0 || index >= books.size()) {
            System.out.println("Нет книги с таким номером");
            return;
        }
        Book removed = books.remove(index);
        System.out.println("Удалена: " + removed.getTitle());
    }

    static void printStatistics(ArrayList<Book> books) {
        System.out.println("Всего книг: " + books.size());
        System.out.println("Запланировано: " + countByStatus(books, BookStatus.PLANNED));
        System.out.println("Читаю: " + countByStatus(books, BookStatus.READING));
        System.out.println("Прочитано: " + countByStatus(books, BookStatus.FINISHED));
    }

    static int countByStatus(ArrayList<Book> books, BookStatus status) {
        int count = 0;
        for (Book book : books) {
            if (book.getStatus() == status) {
                count++;
            }
        }
        return count;
    }

    static String statusText(BookStatus status) {
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
}
