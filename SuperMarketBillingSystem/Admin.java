package SuperMarketBillingSystem;

import java.util.*;

public class Admin {
    String email;
    String password;

    Scanner scan = new Scanner(System.in);

    public Admin(String email, String password){
        this.email = email;
        this.password = password;
    }

    public void adminMenu(){
        while(true){
            System.out.println("\n---Admin Menu---");
            System.out.println("1.Add Product 2.View Products 3.Add Credit 4.Modify Product 5.Delete Product 6.Search Product 7.Sort Products 8.Add Customer 9.Add Admin 10.Reports 11.Logout");

            int choice = scan.nextInt();

            switch(choice){
                case 1: addProduct(); break;
                case 2: viewProducts(); break;
                case 3: addCreditToCustomer(); break;
                case 4: modifyProduct(); break;
                case 5: deleteProduct(); break;
                case 6: searchProduct(); break;
                case 7: sortProducts(); break;
                case 8: addCustomer(); break;
                case 9: addAdmin(); break;
                case 10: reports(); break;
                case 11: return;
            }
        }
    }

    private void addProduct(){
        System.out.println("Enter Product ID:");
        int id = scan.nextInt();

        System.out.println("Enter Product Name:");
        String name = scan.next();

        System.out.println("Enter Price:");
        double price = scan.nextDouble();

        System.out.println("Enter Quantity:");
        int qty = scan.nextInt();

        DataStore.inventory.add(new Inventory(id, name, price, qty));
        System.out.println("Product added successfully!");
    }

    private void viewProducts(){
        for(Inventory i : DataStore.inventory){
            System.out.println(i.productID+" | "+i.productName+" | "+i.price+" | Qty:"+i.quantity);
        }
    }

    private void modifyProduct(){
        System.out.println("Enter Product ID:");
        int id = scan.nextInt();

        for(Inventory i : DataStore.inventory){
            if(i.productID == id){
                System.out.println("Enter New Price:");
                i.price = scan.nextDouble();

                System.out.println("Enter New Quantity:");
                i.quantity = scan.nextInt();

                System.out.println("Product updated!");
                return;
            }
        }

        System.out.println("Product not found!");
    }

    private void deleteProduct(){
        System.out.println("Enter Product ID:");
        int id = scan.nextInt();

        Iterator<Inventory> it = DataStore.inventory.iterator();

        while(it.hasNext()){
            Inventory i = it.next();
            if(i.productID == id){
                it.remove();
                System.out.println("Product deleted!");
                return;
            }
        }

        System.out.println("Product not found!");
    }

    private void searchProduct(){
        System.out.println("Enter Product Name:");
        String name = scan.next();

        for(Inventory i : DataStore.inventory){
            if(i.productName.equalsIgnoreCase(name)){
                System.out.println(i.productID+" | "+i.productName+" | "+i.price+" | Qty:"+i.quantity);
                return;
            }
        }

        System.out.println("Product not found!");
    }

    private void sortProducts(){
        System.out.println("1.Sort by Name 2.Sort by Price");
        int ch = scan.nextInt();

        if(ch == 1){
            DataStore.inventory.sort(Comparator.comparing(i -> i.productName));
        } else {
            DataStore.inventory.sort(Comparator.comparingDouble(i -> i.price));
        }

        viewProducts();
    }

    private void addCustomer(){
        scan.nextLine();

        System.out.println("Enter Name:");
        String name = scan.nextLine();

        System.out.println("Enter Email:");
        String email = scan.nextLine();

        System.out.println("Enter Password:");
        String pass = scan.nextLine();

        DataStore.customers.add(new Customer(name, email, pass));
        System.out.println("Customer added!");
    }

    private void addAdmin(){
        System.out.println("Enter Email:");
        String email = scan.next();

        System.out.println("Enter Password:");
        String pass = scan.next();

        DataStore.admins.add(new Admin(email, pass));
        System.out.println("Admin added!");
    }

    private void addCreditToCustomer(){
        System.out.println("Enter Customer Email:");
        String email = scan.next();

        for(Customer c : DataStore.customers){
            if(c.email.equals(email)){
                System.out.println("Enter Amount to Add:");
                double amount = scan.nextDouble();

                if(amount <= 0){
                    System.out.println("Invalid amount!");
                    return;
                }

                c.credit += amount;

                System.out.println("Credit added successfully!");
                System.out.println("Updated Credit: ₹" + c.credit);
                return;
            }
        }

        System.out.println("Customer not found!");
    }

    private void reports(){
        System.out.println("\n1.Low Stock 2.Unsold Products");
        int ch = scan.nextInt();

        if(ch == 1){
            for(Inventory i : DataStore.inventory){
                if(i.quantity < 10){
                    System.out.println(i.productName+" Low Stock: "+i.quantity);
                }
            }
        } 
        else if(ch == 2){
            for(Inventory i : DataStore.inventory){
                if(i.soldCount == 0){
                    System.out.println(i.productName+" not sold yet");
                }
            }
        }
    }
}