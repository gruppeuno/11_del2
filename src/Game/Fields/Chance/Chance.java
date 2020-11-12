package Game.Fields.Chance;

import Game.Fields.Field;
import Game.Player;
import Game.PlayerController;

import java.util.Random;
import java.util.Scanner;

public class Chance extends Field {

    private static boolean cardUse = false;
    private int move = 0;
    private static int i = 0;

    private static int[] chanceArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

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
    public void randomizeChance() {

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

    public void chanceCard(Player player, PlayerController playerController) {

        System.out.println("Du har trukket et chancekort");

        switch (chanceArray[i]) {

            case 1: //Chance Kort 1

                break;
            case 2: //Chance Kort 2
                System.out.println("Ryk frem til start og modtag 2M");
                moveToStart(player);
                addBank(player, 2);
                break;
            case 3: //Chance Kort 3
                System.out.println("Ryk op til 5 felter frem");
                moveFieldPLayerSelect(player, 1, 5);
                break;
            case 4: //Chance Kort 4
                System.out.println("Gratis felt.");
                System.out.println("Ryk frem til et Orange felt.");
                System.out.println("Hvis det er ledigt, får du det Gratis! Ellers skal du Betale leje til ejeren.");
                moveSpecificFieldRange(player, "Orange", 10, 11);
              //  FreeProperty(player, playerController);
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

                if (valg.toLowerCase().equals(ryk)) {
                    moveField(player, 1);}
                else {
                    chanceCard(player, playerController);}

                scan.close();

                break;
            case 6: //Chance Kort 6
                break;
            case 7: //Chance Kort 7
                System.out.println("Du har spist for meget slik. Betal 2M til banken");
                subBank(player, 2);
                break;
            case 8: //Chance Kort 8
                System.out.println("Gratis felt");
                System.out.println("Ryk frem til et orange eller grønt felt.");
                System.out.println("Hvis det er ledigt får du det Gratis. Ellers skal du betale leje til ejeren");
                break;
            case 9: //Chance Kort 9
                System.out.println("Gratis felt");
                System.out.println("Ryk frem til et lyseblåt felt.");
                System.out.println("Hvis det er ledigt får du det Gratis. Ellers skal du betale leje til ejeren");
                break;
            case 10: //Chance Kort 10 //TODO: Vi skal have at når kortet bliver brugt, JailCardUse så bliver false igen.
                System.out.println("Du løslades uden omkostninger");
                System.out.println("Behold dette kort, indtil du får brug for det");
                if(!getJailCardUse() == true) {
                    System.out.println("Du har fået ");
                    adjustJailCard(player);
                    setJailCardUse(true);
                }

                if (getJailCardUse() == true) {
                    i++;
                    chanceCard(player, playerController);
                }
                break;
            case 11://Chancekort 11
                System.out.println("Ryk til Strandpromenaden");
                moveSpecificField(player, 23);
                break;
            case 12://Chancekort 12

                break;
            case 13://Chancekort 13
                break;
            case 14:
                bankFromAll(player, playerController);
                break;
            case 15://Chancekort 15
                System.out.println("Gratis felt.");
                System.out.println("Ryk frem til et Pink eller mørkeblåt felt.");
                System.out.println("Hvis det er ledigt, får du det Gratis! Ellers skal du Betale leje til ejeren.");
                break;
            case 16://Chancekort 16
                System.out.println("Du har lavet alle dine lektier. Modtag 2M fra Banken");
                addBank(player, 2);
                break;
            case 17://Chancekort 17
                System.out.println("Gratis felt.");
                System.out.println("Ryk frem til et rødt felt.");
                System.out.println("Hvis det er ledigt, får du det Gratis! Ellers skal du Betale leje til ejeren.");
                break;
            case 18://Chancekort 18
                moveSpecificField(player,10);
                break;
            case 19://Chancekort 19
                break;
            case 20://Chancekort 20
                break;
            default:
                System.out.println("Der skete en fejl");
        }
        i++;

        if (i == 19) {
            i = 0;}
}

    public void moveField(Player player, int move) {

        this.move = move;
        player.setFieldNumber(player.getFieldNumber()+ this.move);
    }

    public void moveFieldPLayerSelect(Player player, int minField, int maxField) {
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("Skriv et tal imellem " + minField + " og " + maxField);
            this.move = scan.nextInt(); }
        while (minField > this.move || maxField < this.move);

        player.setFieldNumber(player.getFieldNumber()+this.move);
        scan.close();
    }

    public void moveToStart(Player player) {
        player.setFieldNumber(0);
    }

    public void moveSpecificField(Player player, int field) {
        player.setFieldNumber(field);
    }

    public void moveSpecificFieldRange(Player player, String Color, int minMove, int maxMove) {
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("Vælg mellem felt 1 eller 2 af farven " + Color);
            this.move = scan.nextInt(); }
        while (minMove > this.move || maxMove < this.move);

        player.setFieldNumber(this.move);
        scan.close();
    }

    public void addBank(Player player, int moneyChange) {
        player.b.addBalance(moneyChange);
    }

    public void subBank(Player player, int moneyChange) {
        player.b.subBalance(moneyChange);
    }

    public void adjustJailCard(Player player) {
        player.setJailCard(true);
    }

    public static void setJailCardUse(boolean cardUse) {
        Chance.cardUse = cardUse;
    }

    public boolean getJailCardUse() {
        return cardUse;
    }

    public void bankFromAll(Player player, PlayerController playerController) {

        for (Player tempPlayer : playerController.getPlayerArray()) {
            tempPlayer.b.subBalance(1);
        }

        player.b.addBalance(playerController.getPlayerArrayLength()+1);
    }

    @Override
    public void fieldAction(Player player, PlayerController playerController) {
        chanceCard(player, playerController);
    }

//    private void FreeProperty(Player player, PlayerController playerController){
//        if (property.getOwnedByPlayer()) {property.payRent(player, playerController);}
//        else {
//            if (!player.b.getBankrupt()) {
//                property.setOwner(player.getPlayerName());
//                System.out.println(player.getPlayerName() + " fik " + property.getName() + " for " + property.getFieldPrice() + "M"); }}
//    }
}

