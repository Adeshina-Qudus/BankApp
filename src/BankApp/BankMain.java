package BankApp;

import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) {
        mainMenu();

    }
    private static Bank bank = new Bank();


    public static void displayMenu(){
        System.out.println("""
           ===============================
           +++++++++++++++++++++++++++++++
           
           1. Create Account
           2. Deposit
           3. Withdraw
           4. Transfer
           
           +++++++++++++++++++++++++++++++
           ===============================
                """);
    }

    public static void mainMenu(){
        displayMenu();
        String userInput = input("Enter Number Of Transaction You Wanna Perform");
        switch (userInput){
            case "1" :
                createAccount();
            case "2" :
                deposit();
            case "3" :
                withdraw();
            case "4" :
                transfer();
            default:
                System.exit(0);
        }
    }
    private static void createAccount() {
        String name = input("Enter First Name");
        String secondName = input("Enter Last name");
        String pin = input("Enter pin");
        Account accountRegister = bank.registerAccount(name,secondName,pin);
        print(accountRegister.toString());
        mainMenu();
    }
    public static void deposit(){
        int accountNumber = Integer.parseInt(input("Enter account number"));
        int amount = Integer.parseInt(input("Enter amount"));
        bank.deposit(accountNumber,amount);
        print(bank.findAccount(accountNumber).toString());
        mainMenu();
    }
    public static void withdraw(){
        int accountNumber = Integer.parseInt(input("Enter account number"));
        int amount = Integer.parseInt(input("Enter amount"));
        String pin = input("Enter Pin");
        bank.withdraw(accountNumber,amount,pin);
        print(bank.findAccount(accountNumber).toString());
        mainMenu();
    }
    public static void transfer(){
        int accountNumber = Integer.parseInt(input("Enter account number"));
        int accountNumber2 = Integer.parseInt(input("Enter account number"));
        int amount = Integer.parseInt(input("Enter amount"));
        String pin = input("Enter account number");
        bank.transfer(accountNumber,accountNumber2,amount,pin);
        print(bank.findAccount(accountNumber).toString());
    }
    private static void print(String message) {
        System.out.println(message);
    }

    private static String input(String message) {
        Scanner input = new Scanner(System.in);
        System.out.println(message);
        return input.nextLine();
    }


}
