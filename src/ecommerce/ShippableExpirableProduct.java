package ecommerce;

import ecommerce.Product;
import ecommerce.Shippable;

import java.time.LocalDate;

public class ShippableExpirableProduct extends Product implements Shippable {
    private LocalDate expiryDate;
    private double weight;
    private double shippingFees;

    public ShippableExpirableProduct(String name, double price, long quantity,
                                     LocalDate expiryDate, double weight, double shippingFees) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
        this.weight = weight;
        this.shippingFees = shippingFees;
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    @Override
    public boolean isShippable() {
        return true;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public double getShippingFees() {
        return shippingFees;
    }
}
