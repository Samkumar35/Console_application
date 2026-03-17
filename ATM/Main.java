package ATM;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        Admin adminObj = new Admin();
        User userObj = new User();

        System.out.println("--- Welcome to the ATM ---");
        System.out.println("Enter 1 for Admin access");
        System.out.println("Enter 2 for User access");

        int number = scan.nextInt();

        System.out.print("Enter your PIN: ");
        int pin = scan.nextInt();
        
        switch(number) {
            case 1:
                if (adminObj.authenticate(pin)) {
                    System.out.println("Login Successful!");
                    adminObj.ShowAdminMenu();
                } else {
                    System.out.println("Access Denied: Incorrect Admin PIN.");
                }
                break;
                
            case 2:
                if (userObj.authenticate(pin)) {
                    System.out.println("Login Successful!");
                    userObj.ShowUserMenu();
                } else {
                    System.out.println("Access Denied: Incorrect User PIN.");
                }
                break;
                
            default:
                System.out.println("Invalid Choice. Please restart.");
        }
        scan.close();
    }
}