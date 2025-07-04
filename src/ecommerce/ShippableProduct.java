package ecommerce;

import ecommerce.Product;
import ecommerce.Shippable;

public class ShippableProduct extends Product implements Shippable {
    double Weight;
    double ShippingFees;
    public ShippableProduct(String name, double price, long quantity, double weight,double shippingFees){
        super(name,price,quantity);
        Weight=weight;
        ShippingFees=shippingFees;
    }
    public boolean isShippable() {
        return true;
    }
    public double getWeight(){
        return Weight;
    }
   public String getName(){
        return name;
   }
    public  double getShippingFees(){
        return ShippingFees;
    }
}
