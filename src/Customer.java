public class Customer {
    String name;
    double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public void pay(double price) {
        this.balance -= price;
    }
}
