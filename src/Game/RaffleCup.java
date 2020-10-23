package Game;

public class RaffleCup {

    //værdier der skal gemmes og de er private så deres scope er klassen
    private int die1;
    private int die2;

    public int roll() {
        //Max til at bruge math.random senere
        final int MAX = 6;
        die1 =(int)(Math.random() * MAX) + 1;
        die2 =(int)(Math.random() * MAX) + 1;
        return die1+die2;
    }

}
