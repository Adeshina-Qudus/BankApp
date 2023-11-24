package BankApp.Exception;

public class InvalidDepositException extends RuntimeException {

    public InvalidDepositException(String depositTooLow) {
        super(depositTooLow);
    }
}
