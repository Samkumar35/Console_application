package ATM;

import java.util.Scanner;

public class Admin {
    private double atmAmount = 100000.00;
    private final int adminPin = 0000;

    public boolean authenticate(int enteredPin) {
        return this.adminPin == enteredPin;
    }

    public void showAdminMenu(Scanner scan) {
        while (true) {
            System.out.println("\n--- Admin Control Panel ---");
            System.out.println("1. View ATM Balance");
            System.out.println("2. Deposit Cash");
            System.out.println("3. Logout");
            int choice = readInt(scan, "Enter your choice: ");
            if (choice == -1) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            switch (choice) {
                case 1:
                    System.out.println("Current ATM Reserve: " + atmAmount);
                    break;
                case 2:
                    int amount = readInt(scan, "Enter amount (multiples of 100): ");
                    if (amount == -1) {
                        System.out.println("Invalid amount");
                        break;
                    }
                    if (amount > 0 && amount % 100 == 0) {
                        atmAmount += amount;
                        System.out.println("Successfully deposited: " + amount);
                    } else {
                        System.out.println("Invalid amount");
                    }
                    break;
                case 3:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private int readInt(Scanner scan, String prompt) {
        System.out.print(prompt);
        try {
            return Integer.parseInt(scan.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}