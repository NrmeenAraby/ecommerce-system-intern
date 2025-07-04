package ecommerce;

import Exceptions.*;
import ecommerce.CartItem;
import ecommerce.Product;

import java.util.List;

public class Customer {
    String username;
    private String password;
    double balance;
    Cart cart;

    public Customer(String username, String password, double balance, Cart cart){
        this.username=username;
        this.password=password;
        this.balance=balance;
        this.cart=cart;
    }

    public double calculateShippingFees(){
        double shippingFees=0;
        for(CartItem item:cart.getItems()){
            Product product = item.getProduct();
            long quantity = item.getQuantity();

            if (product instanceof Shippable) {
                Shippable sp = (Shippable) product;
                shippingFees += sp.getShippingFees() * quantity;
            }

        }
        return shippingFees;
    }
    public void checkOut() throws CartEmptyException, OutOfStockException,
            ExpiredProductException, InsufficientBalanceException {
        if (cart.isEmpty()) {
            throw new CartEmptyException();
        }
        double subtotal=cart.getSubTotal();
        double shippinFees=calculateShippingFees();
        for(CartItem item:cart.getItems()){
            Product product = item.getProduct();
            long quantity = item.getQuantity();

            // Out of stock
            if (!product.isAvailable(quantity)) {
                throw new OutOfStockException(product.getName(), product.getQuantity(), quantity);
            }

            // Expired product
            if (product.isExpired()) {
                throw new ExpiredProductException(product.getName());
            }

        }
        double totalAmount=subtotal+shippinFees;

        // Check customer balance
        if(totalAmount>this.balance){
            throw new InsufficientBalanceException(this.balance, totalAmount);
        }

        //checkout done successfully, so update data

        this.balance -= totalAmount;

        // Update product stock
        for(CartItem item:cart.getItems()){
            Product product = item.getProduct();
            product.reduceQuantity(item.getQuantity());
        }

        // Ship items
        List<Shippable> toShip = cart.getShippableItems();
        ShippingService.ship(toShip);

        //print receipt
        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + "      " + (item.getProduct().getPrice() * item.getQuantity()));
        }
        System.out.println("----------------------");
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Shipping: " + shippinFees);
        System.out.println("Amount paid: " + totalAmount);
        System.out.println("Remaining balance: " + balance);

        // Empty the cart after successful checkout
        cart.clear();


    }
}
