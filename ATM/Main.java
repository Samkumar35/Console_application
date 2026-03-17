package ATM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Admin admin = new Admin();
        List<User> users = new ArrayList<>();
        users.add(new User("Default", 1234, 1000.00));
        users.add(new User("Alice", 2345, 500.00));
        users.add(new User("Bob", 3456, 750.00));

        while (true) {
            System.out.println("\n--- Welcome to the ATM ---");
            System.out.println("1. Admin access");
            System.out.println("2. User access");
            System.out.println("3. Create new user account");
            System.out.println("4. Exit");
            int choice = readInt(scan, "Enter your choice: ");
            if (choice == -1) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            if (choice == 4) {
                System.out.println("Goodbye!");
                break;
            }
            if (choice == 1) {
                int pin = readInt(scan, "Enter admin PIN: ");
                if (pin == -1) {
                    System.out.println("Invalid PIN format");
                    continue;
                }
                if (admin.authenticate(pin)) {
                    System.out.println("Login Successful!");
                    admin.showAdminMenu(scan);
                } else {
                    System.out.println("Access Denied: Incorrect Admin PIN.");
                }
            } else if (choice == 2) {
                User user = selectUser(scan, users);
                if (user == null) {
                    continue;
                }
                int pin = readInt(scan, "Enter user PIN: ");
                if (pin == -1) {
                    System.out.println("Invalid PIN format");
                    continue;
                }
                if (user.authenticate(pin)) {
                    System.out.println("Login Successful!");
                    user.showMenu(scan);
                } else {
                    System.out.println("Access Denied: Incorrect User PIN.");
                }
            } else {
                createUser(scan, users);
            }
        }
        scan.close();
    }

    private static User selectUser(Scanner scan, List<User> users) {
        System.out.println("\nAvailable users:");
        for (int i = 0; i < users.size(); i++) {
            System.out.println((i + 1) + ". " + users.get(i).getName());
        }
        int choice = readInt(scan, "Select user: ");
        if (choice < 1 || choice > users.size()) {
            System.out.println("Invalid selection.");
            return null;
        }
        return users.get(choice - 1);
    }

    private static void createUser(Scanner scan, List<User> users) {
        System.out.println("\n--- Create New User Account ---");
        System.out.print("Enter user name: ");
        String name = scan.nextLine().trim();
        while (name.isEmpty()) {
            System.out.print("Name cannot be empty. Enter user name: ");
            name = scan.nextLine().trim();
        }
        int pin = readInt(scan, "Enter new PIN (numbers only): ");
        if (pin == -1) {
            System.out.println("Invalid PIN format.");
            return;
        }
        for (User existing : users) {
            if (existing.authenticate(pin)) {
                System.out.println("A user with this PIN already exists. Please choose a different PIN.");
                return;
            }
        }
        double startingBalance = readDouble(scan, "Enter starting balance: ", 0, Double.MAX_VALUE);
        users.add(new User(name, pin, startingBalance));
        System.out.println("Account created successfully for " + name + "!");
    }

    private static double readDouble(Scanner scan, String prompt, double min, double max) {
        while (true) {
            System.out.print(prompt);
            String line = scan.nextLine();
            try {
                double value = Double.parseDouble(line.trim());
                if (value < min || value > max) {
                    System.out.println("Please enter a number between " + min + " and " + max);
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter numbers only.");
            }
        }
    }

    private static int readInt(Scanner scan, String prompt) {
        System.out.print(prompt);
        try {
            return Integer.parseInt(scan.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}