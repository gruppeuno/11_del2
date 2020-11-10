package Game.Fields.Chance;

import Game.Fields.Field;
import Game.Player;

import java.util.Random;

public class Chance extends Field {

    private final int[] chanceArray = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};

    public Chance(String name, int fieldNumber, String msg, int move) {
        super(name, fieldNumber, msg);
        this.move = move;
    }

    private int move = 0;

    /**
     * Todo list:
     * 1. Der skal laves en funktion der tage alle mulige chance kort og blander dem i en rækkefølge.
     * Denne rækkefølge er den rækkefølge den skal bruge i spillet. Når 1 kort bliver taget fra toppen af bunken,
     * så bliver det kort lagt ind i bunken igen. Nede i bunden.
     * 2. Disse kort skal så have en effekt. Der er allerede blevet lavet en metode som hedder move, men den tager udgangspunkt i terningen.
     * Vi kan bruge getFieldNumber, og tiløje eller trække nogle Fields fra, og så SetFieldNumber igen.
     *
     * Den første er den der kræver mest, og nummer to, hvis nummer 1 er lavet godt, så er nummer to bare insert, og se det virke.
     *
     *
     * @param name 1
     * @param fieldNumber 1
     * @param msg 1
     */

    public Chance(String name, int fieldNumber, String msg) {
        super(name, fieldNumber, msg);
    }

    //Tager vores arrays indhold, og sætter det i en tilfældig rækkefølge.
    public void RandomizeChance() {

        Random rand = new Random();

        for (int i = 0; i < chanceArray.length; i++) {
            int random = rand.nextInt(chanceArray.length);
            int temp = chanceArray[random];
            chanceArray[random] = chanceArray[i];
            chanceArray[i] = temp;
        }

    }

    public String toString() {

        String arrOut = "";

        for (int chArr : chanceArray) {

            arrOut += chArr + " ";
        }

        return arrOut;
    }

    public void ChanceCard() {

        int i;

        for (i = 1; i < chanceArray.length; i++) {

        switch (chanceArray[i]) {

            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                break;
            case 13:
                break;
            case 14:
                break;
            case 15:
                break;
            case 16:
                break;
            case 17:
                break;
            case 18:
                break;
            case 19:
                break;
            case 20:
                break;

        }

        if (i == 20 ) { i = 1; }
        }

    }
    public void MoveField(Player player, Field field) {

        player.setFieldNumber(player.getFieldNumber()+this.move);
    }

}

