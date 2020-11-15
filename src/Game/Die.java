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

    //TODO: test terninger
    private int diceRollCount = 0;
    public void rollPlayer0(){
        int[] player0Roll = {6,6,4,5,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3};
    }
    public void rollPlayer1(){
        int[] player0Roll = {1,1,2,1,2,
    }

    public int getDiceValue() { return diceValue; }


}
