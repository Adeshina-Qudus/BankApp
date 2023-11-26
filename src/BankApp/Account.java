package BankApp;

import BankApp.Exception.InsufficientFundsException;
import BankApp.Exception.InvalidDepositException;
import BankApp.Exception.InvalidPinException;

public class Account {
    private String name;
    private int balance;
    private String pin;
    private int accountNumber ;

    public Account(String name, String pin, int accountNumber) {
        this.name = name;
        this.pin = pin;
        this.accountNumber = accountNumber;
    }
    public void deposit(int amount) {
        validate(amount);
        balance += amount;
    }
    public int checkBalance(String pin) {
        validate(pin);
        return balance;
    }
    public void withdraw(int amount,String pin) {
        validate(pin);
        invalidFundsException(amount);
        balance -= amount;
    }
    public void validate(String pin)  {
        if (!pin.equals(this.pin)){
            throw new InvalidPinException("Invalid pin");
        }
    }
    public void invalidFundsException(int amount) {
        if (amount > balance) throw new InsufficientFundsException("insufficientFunds");
    }
    public void validate(int amount){
        if (amount < 1) throw new InvalidDepositException("deposit too low");
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String toString(){
        return  String.format("""
                1. Account Name  %s
                2. Account Number  %d
                3. Balance  %d
                """,name,accountNumber,balance);
    }
}
