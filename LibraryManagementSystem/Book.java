package LibraryManagementSystem;

public class Book {
    String name;
    String isbn;
    String author;
    double price;
    int quantity;
    int borrowedCount = 0;

    public Book(String name, String isbn, String author, double price, int quantity) {
        this.name = name;
        this.isbn = isbn;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }
}