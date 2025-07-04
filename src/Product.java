public class Product implements Shippable{

    String name;
    double price;
    int quantity;
    boolean canBeShipped;
    float weight;

    public Product(String name,double price, int quantity,boolean canBeShipped,Float weight){
        this.name = name;
        this.price = price;
        this.quantity= quantity;
        this.canBeShipped = canBeShipped;
        this.weight = weight;

    }

    public boolean isExpired() {
        return false;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        
        if (canBeShipped) 
             return weight;
        else 
            return 0.0;

    }
}
