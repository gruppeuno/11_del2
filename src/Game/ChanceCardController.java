package Game;

import java.util.Random;
import java.util.Scanner;

public class ChanceCardController {



    private static boolean cardUse;
    private int i;

    private int[] chanceArray;

    public ChanceCardController() {
        cardUse = false;
        i = 0;
        chanceArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    }

    //Tager vores arrays indhold, og sætter det i en tilfældig rækkefølge.
    public void randomizeChance() {

        Random rand = new Random();

        //TODO: skal testes - Den er blevet testet, bare ikke skrevet ind som en jUnit endnu..
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

    public void chanceCard(Player player, PlayerController playerController, FieldController fieldController) {

        System.out.println(player.getPlayerName() + " har trukket et chancekort");

        switch (chanceArray[i]) {

            case 1: //Chance Kort 1
                chancekort1();
                break;
            case 2: //Chance Kort 2
                chancekort2(player);
                break;
            case 3: //Chance Kort 3
                chancekort3(player, playerController);
                break;
            case 4: //Chance Kort 4
                chancekort4(player, playerController, fieldController);
                break;
            case 5: //Chance Kort 5
                chancekort5(player, playerController, fieldController);
                break;
            case 6: //Chance Kort 6
                chancekort6();
                break;
            case 7: //Chance Kort 7
                chancekort7(player);
                break;
            case 8: //Chance Kort 8
                chancekort8(player, playerController, fieldController);
                break;
            case 9: //Chance Kort 9
                chancekort9(player, playerController, fieldController);
                break;
            case 10: //Chance Kort 10
                chancekort10(player, playerController, fieldController);
                break;
            case 11://Chancekort 11
                chancekort11(player);
                break;
            case 12://Chancekort 12
                chancekort12(player, playerController);
                break;
            case 13://Chancekort 1
                chancekort13(player, playerController);
                break;
            case 14:
                chancekort14(player, playerController);
                break;
            case 15://Chancekort 15
                chancekort15(player, playerController, fieldController);
                break;
            case 16://Chancekort 16
                chancekort16(player);
                break;
            case 17://Chancekort 17
                chancekort17(player, playerController, fieldController);
                break;
            case 18://Chancekort 18
                chancekort18(player);
                break;
            case 19://Chancekort 19
                chancekort19(player, playerController, fieldController);
                break;
            case 20://Chancekort 20
                chancekort20(player, playerController, fieldController);
                break;
            default:
                System.out.println("Der skete en fejl");
        }
        if (i >= (chanceArray.length - 1)) {
            i = 0;} else {
            i++;
        }
}
    private void chancekort1() {
        System.out.println("System.out.println\nGiv dette kort til bilen, og tag et chancekort mere\n Bil på din næste tur skal du drøne frem til Hvilket som helst ledige felt og købe det\nHvis der ikke er nogen ledige felter, skal du købe et fra en anden spiller");
    }

    private void chancekort2(Player player) {
        System.out.println("Ryk frem til start og modtag 2M");
        moveToStart(player);
        addBank(player, 2);
    }

    private void chancekort3 (Player player, PlayerController playerController) {
        System.out.println("Ryk op til 5 felter frem");
        moveFieldPLayerSelect(player, 1, 5,playerController);
    }

    private void chancekort4 (Player player, PlayerController playerController, FieldController fieldController) {
        System.out.println("Gratis felt\nRyk frem til et Orange felt\nHvis det er ledigt, får du det Gratis!\nEllers skal du Betale leje til ejeren.");

        moveSpecificFieldRange(player, "Orange", 10, 11);
        takeFreeProperty(player, playerController, fieldController);
    }

    private void chancekort5 (Player player, PlayerController playerController, FieldController fieldController) {
        String valg;

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
        else if (valg.toLowerCase().equals(traek)) {
            i++;
            chanceCard(player, playerController, fieldController);}
    }

    private void chancekort6 () {
        System.out.println(">>>Ingen indhold<<<");
    }

    private void chancekort7 (Player player) {
        System.out.println("Du har spist for meget slik. Betal 2M til banken");
        subBank(player, 2);
    }

    private void chancekort8 (Player player, PlayerController playerController, FieldController fieldController) {
        System.out.println("Giv dette kort til Skibet, og tag et chancekort mere\n SKib på din næste tur skal du drøne frem til Hvilket som helst ledige felt og købe det\nHvis der ikke er nogen ledige felter, skal du købe et fra en anden spiller");
        moveSpecificFieldRange(player, "Orange", 10, 11, "Grøn", 19, 20);
        takeFreeProperty(player, playerController, fieldController);
    }

    private void chancekort9 (Player player, PlayerController playerController, FieldController fieldController) {
        System.out.println("Gratis felt\nRyk frem til et orange eller grønt felt\nHvis det er ledigt får du det Gratis. Ellers skal du betale leje til ejeren");
        moveSpecificFieldRange(player, "Lyseblå", 4, 5);
        takeFreeProperty(player, playerController, fieldController);
    }

    private void chancekort10 (Player player, PlayerController playerController, FieldController fieldController) {
        System.out.println("Gratis felt\nRyk frem til et lyseblåt felt\nHvis det er ledigt får du det Gratis. Ellers skal du betale leje til ejeren");
        if(!getJailCardUse() == true) {
            System.out.println("Du har fået ");
            adjustJailCard(player);
            setJailCardUse(true);
        }

        if (getJailCardUse() == true) {
            i++;
            chanceCard(player, playerController, fieldController);
        }
    }

    private void chancekort11 (Player player) {
        System.out.println("Ryk til Strandpromenaden");
        moveSpecificField(player, 23);
    }

    private void chancekort12 (Player player, PlayerController playerController) {
        System.out.println("Giv dette kort til katten, og tag et chancekort mere\n Kat på din næste tur skal du drøne frem til Hvilket som helst ledige felt og købe det\nHvis der ikke er nogen ledige felter, skal du købe et fra en anden spiller");
    }

    private void chancekort13 (Player player, PlayerController playerController) {
        System.out.println("Giv dette kort til Hunden, og tag et chancekort mere\nSkib på din næste tur skal du drøne frem til Hvilket som helst ledige felt og købe det\nHvis der ikke er nogen ledige felter, skal du købe et fra en anden spiller");
    }

    private void chancekort14 (Player player, PlayerController playerController) {
        bankFromAll(player, playerController);
    }

    private void chancekort15 (Player player, PlayerController playerController, FieldController fieldController) {
        System.out.println("Gratis felt.\nRyk frem til et Pink eller mørkeblåt felt\nHvis det er ledigt, får du det Gratis! Ellers skal du Betale leje til ejeren.");
        moveSpecificFieldRange(player, "Pink", 7, 8, "Mørkeblå", 22, 23);
        takeFreeProperty(player, playerController, fieldController);
    }

    private void chancekort16 (Player player) {
        System.out.println("Du har lavet alle dine lektier. Modtag 2M fra Banken");
        addBank(player, 2);
    }

    private void chancekort17 (Player player, PlayerController playerController, FieldController fieldController) {
        System.out.println("Gratis felt.\nRyk frem til et rødt felt.\nHvis det er ledigt, får du det Gratis! Ellers skal du Betale leje til ejeren");
        moveSpecificFieldRange(player, "Rød", 13, 14);
        takeFreeProperty(player, playerController, fieldController);
    }

    private void chancekort18 (Player player) {
        moveSpecificField(player,10);
    }

    private void chancekort19 (Player player, PlayerController playerController, FieldController fieldController) {
        System.out.println("Gratis felt\nRyk frem til et lyseblå eller grønt felt\nHvis det er ledigt får du det Gratis. Ellers skal du betale leje til ejeren");
        moveSpecificFieldRange(player, "Lyseblå", 4, 5, "Rød", 13, 14);
        takeFreeProperty(player, playerController, fieldController);
    }

    private void chancekort20 (Player player, PlayerController playerController, FieldController fieldController) {
        System.out.println("Gratis felt\nRyk frem til et brunt eller gult felt\nHvis det er ledigt får du det Gratis. Ellers skal du betale leje til ejeren");
        moveSpecificFieldRange(player, "Brun", 1, 2, "Gul", 16, 17);
        takeFreeProperty(player, playerController, fieldController);
    }

    public void moveField(Player player, int move) { ;
        player.setFieldNumber(player.getFieldNumber()+ move);
    }

    public void moveFieldPLayerSelect(Player player, int minField, int maxField, PlayerController playerController) {
        int move;

        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("Skriv et tal imellem " + minField + " og " + maxField);
            move = scan.nextInt(); }
        while (minField > move || maxField < move);

        playerController.movePlayer(player,move);
    }

    public void moveToStart(Player player) {
        player.setFieldNumber(0);
    }

    public void moveSpecificField(Player player, int field) {
        player.setFieldNumber(field);
    }

    public void moveSpecificFieldRange(Player player, String Color, int minMove, int maxMove) {
        int move;

        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("Vælg mellem felt " + minMove + " eller " + maxMove + " af farven " + Color + " på pladen");
            System.out.print("\nSkriv hvilket felt du ønsker her: ");
            move = scan.nextInt(); }
            while (!(minMove == move || maxMove == move));

            player.setFieldNumber(move);
        }

    public void moveSpecificFieldRange(Player player, String Color, int minMove, int maxMove, String Color2, int minMove2, int maxMove2) {
        int move;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("Vælg mellem felt " + minMove + " eller " + maxMove + " af farven " + Color + ", eller felt "
                    + minMove2 + " eller " + maxMove2 + " af farven " + Color2 + " på pladen");
            System.out.print("\nSkriv hvilket felt du ønsker her: ");
            move = scan.nextInt(); }
        while (!(minMove == move|| maxMove == move || minMove2 == move || maxMove2 == move));

        player.setFieldNumber(move);
    }

    public void addBank(Player player, int moneyChange) {
        player.bankAccount.addBalance(moneyChange);
    }

    public void subBank(Player player, int moneyChange) {
        player.bankAccount.subBalance(moneyChange);
    }

    public void adjustJailCard(Player player) {
        player.setJailCard(true);
    }

    public static void setJailCardUse(boolean cardUse) {
        ChanceCardController.cardUse = cardUse;
    }

    public boolean getJailCardUse() {
        return cardUse;
    }

    public void bankFromAll(Player player, PlayerController playerController) {

        for (Player tempPlayer : playerController.getPlayerArray()) {
            tempPlayer.bankAccount.subBalance(1);
        }

        player.bankAccount.addBalance(playerController.getPlayerArrayLength()+1);
    }

    public void takeFreeProperty(Player player, PlayerController playerController, FieldController fieldController) {
         fieldController.freeProperty(player, playerController);
   }
}

