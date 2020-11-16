package Test;

import Game.Die;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DiceTest {

    @org.junit.jupiter.api.Test
    public void valueDiceTest() {
        Die diceTest = new Die();
        diceTest.roll();
        assertTrue(1 <= diceTest.getDiceValue() && diceTest.getDiceValue() <= 6);
    }

    @org.junit.jupiter.api.Test
    public void isDieRandom(){
        int totalDieValues = 0;
        boolean isRandom = false;

        Die diceTest = new Die();

        for (int testHundredRolls = 0; testHundredRolls < 100; testHundredRolls++){
            totalDieValues = 0;

            for (int thisRoll = 0; thisRoll < 1000; thisRoll++){
                diceTest.roll();
                diceTest.getDiceValue();
                totalDieValues += diceTest.getDiceValue();
            }
            //3% fejlmargin
            if (totalDieValues < 3605 && totalDieValues > 3395){
                isRandom = true;
            } else {
                isRandom = false;
            }

            System.out.println(totalDieValues);
        }

        assertTrue(isRandom);
    }
}
