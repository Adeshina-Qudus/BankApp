package Test;

import BankApp.Account;
import BankApp.Exception.InsufficientFundsException;
import BankApp.Exception.InvalidPinException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    private Account account;
    @BeforeEach
    public void beforeEachOfTheTestRunThis(){
        account = new Account("Opay","2011");
    }
    @Test
    public void AccountIsNotEmptyTest(){
        assertNotNull(account);
    }
    @Test
    public void AccountCanBeDepositedIntoTest(){
        account.deposit(3_000);
        assertEquals(3_000,account.checkBalance("2011"));
    }
    @Test
    public void deposit_OneThousand_And_Withdraw_500_With_Invalid_Pin_Test(){
        account.deposit(1_000);
        assertThrows(InvalidPinException.class, ()-> account.withdraw(500,"qudus"));
    }
    @Test
    public void deposit_OneThousand_And_Withdraw_5_000_With_Correct_Pin_Test(){
        account.deposit(1_000);
        assertThrows(InsufficientFundsException.class, ()-> account.withdraw(5_000,"2011"));
    }

}