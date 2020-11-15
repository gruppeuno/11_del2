package Game;

import gui_fields.GUI_Street;

/**
 * RaffleCup
 * @author Gruppe11
 */
public class Die {

    private int diceValue;

    /**
     * tildeler tilfældige værdier mellem 1-6 til die1 og die2, samt lægger dem sammen i dice value
     */
    public void roll() {
        //Max til at bruge math.random senere
        final int MAX = 6;
        diceValue =(int)(Math.random() * MAX) + 1;


    }

    //TODO: test terninger, til test af sellProperty
    private int diceRollCount = 0;
    public void rollPlayer0(){

        int[] player0Roll = {6,6,4,5,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3};
        diceValue=player0Roll[diceRollCount];
    }
    public void rollPlayer1() {//                v kino
        int[] player1Roll = {1, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2,4,4,4,4,4,4,4};
        diceValue=player1Roll[diceRollCount];
        diceRollCount++;
    }
    public int getDiceValue() { return diceValue; }


}
