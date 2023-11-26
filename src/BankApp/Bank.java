package BankApp;

import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Account> accounts = new ArrayList<>();
    private int numberOfAccountCreated;
    public Account registerAccount(String firstName, String lastName, String pin) {
        name = firstName + " " + lastName;
        numberOfAccountCreated++;
        accounts.add(new Account(name,pin,generateAccountNumber()));
        return new Account(name,pin,generateAccountNumber());
    }
    public void deposit(int accountNumber, int amount) {
       findAccount(accountNumber).deposit(amount);
    }
    public int checkBalance(int accountNumber, String pin) {
        return findAccount(accountNumber).checkBalance(pin);
    }
    public Account findAccount(int accountNumber) {
        for (Account account : accounts) {
            if (accountNumber == account.getAccountNumber()) {
                return account;
            }
        }
        return null;
    }
    public int generateAccountNumber(){
        return numberOfAccountCreated;
    }
    public int getAccountNumberCreated() {
        return numberOfAccountCreated;
    }

    public void withdraw(int accountNumber, int amount, String pin) {
        findAccount(accountNumber).withdraw(amount,pin);
    }

    public void transfer(int sender, int receiver, int amount, String senderPin) {
        findAccount(sender).withdraw(amount,senderPin);
        findAccount(receiver).deposit(amount);
    }

    public void removeAccount(int accountNumber, String pin) {
        findAccount(accountNumber).validate(pin);
        numberOfAccountCreated--;
    }
}
