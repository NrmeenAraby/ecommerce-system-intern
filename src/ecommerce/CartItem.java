package ecommerce;

import ecommerce.Product;

public class CartItem {
    Product product;
    long quantity;

    public CartItem(Product product,long quantity){
        this.product=product;
        this.quantity=quantity;
    }
    public void updateQuantity(long more){
        quantity+=more;
    }
    public Product getProduct(){
        return product;
    }
    public long getQuantity(){
        return quantity;
    }
}
