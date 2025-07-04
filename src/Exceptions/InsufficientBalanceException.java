package Exceptions;

public class InsufficientBalanceException extends Exception{
    public InsufficientBalanceException(double balance, double required) {
        super("Insufficient balance. You have " + balance
                + ", but need " + required);
    }
}
