package Game.Fields.Chance;

import Game.Fields.Field;
import Game.Player;

import java.util.Random;
import java.util.Scanner;

public class Chance extends Field {

    private int move = 0;
    private int bankValueChange = 0;
    private String valg = "";

    private final int[] chanceArray = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};

    public Chance(String name, int fieldNumber, String msg, int move) {
        super(name, fieldNumber, msg);
        this.move = move;

    }



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
            int random= rand.nextInt(chanceArray.length);
            int temp =chanceArray[random];
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

    public void ChanceCard(Player player) {

        System.out.println("Du har trukket et chancekort");

        int i;

        for (i = 1; i < chanceArray.length; i++) {

        switch (chanceArray[i]) {

            case 1: //Chance Kort 1
                break;
            case 2: //Chance Kort 2
                MoveToStart(player);
                ModifyBank(player, 2);
                break;
            case 3: //Chance Kort 3
                MoveFieldPlayerSelect(player, 1, 5);
                break;
            case 4: //Chance Kort 4
                break;
            case 5: //Chance Kort 5

                String ryk = "ryk";
                String traek = "træk";

                System.out.println("Vælg mellem at rykke 1 felt frem, eller trække et chance kort mere!");

                Scanner scan = new Scanner(System.in);
                do {
                    System.out.println("Skriv \"Ryk\" for ar rykke frem eller \"Træk\" for at trække et nyt chancekort ");
                    valg = scan.nextLine(); }
                while (!((traek.equals(valg.toLowerCase())) || (ryk.equals(valg.toLowerCase()))));

                if (valg.toLowerCase().equals(ryk)) {MoveField(player, 1);}
                else if (valg.toLowerCase().equals(traek)) {ChanceCard(player);}

                scan.close();

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

    public void MoveField(Player player, int move) {

        this.move = move;
        player.setFieldNumber(player.getFieldNumber()+ this.move);
    }

    public void MoveFieldPlayerSelect(Player player, int minMove, int maxMove) {
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("Skriv et tal imellem " + minMove + " og " + maxMove);
            this.move = scan.nextInt(); }
        while (minMove > this.move || maxMove < this.move);


        player.setFieldNumber(player.getFieldNumber()+this.move);
        scan.close();
    }

    public void MoveToStart(Player player) {
        player.setFieldNumber(0);
    }

    public void ModifyBank(Player player, int moneyChange) {

        bankValueChange = moneyChange;

        if (bankValueChange > 0) {
        player.b.addBalance(bankValueChange); }

        //Åndet, men nu bruger vi bare sub, når den er der. high cohesion and all.
        else if (bankValueChange < 0) {
        player.b.subBalance(Math.abs(bankValueChange));
        }


    }
}

