package Test;

import Game.BankAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTest {


    //test af addPropertyValue
    @Test
    void addPropertyValueTest(){
        BankAccount bankAccount = new BankAccount();
        bankAccount.addPropertyValue(5);

        int actual = 5;
        assertEquals(actual,bankAccount.getPropertyValue());
    }

}
