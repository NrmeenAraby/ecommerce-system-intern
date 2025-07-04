package Exceptions;

public class nonPositiveQuantity extends Exception{
    public nonPositiveQuantity(){
        super("Error: quantity must be at least 1.");
    }
}
