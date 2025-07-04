package ecommerce;

import Exceptions.*;
import ecommerce.CartItem;
import ecommerce.Product;
import ecommerce.Shippable;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Cart {
    private List<CartItem>items=new ArrayList<>();

    void addProduct(Product product, long quantity) throws NonPositiveQuantityException,
            ExpiredProductException,OutOfStockException{
        if(quantity<=0){
            throw new NonPositiveQuantityException();
        }
        if (product.isExpired()) {
            throw new ExpiredProductException(product.getName());
        }
        boolean found=false;
        for(CartItem item:items){
            Product prod=item.product;
            if(product.getName().equals(prod.getName())){
                long totalQuantity=quantity+item.getQuantity();
                if(!prod.isAvailable(totalQuantity)){
                    throw new OutOfStockException(prod.getName(),prod.getQuantity(),totalQuantity);
                }
                item.updateQuantity(quantity);
                found=true;
                break;
            }
        }
        if(!found) {
            if(!product.isAvailable(quantity)){
                throw new OutOfStockException(product.getName(),product.getQuantity(),quantity);
            }
            CartItem item = new CartItem(product, quantity);
            items.add(item);
            System.out.println(quantity + "x " + product.getName() + " added");
        }

    }
    boolean isEmpty(){
        return items.isEmpty();
    }
    List<Shippable> getShippableItems(){
        List<Shippable> shippable=new ArrayList<>();
        for (CartItem item:items){
            Product product=item.product;
            if(product.isShippable()){
                for(int count=0;count<item.quantity;count++){
                    shippable.add((Shippable)product);
                }
            }
        }
        return shippable;
    }
    double getSubTotal(){
        long subTotal=0;
        for (CartItem item:items){
            Product product=item.product;
            subTotal+=product.getPrice()*item.quantity;
        }

        return  subTotal;
    }

    public List<CartItem> getItems() {
        return Collections.unmodifiableList(items);
    }
    public void clear() {
        items.clear();
    }
}
