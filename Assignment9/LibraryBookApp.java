package Assignment9;

class Book {
    final String isbn;
    String title;
    String author;
    double price;

    Book(String isbn, String title, String author, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void display() {
        System.out.println("ISBN: " + isbn);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}

public class LibraryBookApp {
    public static void main(String[] args) {
        Book b = new Book("978-0134681", "Java DSA", "Vishrut Chinta", 999.00);
        b.display();
    }
}
