package Day1;

public class Day1Kwest1 {
    public static void main(String[] args) {
        Student student = new Student("Михаил", 23);

        System.out.println("Имя: " + student.getName());
        System.out.println("Возраст: " + student.getAge());

        student.setAge(24);
        student.setAge(-5);
        System.out.println("Возраст после правок: " + student.getAge());
        System.out.println();

        Product product = new Product("Молоко", 90);
        product.setPrice(-100);
        System.out.println(product.getName() + ": " + product.getPrice() + " руб.");
        System.out.println();

        Book book = new Book("Война и мир", "Толстой", 960);
        System.out.println(book.getTitle() + " / " + book.getAuthor() + ", страниц: " + book.getPages());
        System.out.println();

        Task task = new Task("Купить хлеб", 3, false);
        task.setPriority(9);
        task.setDone(true);
        System.out.println(task.getTitle() + " — приоритет " + task.getPriority() + ", выполнена: " + task.isDone());
    }
}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        setAge(age);
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else  {
            System.out.println("Ошибка: возраст введен не корректно");
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        setPrice(price);
    }

    public void setPrice(int price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Ошибка: цена не может быть отрицательной");
        }
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

class Book {
    private String title;
    private String author;
    private int pages;

    public Book(String title, String author, int pages) {
        this.author = author;
        if (!title.isEmpty()) {
            this.title = title;
        } else {
            System.out.println("Ошибка: введите название книги");
        }
        if (pages > 0) {
            this.pages = pages;
        } else {
            System.out.println("Ошибка: введите количество страниц");
        }
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

    public void setPriority(int priority) {
        if (priority >= 1 && priority <= 5) {
            this.priority = priority;
        } else {
            System.out.println("Ошибка: приоритет должен быть от 1 до 5");
        }
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    public String getTitle() {
        return title;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isDone() {
        return isDone;
    }
}
