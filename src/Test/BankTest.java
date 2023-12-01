package Test;

import BankApp.Account;
import BankApp.Bank;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankTest {


    @Test
    public void createAccountTest() {
        Bank bank = new Bank();
        Account account = bank.registerAccount("firstName", "lastName", "pin");
        assertEquals(1, account.getAccountNumber());
        assertEquals(1, bank.getAccountNumberCreated());
    }
    @Test
    public void testDeposit() {
        Bank bank = new Bank();
        Account account = bank.registerAccount("firstName", "lastName", "pin");
        bank.deposit(account.getAccountNumber(), 1000);
        assertEquals(1000, bank.checkBalance(1, "pin"));
    }
    @Test
    public void testWithdraw() {
        Bank bank = new Bank();
        Account account = bank.registerAccount("firstName", "lastName", "pin");
        bank.deposit(account.getAccountNumber(), 3000);
        bank.withdraw(account.getAccountNumber(), 2500, "pin");
        assertEquals(500,bank.checkBalance(1,"pin"));
    }
    @Test
    public void transferTest(){
        Bank bank = new Bank();
        Account accountOne = bank.registerAccount("firstName", "lastName", "1234");
        Account accountTwo = bank.registerAccount("first","last","2020");
        bank.deposit(accountOne.getAccountNumber(), 3000);
        bank.transfer(accountOne.getAccountNumber(),accountTwo.getAccountNumber(),2000,"1234");
        assertEquals(1000,bank.checkBalance(1,"1234"));
        assertEquals(2000,bank.checkBalance(2,"2020"));
    }
    @Test
    public void removeAccountTest(){
        Bank bank = new Bank();
        Account accountOne = bank.registerAccount("firstName", "lastName", "1234");
        bank.removeAccount(1,"1234");
        assertEquals(0,bank.getAccountNumberCreated());
    }

}