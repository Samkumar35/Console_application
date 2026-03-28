package SuperMarketBillingSystem;

import java.util.*;

public class BillingSystem {
    Scanner scan = new Scanner(System.in);

    public BillingSystem(){
        DataStore.admins.add(new Admin("admin@gmail.com","admin123"));
        DataStore.customers.add(new Customer("User","user@gmail.com","user123"));
    }

    public void start(){
        while(true){
            System.out.println("\n1.Login\n2.Exit");
            int ch = scan.nextInt();

            if(ch==1) login();
            else break;
        }
    }

    private void login(){
        scan.nextLine();

        System.out.println("Email:");
        String email = scan.nextLine();

        System.out.println("Password:");
        String pass = scan.nextLine();

        for(Admin a : DataStore.admins){
            if(a.email.equals(email) && a.password.equals(pass)){
                a.adminMenu();
                return;
            }
        }

        for(Customer c : DataStore.customers){
            if(c.email.equals(email) && c.password.equals(pass)){
                c.userMenu();
                return;
            }
        }

        System.out.println("Invalid Login!");
    }
}