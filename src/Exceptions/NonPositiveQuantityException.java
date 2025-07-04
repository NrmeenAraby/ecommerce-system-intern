package Exceptions;

public class NonPositiveQuantityException extends Exception{
    public NonPositiveQuantityException(){
        super("Error: quantity must be at least 1.");
    }
}
