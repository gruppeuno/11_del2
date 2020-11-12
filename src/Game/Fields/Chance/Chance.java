package Game.Fields.Chance;

import Game.Fields.Field;
import Game.Fields.Property;
import Game.Player;
import Game.PlayerController;

import java.util.Random;
import java.util.Scanner;

public class Chance extends Field {

    private static boolean cardUse = false;
    private int move = 0;
    private static int i = 0;

    private final int[] chanceArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

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
     * 3. lille ting, metoder skal være camelCase
     * <p>
     * Den første er den der kræver mest, og nummer to, hvis nummer 1 er lavet godt, så er nummer to bare insert, og se det virke.
     *
     * @param name        1
     * @param fieldNumber 1
     * @param msg         1
     */

    public Chance(String name, int fieldNumber, String msg) {
        super(name, fieldNumber, msg);
    }

    //Tager vores arrays indhold, og sætter det i en tilfældig rækkefølge.
    @Override
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

    public void ChanceCard(Player player, PlayerController playerController) {

        System.out.println("Du har trukket et chancekort");

        switch (chanceArray[i]) {

            case 1: //Chance Kort 1
                break;
            case 2: //Chance Kort 2
                System.out.println("Ryk frem til start og modtag 2M");
                MoveToStart(player);
                AddBank(player, 2);
                break;
            case 3: //Chance Kort 3
                System.out.println("Ryk op til 5 felter frem");
                MoveFieldPlayerSelect(player, 1, 5);
                break;
            case 4: //Chance Kort 4
                System.out.println("Gratis felt.");
                System.out.println("Ryk frem til et Orange felt.");
                System.out.println("Hvis det er ledigt, får du det GRATIS! Ellers skal du BETALE leje til ejeren.");
                break;
            case 5: //Chance Kort 5

                String valg = "";

                String ryk = "ryk";
                String traek = "træk";

                System.out.println("Vælg mellem at rykke 1 felt frem, eller trække et chance kort mere!");

                Scanner scan = new Scanner(System.in);
                do {
                    System.out.println("Skriv \"Ryk\" for ar rykke frem eller \"Træk\" for at trække et nyt chancekort.");
                    valg = scan.nextLine(); }
                while (!((traek.equals(valg.toLowerCase())) || (ryk.equals(valg.toLowerCase()))));

                if (valg.toLowerCase().equals(ryk)) {MoveField(player, 1);}
                else {ChanceCard(player, playerController);}

                scan.close();

                break;
            case 6: //Chance Kort 6
                break;
            case 7: //Chance Kort 7
                System.out.println("Du har spist for meget slik. Betal 2M til banken");
                SubBank(player, 2);
                break;
            case 8: //Chance Kort 8
                break;
            case 9: //Chance Kort 9
                break;
            case 10: //Chance Kort 10 //TODO: Vi skal have at når kortet bliver brugt, JailCardUse så bliver false igen.

                if(!getJailCardUse() == true) {
                    System.out.println("Du har fået ");
                    AdjustJailCard(player);
                    setJailCardUse(true);
                }

                if (getJailCardUse() == true) {
                    i++;
                    ChanceCard(player, playerController);
                }
                break;
            case 11://Chancekort 11
                System.out.println("Ryk til Strandpromenaden");
                MoveSpecificField(player, 23);
                break;
            case 12://Chancekort 12
                break;
            case 13://Chancekort 13
                break;
            case 14:
                BankFromAll(player, playerController);
                break;
            case 15://Chancekort 15
                break;
            case 16://Chancekort 16
                System.out.println("Du har lavet alle dine lektier. Modtag 2M fra Banken");
                AddBank(player, 2);
                break;
            case 17://Chancekort 17
                break;
            case 18://Chancekort 18
                MoveSpecificField(player,10);
                break;
            case 19://Chancekort 19
                break;
            case 20://Chancekort 20
                break;
            default:
                System.out.println("Der skete en fejl");
        }

        if (i == 19) {
            i = 1;}
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

    public void MoveSpecificField(Player player, int field) {
        player.setFieldNumber(field);
    }

    public void AddBank(Player player, int moneyChange) {
        player.b.addBalance(moneyChange);
    }

    public void SubBank(Player player, int moneyChange) {
        player.b.subBalance(moneyChange);
    }

    public void AdjustJailCard(Player player) {
        player.setJailCard(true);
    }

    private static void setJailCardUse(boolean cardUse) {
        Chance.cardUse = cardUse;
    }

    public boolean getJailCardUse() {
        return cardUse;
    }

    public void BankFromAll (Player player, PlayerController playerController) {

        for (Player tempPlayer : playerController.getPlayerArray()) {
            tempPlayer.b.subBalance(1);
        }

        player.b.addBalance(playerController.getPlayerArrayLength()+1);
    }


    private void FreeProperty(Player player, Property property){
        if (!player.b.getBankrupt()) {
        property.setOwner(player.getPlayerName());
        System.out.println(player.getPlayerName() + " fik " + property.getName() + " for " + property.getFieldPrice() + "M"); }
    }
}

