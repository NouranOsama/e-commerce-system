import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            ExpirableProduct meat = new ExpirableProduct("Meat", 500.0f, 10, true, 0.5f, LocalDate.now().plusDays(7));
            Product tv = new Product("TV", 1000.0f, 5, true, 3.0f);

            Customer customer = new Customer("Nouran", 2000.0f);

            Cart cart = new Cart();
            cart.addToCart(tv, 1);
            cart.addToCart(meat, 3);

            ShippingService shippingService = new ShippingService();

            checkout(customer, cart, shippingService);
        } catch (Exception e) {
            System.out.println("Error during checkout: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void checkout(Customer customer, Cart cart, ShippingService shippingService) {
        double subtotal = cart.calculateSubtotal();
        double shippingFees = 30;
        double total = subtotal + shippingFees;

        if (customer.balance < total)
            throw new IllegalArgumentException("Insufficient balance!");

        customer.pay(total);
        ArrayList<Shippable> shippableItems = cart.getShippableItems();
        shippingService.shipItems(shippableItems);

        // Print checkout receipt
        System.out.println("** Checkout receipt **");
        for (Item item : cart.items) {
            System.out.println(item.quantity + "x " + item.product.getName() + " " + (item.quantity * item.product.price));
        }
        System.out.println("-------------------");
        System.out.println("Subtotal " + subtotal);
        System.out.println("Shipping " + shippingFees);
        System.out.println("Amount " + total);

        System.out.println("Checkout successful!: " + total);
        System.out.println("Current balance " + customer.balance);
    }
}