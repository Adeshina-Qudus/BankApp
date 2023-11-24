package BankApp;

import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Account> accounts;
    public Bank(){
        accounts = new ArrayList<>();
    }

    public Account registerAccount(String firstName, String lastName, String pin) {
        name = firstName+" "+lastName;
        return new Account(name,pin);
    }

    public void deposit(int accountNumber, int amount) {

    }

    public Account findAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.equals(accountNumber))
            }
        }
    }
}
