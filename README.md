## 🧪 Test Cases

---

### ✅ First Test Case
```java
ExpirableProduct cheese = new ExpirableProduct("Cheese", 100.0f, 10, true, 0.4f, LocalDate.now().plusDays(7));
ExpirableProduct biscuits = new ExpirableProduct("Biscuits", 150.0f, 5, true, 0.7f, LocalDate.now().plusDays(7));

cart.addToCart(cheese, 2);
cart.addToCart(biscuits, 1);
```
#### Terminal output:
#### Shipment notice

2x Cheese (400g each)

1x Biscuits (699g each)

Total weight: 1.5 kg

#### Checkout receip

2x Cheese 200.0

1x Biscuits 150.0

───────────────────

Subtotal 350.0

Shipping 30.0

Amount 380.0

Checkout successful!: 380.0

Current balance 1620.0

### ✅ Second Test Case
```java
ExpirableProduct meat = new ExpirableProduct("Meat", 500.0f, 2, true, 0.5f, LocalDate.now().plusDays(7));
Product tv = new Product("TV", 1000.0f, 5, true, 3.0f);

cart.addToCart(tv, 1);
cart.addToCart(meat, 3);
```
#### Terminal output:
Error during checkout: out of stock! “Insufficient quantity”

### ✅ Third Test Case
```java
ExpirableProduct meat = new ExpirableProduct("Meat", 500.0f, 10, true, 0.5f, LocalDate.now().plusDays(7));
Product tv = new Product("TV", 1000.0f, 5, true, 3.0f);

Customer customer = new Customer("Nouran", 2000.0f);

Cart cart = new Cart();
cart.addToCart(tv, 1);
cart.addToCart(meat, 3);
```
#### Terminal output:
Error during checkout: Insufficient balance! 
