package SuperMarketBillingSystem;

public class CartItem {
    Inventory product;
    int quantity;

    public CartItem(Inventory product, int quantity){
        this.product = product;
        this.quantity = quantity;
    }
}