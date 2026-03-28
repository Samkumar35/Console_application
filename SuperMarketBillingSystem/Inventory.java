package SuperMarketBillingSystem;

public class Inventory {
    int productID;
    String productName;
    double price;
    int quantity;
    int soldCount;

    public Inventory(int productID, String productName, double price, int quantity){
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.soldCount = 0;
    }
}