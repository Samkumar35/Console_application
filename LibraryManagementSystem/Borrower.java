package LibraryManagementSystem;

import java.util.*;

public class Borrower {
    String name, email, password;
    double deposit = 1500;
    List<Book> borrowedBooks = new ArrayList<>();
    List<String> fineHistory = new ArrayList<>();

    public Borrower(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}