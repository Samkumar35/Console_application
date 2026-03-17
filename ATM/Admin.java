package ATM;

import java.util.*;

public class Admin {
    private double atmAmount = 100000.00;
    private final int adminPin = 0000; 

    public boolean authenticate(int enteredPin) {
        return this.adminPin == enteredPin;
    }

    public void ShowAdminMenu() {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Admin Control Panel ---");
            System.out.println("1. View ATM Balance");
            System.out.println("2. Deposit Cash");
            System.out.println("3. Exiting");
            System.out.print("Enter your choice: ");

            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current ATM Reserve: " + atmAmount);
                    break;
                case 2:
                    System.out.println("Enter amount in multiples of 100, 200, or 500:");
                    int amount = scan.nextInt();
                    if (amount > 0 && (amount % 100 == 0)) {
                        atmAmount += amount;
                        System.out.println("Successfully deposited: " + amount);
                    } else {
                        System.out.println("Invalid amount");
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return; 
                default: 
                    System.out.println("Invalid choice");
            }
        }
    }
}