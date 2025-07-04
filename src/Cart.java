import java.util.ArrayList;

public class Cart {
    ArrayList<Item> items = new ArrayList<Item>();

    public void addToCart(Product product, int quantity){
         if (quantity <= 0) 
            throw new IllegalArgumentException("Need positive quantity!");
        if (quantity > product.quantity) 
            throw new IllegalArgumentException("out of stock!");
        if (product.isExpired()) 
            throw new IllegalArgumentException("Item expired!");

    for (Item item : items) {
        if (item.product.equals(product)) {
            item.quantity += quantity;
            product.quantity -= quantity;
            return;
        }
    }
    items.add(new Item(product, quantity));
    product.quantity -= quantity;
    }
    
    public double calculateSubtotal() {
        double subtotal = 0;
        for (Item item : items) {
            subtotal += item.product.price * item.quantity;
        }
        return subtotal;
    }


    public ArrayList<Shippable> getShippableItems() {
        ArrayList<Shippable> shippableItems = new ArrayList<>();
        for (Item item : items) {
            if (item.product.canBeShipped) {
                for (int i = 0; i < item.quantity; i++) {
                    shippableItems.add(item.product);
                }
            }
        }
        return shippableItems;
    }
}

