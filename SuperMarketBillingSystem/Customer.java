package SuperMarketBillingSystem;

import java.util.*;

public class Customer {
    String name;
    String email;
    String password;

    double credit = 1000;
    int loyaltyPoints = 0;

    List<CartItem> cart = new ArrayList<>();

    Scanner scan = new Scanner(System.in);

    public Customer(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void userMenu(){
        while(true){
            System.out.println("\n---Customer Menu---");
            System.out.println("1.View Products 2.Add to Cart 3.View Cart 4.Edit Cart 5.Remove Item 6.Payment 7.History 8.Logout");

            int choice = scan.nextInt();

            switch(choice){
                case 1: viewProducts(); break;
                case 2: addToCart(); break;
                case 3: viewCart(); break;
                case 4: editCart(); break;
                case 5: removeFromCart(); break;
                case 6: payment(); break;
                case 7: viewHistory(); break;
                case 8: return;
            }
        }
    }

    private void viewProducts(){
        for(Inventory i : DataStore.inventory){
            System.out.println(i.productID+" | "+i.productName+" | "+i.price+" | Qty:"+i.quantity);
        }
    }

    private void addToCart(){
        System.out.println("Enter Product ID:");
        int id = scan.nextInt();

        for(Inventory i : DataStore.inventory){
            if(i.productID == id){
                System.out.println("Enter Quantity:");
                int qty = scan.nextInt();

                if(qty > i.quantity){
                    System.out.println("Only " + i.quantity + " items available!");
                    return;
                }

                for(CartItem c : cart){
                    if(c.product.productID == id){
                        if(c.quantity + qty > i.quantity){
                            System.out.println("Cannot add! Exceeds stock.");
                            return;
                        }
                        c.quantity += qty;
                        System.out.println("Updated quantity in cart!");
                        return;
                    }
                }

                cart.add(new CartItem(i, qty));
                System.out.println("Added to cart!");
                return;
            }
        }

        System.out.println("Product not found!");
    }

    private void editCart(){
        if(cart.isEmpty()){
            System.out.println("Cart is empty!");
            return;
        }

        System.out.println("Enter Product ID:");
        int id = scan.nextInt();

        for(CartItem c : cart){
            if(c.product.productID == id){
                System.out.println("Enter New Quantity:");
                int qty = scan.nextInt();

                if(qty > c.product.quantity){
                    System.out.println("Only " + c.product.quantity + " items available!");
                    return;
                }

                c.quantity = qty;
                System.out.println("Cart updated!");
                return;
            }
        }

        System.out.println("Product not in cart!");
    }

    private void removeFromCart(){
        if(cart.isEmpty()){
            System.out.println("Cart is empty!");
            return;
        }

        System.out.println("Enter Product ID:");
        int id = scan.nextInt();

        Iterator<CartItem> it = cart.iterator();

        while(it.hasNext()){
            CartItem c = it.next();
            if(c.product.productID == id){
                it.remove();
                System.out.println("Item removed from cart!");
                return;
            }
        }

        System.out.println("Product not found in cart!");
    }

    private void viewCart(){
        if(cart.isEmpty()){
            System.out.println("Cart is empty!");
            return;
        }

        double total = 0;

        for(CartItem c : cart){
            double cost = c.product.price * c.quantity;
            total += cost;
            System.out.println(c.product.productName+" x "+c.quantity+" = "+cost);
        }

        System.out.println("Total: "+total);
    }

    private void payment(){
        if(cart.isEmpty()){
            System.out.println("Cart is empty!");
            return;
        }

        double total = 0;

        for(CartItem c : cart){
            total += c.product.price * c.quantity;
        }

        for(CartItem c : cart){
            if(c.quantity > c.product.quantity){
                System.out.println("Stock changed! Not enough quantity for: " + c.product.productName);
                return;
            }
        }

        if(total > credit){
            System.out.println("Not enough credit!");
            return;
        }

        credit -= total;

        if(total >= 5000){
            credit += 100;
        } else {
            int earnedPoints = (int)(total / 100);
            loyaltyPoints += earnedPoints;

            if(loyaltyPoints >= 50){
                credit += 100;
                loyaltyPoints -= 50;
            }
        }

        for(CartItem c : cart){
            c.product.quantity -= c.quantity;
            c.product.soldCount += c.quantity;
        }

        DataStore.bills.add(new Bill(email, total));

        cart.clear();

        System.out.println("Payment Successful!");
        System.out.println("Total Paid: ₹" + total);        
        System.out.println("Remaining Credit: ₹" + credit);
    }

    private void viewHistory(){
        boolean found = false;

        for(Bill b : DataStore.bills){
            if(b.customerEmail.equals(email)){
                System.out.println("Bill ID: "+b.billId+" Amount: "+b.totalAmount+" Date: "+b.date);
                found = true;
            }
        }

        if(!found){
            System.out.println("No purchase history found!");
        }
    }
}