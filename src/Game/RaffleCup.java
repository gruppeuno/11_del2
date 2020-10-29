package Game;

import gui_fields.GUI_Street;

/**
 * RaffleCup
 * @author Gruppe11
 */
public class RaffleCup {

    private int die1;
    private int die2;
    private int diceValue;

    /**
     * tildeler tilfældige værdier mellem 1-6 til die1 og die2, samt lægger dem sammen i dice value
     */
    public void roll() {
        //Max til at bruge math.random senere
        final int MAX = 6;
        die1 =(int)(Math.random() * MAX) + 1;
        die2 =(int)(Math.random() * MAX) + 1;
        diceValue = die1+die2;
    }

    public int getDiceValue() {return diceValue;}
    public int getDie1Value() { return die1; }
    public int getDie2Value() { return die2; }

}
