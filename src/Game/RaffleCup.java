package Game;

public class RaffleCup {

    //gemmer dice, skal måske bruges i CDIO 3
    private int die1;
    private int die2;
    private final int MAX = 6;

    public int roll() {
        //Max til at bruge math.random senere
        die1 =(int)(Math.random() * MAX) + 1;
        die2 =(int)(Math.random() * MAX) + 1;
        return die1+die2;
    }

}
