package Exceptions;

public class ExpiredProductException extends Exception{
    public ExpiredProductException(String productName) {
        super(productName + " is expired and cannot be purchased.");
    }
}
