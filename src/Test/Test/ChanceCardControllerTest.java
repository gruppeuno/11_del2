package Test;

import Game.*;
import Game.Fields.ChanceCard;
import Game.Fields.Field;
import Game.Fields.Jail;
import Game.Fields.Property;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceCardControllerTest {

    @Test
    void randomizeChance() {

    }

   // @Test
   // void testToString() {
   // }

//    @Test
//    void chanceCard() { // et specifikt chancekort (ck 7)
//        Player testplayer = new Player("Testperson");
//        PlayerController playerController = new PlayerController();
//        FieldController fieldController = new FieldController();
//        ChanceCardController chanceCardController = new ChanceCardController();
//
//
//        playerController.setStartBalance();
//        chanceCardController.chanceCard(testplayer, playerController, fieldController);
//        chanceCard.();
//        int actual = testplayer.bankAccount.getBalance();
//        int expected = 1;
//
//        assertEquals(actual, expected);
//    }

    @Test
    void moveField() {
        Player testplayer = new Player("Testperson");
        ChanceCardController chanceCardController = new ChanceCardController();
        testplayer.setFieldNumber(0);
        chanceCardController.moveField(testplayer,10);
        int actual = testplayer.getFieldNumber();
        int expected = 10;
        assertEquals(actual, expected);

    }

    @Test
    void moveFieldPlayerSelect() {
        Player testplayer = new Player("Testperson");
        ChanceCardController chanceCardController = new ChanceCardController();
        int move;


    }
    //Test at spilleren rykker til start
    @Test
    void moveToStart() {
        Player testplayer = new Player("Testperson");
        ChanceCardController chanceCardController = new ChanceCardController();
        chanceCardController.moveToStart(testplayer);
        int actual =testplayer.getFieldNumber();
        int expected = 0;
        assertEquals(expected, actual);

    }

    @Test
    void moveSpecificField() {
    }

    @Test
    void addBank() {
        Player testplayer = new Player("Testperson");
        ChanceCardController chanceCardController = new ChanceCardController();
        BankAccount bankAccount = new BankAccount();

    }

    @Test
    void subBank() {
    }

    @Test
    void adjustJailCard() {
    }

    @Test
    void setJailCardUse() {
    }

    @Test
    void getJailCardUse() {
    }

    @Test
    void takeFreeProperty() {
        Player testplayer = new Player("Testperson");
        ChanceCardController chanceCardController = new ChanceCardController();
        FieldController fieldController = new FieldController();
        PlayerController playerController = new PlayerController();

        testplayer.setFieldNumber(4);
        chanceCardController.takeFreeProperty(testplayer, playerController, fieldController);
        int actual = testplayer.getTotalPropertyValue();
        int expected = 1;
        assertEquals(actual, expected);
    }


 /*   @Test
    void bankFromAll() {
        bankFromAll();
        assertTrue(3,bankFromAll());
    }*/
}