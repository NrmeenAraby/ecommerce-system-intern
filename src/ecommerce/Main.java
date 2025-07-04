package ecommerce;

import java.time.LocalDate;
import Exceptions.*;

public class Main {
    public static void main(String[] args) {
        // --- Products ---
        ShippableProduct cheese = new ShippableProduct("Cheese", 100.0, 10, 200.0, 15.0);
        ShippableExpirableProduct chicken = new ShippableExpirableProduct(
                "Chicken", 400.0, 10,
                LocalDate.of(2025, 12, 31),
                800.0, 20.0
        );
        ShippableProduct biscuits = new ShippableProduct("Biscuits", 150.0, 5, 700.0, 10.0);
        Product scratchCard = new Product("ScratchCard", 50.0, 10);
        ExpirableProduct expiredMilk = new ExpirableProduct("Milk", 50.0, 5, LocalDate.of(2023, 1, 1));

        // --- Cart & Customer ---
        Cart cart = new Cart();
        Customer customer = new Customer("user1", "pass", 1000.0, cart);

        try {
            // Normal products
            cart.addProduct(cheese, 2);      // 200
            cart.addProduct(biscuits, 1);    // 150
            cart.addProduct(scratchCard, 1); // 50
            cart.addProduct(chicken, 1);     // 400

            //>>>> Uncomment to test expired
            // cart.addProduct(expiredMilk, 1);

            // >>>> Uncomment to test out of stock
            // cart.addProduct(cheese, 100);

            // >>>> Uncomment to test negative quantity
             //cart.addProduct(cheese, -1);

            // >>>> Uncomment to test insufficient balance
            // customer = new Customer("user2", "pass", 10.0, cart);

            // --- CHECKOUT ---
            customer.checkOut();

        } catch (NonPositiveQuantityException |
                 ExpiredProductException     |
                 OutOfStockException         |
                 InsufficientBalanceException|
                 CartEmptyException e) {
            System.err.println("Catch  " + e.getMessage());
        }
    }
}
