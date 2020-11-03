package Test;

import Game.Dice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RaffleCupTest {

    @Test
    public void RaffleCupTestSum () {
        Dice RCT = new Dice();
        RCT.roll();
        assertTrue(2 <= RCT.getDiceValue() && RCT.getDiceValue()<= 12);
    }
}