package Test;

import Game.Die;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DiceTest {

    @Test
    public void valueDiceTest() {
        Die DiceTest = new Die();
        DiceTest.roll();
        assertTrue(1 <= DiceTest.getDiceValue() && DiceTest.getDiceValue() <= 6);
    }
}