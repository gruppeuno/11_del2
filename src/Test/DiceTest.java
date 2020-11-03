package Test;

import Game.Dice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {

    @Test
    public void RaffleCupTest1 () {
        Dice RCT = new Dice();
        RCT.roll();
        assertTrue(1 <= RCT.getDie1Value() && RCT.getDie1Value()<= 6);
    }

    @Test
    public void RaffleCupTest2 () {
        Dice RCT = new Dice();
        RCT.roll();
        assertTrue(1 <= RCT.getDie2Value() && RCT.getDie2Value()<= 6);
    }

    @Test
    public void RaffleCupTestSum () {
        Dice RCT = new Dice();
        RCT.roll();
        assertTrue(1<= RCT.getDiceValue() && RCT.getDiceValue()<= 6);
    }
}