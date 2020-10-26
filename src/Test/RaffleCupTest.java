package Test;

import Game.RaffleCup;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RaffleCupTest {

    @Test
    public void RaffleCupTest1 () {
        RaffleCup RCT = new RaffleCup();
        RCT.roll();
        assertTrue(1 <= RCT.getDie1Value() && RCT.getDie1Value()<= 6);
    }

    @Test
    public void RaffleCupTest2 () {
        RaffleCup RCT = new RaffleCup();
        RCT.roll();
        assertTrue(1 <= RCT.getDie2Value() && RCT.getDie2Value()<= 6);
    }

    @Test
    public void RaffleCupTestSum () {
        RaffleCup RCT = new RaffleCup();
        RCT.roll();
        assertTrue(2 <= RCT.getDiceValue() && RCT.getDiceValue()<= 12);
    }

}