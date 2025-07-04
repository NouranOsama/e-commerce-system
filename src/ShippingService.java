import java.util.ArrayList;

public class ShippingService {
    public void shipItems(ArrayList<Shippable> items) {
        // Check if cart is empty
        if (items.isEmpty()) {
            System.out.println("Nothing to ship!");
            return;
        }

        System.out.println("**Shipment notice**");
        double total_weight = 0;
        String item_name = "";
        int count = 0;
        double item_weight = 0;

        for (Shippable item : items) {
            if (!item.getName().equals(item_name)) {
                if (!item_name.isEmpty()) {
                    System.out.println(count + "x " + item_name + " (" + (int)(item_weight * 1000) + "g each)");
                }
                item_name = item.getName();
                count = 1;
                item_weight = item.getWeight();
            } else {
                count++;
            }
            total_weight += item.getWeight();
        }
      
        if (!item_name.isEmpty()) {
            System.out.println(count + "x " + item_name + " (" + (int)(item_weight * 1000) + "g each)");
        }

        System.out.println("Total weight: " + total_weight + " kg\n");
    }
}