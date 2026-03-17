package ATM;

import java.util.*;

public class User {
    private double userBalance = 1000.00;
    private final int userPin = 1234;

    public boolean authenticate(int enteredPin) {
        return this.userPin == enteredPin;
    }

    public void ShowUserMenu() {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- User Panel ---");
            System.out.println("1. View User Balance");
            System.out.println("2. Deposit Cash");
            System.out.println("3. Withdrawal Amount");
            System.out.println("4. Exiting");
            System.out.print("Enter your choice: ");

            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current User Balance: " + userBalance);
                    break;
                case 2:
                    System.out.println("Enter amount in multiples of 100, 200, or 500:");
                    int amount = scan.nextInt();
                    if (amount > 0 && (amount % 100 == 0)) {
                        userBalance += amount;
                        System.out.println("Successfully deposited: " + amount);
                    } else {
                        System.out.println("Invalid amount");
                    }
                    break;
                case 3:
                    System.out.println("Enter amount in multiples of 100, 200, or 500:");
                    amount = scan.nextInt();
                    if (amount > 0 && (amount % 100 == 0)) {
                        if (amount <= userBalance) {
                            userBalance -= amount;
                            System.out.println("Successfully Withdrawn: " + amount);
                        } else {
                            System.out.println("Insufficient Balance! Your current balance is: " + userBalance);
                        }
                    } else {
                        System.out.println("Invalid amount");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return; 
                default: 
                    System.out.println("Invalid choice");
            }
        }
    }
}
