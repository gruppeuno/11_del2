package Game;

public class RaffleCup {

    private int die1;
    private int die2;

    public void roll() {
        //Max til at bruge math.random senere
        final int MAX = 6;
        die1 =(int)(Math.random() * MAX) + 1;
        die2 =(int)(Math.random() * MAX) + 1;
    }

    public int getDiceValue() {return die1+die2;}
    public int getDie1Value() { return die1; }
    public int getDie2Value() { return die2; }

}
