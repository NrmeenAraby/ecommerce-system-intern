package Exceptions;

public class CartEmptyException extends Exception{
    public CartEmptyException() {
        super("Cart is empty. Add items before checkout.");
    }
}
