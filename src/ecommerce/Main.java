package ecommerce;

import java.time.LocalDate;
import Exceptions.*;
import ecommerce.Customer;
import ecommerce.Product;
import ecommerce.ShippableExpirableProduct;
import ecommerce.ShippableProduct;

public class Main {
    public static void main(String[] args) {
        // 1) Create products
        ShippableProduct cheese    = new ShippableProduct("Cheese", 100.0, 10, 200.0, 15.0);
        ShippableExpirableProduct chicken = new ShippableExpirableProduct(
                "chicken",
                400.0,
                10,
                LocalDate.of(2025, 12, 31),
                800.0,
                15.0
        );
        ShippableProduct biscuits  = new ShippableProduct("Biscuits", 150.0, 5, 700.0,0);
        Product scratchCard        = new Product("ScratchCard", 50.0, 10);

        // 2) Build cart & customer
        Cart cart       = new Cart();
        Customer customer = new Customer("user1","pass", 5000.0, cart);

        try {
            // 3) Add items
            cart.addProduct(cheese,      2);
            cart.addProduct(biscuits,    1);
            cart.addProduct(scratchCard, 1);
            cart.addProduct(chicken,1);

            // 4) Checkout
            customer.checkOut();

        } catch (NonPositiveQuantityException       |
                 ExpiredProductException   |
                 OutOfStockException       |
                 InsufficientBalanceException |
                 CartEmptyException          e) {
            System.err.println("error" + e.getMessage());
        }
    }
}
