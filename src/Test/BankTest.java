package Test;

import BankApp.Account;
import BankApp.Bank;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankTest {


    @Test
    public void createAccountTest(){
        Bank bank = new Bank();
        Account account = bank.registerAccount("firstName","lastName","pin");
        assertEquals(account,bank.findAccount(1));
    }



}