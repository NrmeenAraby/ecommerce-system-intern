package ecommerce;

public class Product {
    String name;
    private double price;
    long quantity;

    public Product(String name,double price,long quantity){
        this.name=name;
        this.price=price;
        this.quantity=quantity;

    }

    boolean isAvailable(long requestedQuantity){
        return this.quantity >= requestedQuantity;
    }
    boolean isExpired(){
        return false;
    }
    boolean isShippable(){
        return false;
    }
    public void reduceQuantity(long amount) {
        this.quantity -= amount;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public long getQuantity(){
        return quantity;
    }


}
