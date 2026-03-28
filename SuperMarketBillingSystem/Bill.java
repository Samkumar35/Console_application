package SuperMarketBillingSystem;

import java.util.*;

public class Bill {
    static int counter = 1;

    int billId;
    String customerEmail;
    double totalAmount;
    Date date;

    public Bill(String customerEmail, double totalAmount){
        this.billId = counter++;
        this.customerEmail = customerEmail;
        this.totalAmount = totalAmount;
        this.date = new Date();
    }
}