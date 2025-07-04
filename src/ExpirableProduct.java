import java.time.LocalDate;

public class ExpirableProduct extends Product{

    LocalDate expiryDate;

    public ExpirableProduct(String name, double price, int quantity, boolean canBeShipped, float weight, LocalDate expiryDate) {
        super(name, price, quantity, canBeShipped, weight);
        this.expiryDate = expiryDate;
    }

    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }
}
