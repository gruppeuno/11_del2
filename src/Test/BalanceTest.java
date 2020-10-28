package Test;

import Game.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalanceTest {

    @Test
    public void NumberOfPlayerTest() {
    int balance = 1000;

    RaffleCup dice = new RaffleCup();
    Field game = new Field();

    for (int i = 0; i <= 1000; i++) {
        dice.roll();
        game.setField(dice.getDiceValue());
        balance += game.getFieldValue();
        System.out.println(balance);
    }
        assertTrue(3000 <= balance);
    }
}