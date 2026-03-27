package LibraryManagementSystem;

import java.util.*;

public class LibrarySystem {

    Scanner sc = new Scanner(System.in);

    List<Book> books = new ArrayList<>();
    List<Borrower> borrowers = new ArrayList<>();
    List<Admin> admins = new ArrayList<>();

    public LibrarySystem() {
        admins.add(new Admin("admin@gmail.com", "admin123"));
        borrowers.add(new Borrower("User", "user@gmail.com", "user123"));
    }

    public void start() {
        while (true) {
            System.out.println("\n1. Login\n2. Exit");
            String choice = sc.nextLine();

            if (choice.equals("1")) login();
            else break;
        }
    }

    private void login() {
        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        for (Admin a : admins) {
            if (a.email.equals(email) && a.password.equals(password)) {
                adminMenu();
                return;
            }
        }

        for (Borrower b : borrowers) {
            if (b.email.equals(email) && b.password.equals(password)) {
                borrowerMenu(b);
                return;
            }
        }

        System.out.println("Invalid login!");
    }

    // ---------------- ADMIN ----------------
    private void adminMenu() {
        while (true) {
            System.out.println("\n---ADMIN---");
            System.out.println("1.Add 2.Modify 3.Delete 4.View(Name) 5.View(Qty) 6.AddUser 7.Logout");

            String ch = sc.nextLine();

            switch (ch) {
                case "1": addBook(); break;
                case "2": modifyBook(); break;
                case "3": deleteBook(); break;
                case "4": viewByName(); break;
                case "5": viewByQty(); break;
                case "6": addUser(); break;
                case "7": return;
            }
        }
    }

    private void addBook() {
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("ISBN: ");
        String isbn = sc.nextLine();

        System.out.print("Author: ");
        String author = sc.nextLine();

        System.out.print("Quantity: ");
        int qty = Integer.parseInt(sc.nextLine());

        System.out.print("Price: ");
        double price = Double.parseDouble(sc.nextLine());

        books.add(new Book(name, isbn, author, price, qty));
        System.out.println("Book Added!");
    }

    private void modifyBook() {
        System.out.print("Enter ISBN: ");
        String isbn = sc.nextLine();

        for (Book b : books) {
            if (b.isbn.equals(isbn)) {
                System.out.print("New Quantity: ");
                b.quantity = Integer.parseInt(sc.nextLine());
                System.out.println("Updated!");
                return;
            }
        }
    }

    private void deleteBook() {
        System.out.print("Enter ISBN: ");
        String isbn = sc.nextLine();

        books.removeIf(b -> b.isbn.equals(isbn));
        System.out.println("Deleted!");
    }

    private void viewByName() {
        books.sort(Comparator.comparing(b -> b.name));
        for (Book b : books) {
            System.out.println(b.name + " | Qty: " + b.quantity);
        }
    }

    private void viewByQty() {
        books.sort((a, b) -> b.quantity - a.quantity);
        for (Book b : books) {
            System.out.println(b.name + " | Qty: " + b.quantity);
        }
    }

    private void addUser() {
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Password: ");
        String pass = sc.nextLine();

        borrowers.add(new Borrower(name, email, pass));
        System.out.println("Borrower Added!");
    }

    // ---------------- BORROWER ----------------
    private void borrowerMenu(Borrower b) {
        while (true) {
            System.out.println("\n---BORROWER---");
            System.out.println("1.View Books 2.Borrow 3.Return 4.History 5.Logout");

            String ch = sc.nextLine();

            switch (ch) {
                case "1": viewBooks(); break;
                case "2": borrowBook(b); break;
                case "3": returnBook(b); break;
                case "4": showHistory(b); break;
                case "5": return;
            }
        }
    }

    private void viewBooks() {
        for (Book b : books) {
            System.out.println(b.name + " | ISBN: " + b.isbn + " | Qty: " + b.quantity);
        }
    }

    private void borrowBook(Borrower br) {
        if (br.deposit < 500) {
            System.out.println("Low deposit!");
            return;
        }

        if (br.borrowedBooks.size() >= 3) {
            System.out.println("Max 3 books!");
            return;
        }

        System.out.print("Enter ISBN: ");
        String isbn = sc.nextLine();

        for (Book b : books) {
            if (b.isbn.equals(isbn) && b.quantity > 0) {
                br.borrowedBooks.add(b);
                b.quantity--;
                b.borrowedCount++;
                System.out.println("Borrowed!");
                return;
            }
        }
    }

    private void returnBook(Borrower br) {
        System.out.print("Enter ISBN: ");
        String isbn = sc.nextLine();

        for (Book b : br.borrowedBooks) {
            if (b.isbn.equals(isbn)) {
                System.out.print("Days kept: ");
                int days = Integer.parseInt(sc.nextLine());

                double fine = 0;
                if (days > 15) fine = (days - 15) * 2;

                br.deposit -= fine;
                br.fineHistory.add("Fine: " + fine);

                b.quantity++;
                br.borrowedBooks.remove(b);

                System.out.println("Returned! Fine: " + fine);
                return;
            }
        }
    }

    private void showHistory(Borrower br) {
        System.out.println("Borrowed Books:");
        for (Book b : br.borrowedBooks) {
            System.out.println(b.name);
        }

        System.out.println("Fine History:");
        for (String f : br.fineHistory) {
            System.out.println(f);
        }
    }
}