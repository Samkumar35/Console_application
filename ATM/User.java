package ATM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    private final String name;
    private double balance;
    private final int pin;

    public User(String name, int pin, double startingBalance) {
        this.name = name;
        this.pin = pin;
        this.balance = startingBalance;
    }

    public String getName() {
        return name;
    }

    public boolean authenticate(int enteredPin) {
        return this.pin == enteredPin;
    }

    public void showMenu(Scanner scan) {
        while (true) {
            System.out.println("\n--- User Panel (" + name + ") ---");
            System.out.println("1. View Balance");
            System.out.println("2. Deposit Cash");
            System.out.println("3. Withdraw Cash");
            System.out.println("4. Logout");
            int choice = readInt(scan, "Enter your choice: ");
            if (choice == -1) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            switch (choice) {
                case 1:
                    System.out.println("Current Balance: " + balance);
                    break;
                case 2:
                    int deposit = readInt(scan, "Enter amount (multiples of 100): ");
                    if (deposit <= 0 || deposit % 100 != 0) {
                        System.out.println("Invalid amount");
                        break;
                    }
                    balance += deposit;
                    System.out.println("Deposited: " + deposit);
                    break;
                case 3:
                    int withdraw = readInt(scan, "Enter amount (multiples of 100): ");
                    if (withdraw <= 0 || withdraw % 100 != 0) {
                        System.out.println("Invalid amount");
                        break;
                    }
                    if (withdraw > balance) {
                        System.out.println("Insufficient Balance! Your current balance is: " + balance);
                        break;
                    }
                    balance -= withdraw;
                    System.out.println("Withdrawn: " + withdraw);
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private int readInt(Scanner scan, String prompt) {
        System.out.print(prompt);
        String line = scan.nextLine();
        try {
            return Integer.parseInt(line.trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

}
