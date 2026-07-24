package Day1;

// Неделя 4, День 1 — инкапсуляция (закрытые поля).
//
// Главная идея дня: поля класса делаем private (закрытыми). Снаружи к ним
// нельзя обратиться напрямую. Работать с данными объекта можно только через
// его методы: конструктор задаёт начальное состояние, геттеры дают прочитать,
// сеттеры разрешают изменить — и только там, где изменение реально нужно,
// причём с проверкой данных внутри самого класса.

public class Day1Kwest1 {
    public static void main(String[] args) {
        // Создаём объект через конструктор — сразу с корректными данными.
        Student student = new Student("Михаил", 23);

        // Поля private, поэтому student.age напрямую написать НЕЛЬЗЯ.
        // Читаем значения только через геттеры:
        System.out.println("Имя: " + student.getName());
        System.out.println("Возраст: " + student.getAge());

        // Меняем возраст через сеттер. Внутри сеттера стоит проверка.
        student.setAge(24);   // корректно — запишется
        student.setAge(-5);   // некорректно — сеттер отклонит, возраст не изменится
        System.out.println("Возраст после правок: " + student.getAge());
        System.out.println();

        // Товар: отрицательная цена не пройдёт проверку.
        Product product = new Product("Молоко", 90);
        product.setPrice(-100);   // отклонится
        System.out.println(product.getName() + ": " + product.getPrice() + " руб.");
        System.out.println();

        // Книга: пустое название и не-положительное число страниц не примутся.
        Book book = new Book("Война и мир", "Толстой", 960);
        System.out.println(book.getTitle() + " / " + book.getAuthor() + ", страниц: " + book.getPages());
        System.out.println();

        // Задача: приоритет только 1..5, статус можно менять, название — нет.
        Task task = new Task("Купить хлеб", 3, false);
        task.setPriority(9);   // вне диапазона — отклонится, останется 3
        task.setDone(true);    // статус меняется — это разрешено
        System.out.println(task.getTitle() + " — приоритет " + task.getPriority() + ", выполнена: " + task.isDone());
    }
}

class Student {
    // private — поле видно ТОЛЬКО внутри класса Student.
    private String name;
    private int age;

    // Конструктор задаёт начальное состояние объекта.
    // Возраст проставляем через setAge, а не напрямую, чтобы проверка
    // работала и при создании объекта, и при любом последующем изменении.
    public Student(String name, int age) {
        this.name = name;
        setAge(age);
    }

    // Геттер — "дать доступ": позволяет только ПРОЧИТАТЬ имя.
    // Сеттера для name нет специально: имя задаётся при создании и не меняется.
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Сеттер — "разрешить изменить": принимает новое значение,
    // но записывает его только если данные корректны.
    public void setAge(int age) {
        // Возраст не может быть отрицательным — плохой ввод отсекаем.
        if (age >= 0) {
            this.age = age;
        }
    }
}

class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        setPrice(price);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    // Цена не может быть отрицательной.
    public void setPrice(int price) {
        if (price >= 0) {
            this.price = price;
        }
    }
}

class Book {
    private String title;
    private String author;
    private int pages;

    // Автор задаётся напрямую (проверять нечего), а название и страницы —
    // через сеттеры с проверкой.
    public Book(String title, String author, int pages) {
        this.author = author;
        setTitle(title);
        setPages(pages);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    // Название не должно быть пустым.
    public void setTitle(String title) {
        if (!title.isEmpty()) {
            this.title = title;
        }
    }

    // Число страниц должно быть больше нуля.
    public void setPages(int pages) {
        if (pages > 0) {
            this.pages = pages;
        }
    }
}

class Task {
    private String title;
    private int priority;
    private boolean isDone;

    public Task(String title, int priority, boolean isDone) {
        this.title = title;
        setPriority(priority);
        this.isDone = isDone;
    }

    public String getTitle() {
        return title;
    }

    public int getPriority() {
        return priority;
    }

    // Для boolean-поля геттер по соглашению называют isЧто-то, а не getЧто-то.
    public boolean isDone() {
        return isDone;
    }

    // Приоритет допустим только от 1 до 5.
    public void setPriority(int priority) {
        if (priority >= 1 && priority <= 5) {
            this.priority = priority;
        }
    }

    // Статус выполнения реально меняется по ходу работы, поэтому сеттер нужен.
    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }
}
