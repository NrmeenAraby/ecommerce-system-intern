package Exceptions;

public class OutOfStockException extends Exception{
    public OutOfStockException(String productName, long available, long requested) {
        super("Not enough stock for " + productName
                + " (available: " + available + ", requested: " + requested + ")");
    }
}
