package Game;

import Game.Fields.Property;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class ChanceCardController {

    private static boolean cardUse = false;
    private static int i = 0;

    private static int[] chanceArray = {3};
    //private static int[] chanceArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

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
     */


    //Tager vores arrays indhold, og sætter det i en tilfældig rækkefølge.
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
                chancekort1();
                break;
            case 2: //Chance Kort 2
                chancekort2(player);
                break;
            case 3: //Chance Kort 3
                chancekort3(player, playerController);
                break;
            case 4: //Chance Kort 4
                chancekort4(player, playerController);
                break;
            case 5: //Chance Kort 5
                chancekort5(player, playerController);
                break;
            case 6: //Chance Kort 6
                chancekort6();
                break;
            case 7: //Chance Kort 7
                chancekort7(player);
                break;
            case 8: //Chance Kort 8
                chancekort8(player, playerController);
                break;
            case 9: //Chance Kort 9
                chancekort9(player, playerController);
                break;
            case 10: //Chance Kort 10 //TODO: Vi skal have at når kortet bliver brugt, JailCardUse så bliver false igen.
                chancekort10(player, playerController);
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
                chancekort15(player, playerController);
                break;
            case 16://Chancekort 16
                chancekort16(player);
                break;
            case 17://Chancekort 17
                chancekort17(player, playerController);
                break;
            case 18://Chancekort 18
                chancekort18(player);
                break;
            case 19://Chancekort 19
                chancekort19(player, playerController);
                break;
            case 20://Chancekort 20
                chancekort20(player, playerController);
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
        System.out.println(">>>Ingen indhold<<<");
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

    private void chancekort4 (Player player, PlayerController playerController) {
        System.out.println("Gratis felt.");
        System.out.println("Ryk frem til et Orange felt.");
        System.out.println("Hvis det er ledigt, får du det Gratis! Ellers skal du Betale leje til ejeren.");
        moveSpecificFieldRange(player, "Orange", 10, 11);
        TakeFreeProperty(player, playerController);
    }

    private void chancekort5 (Player player, PlayerController playerController) {
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
            chanceCard(player, playerController);}
    }

    private void chancekort6 () {
        System.out.println(">>>Ingen indhold<<<");
    }

    private void chancekort7 (Player player) {
        System.out.println("Du har spist for meget slik. Betal 2M til banken");
        subBank(player, 2);
    }

    private void chancekort8 (Player player, PlayerController playerController) {
        System.out.println("Gratis felt");
        System.out.println("Ryk frem til et orange eller grønt felt.");
        System.out.println("Hvis det er ledigt får du det Gratis. Ellers skal du betale leje til ejeren");
        moveSpecificFieldRange(player, "Orange", 10, 11, "Grøn", 19, 20);
        TakeFreeProperty(player, playerController);
    }

    private void chancekort9 (Player player, PlayerController playerController) {
        System.out.println("Gratis felt");
        System.out.println("Ryk frem til et lyseblåt felt.");
        System.out.println("Hvis det er ledigt får du det Gratis. Ellers skal du betale leje til ejeren");
        moveSpecificFieldRange(player, "Lyseblå", 4, 5);
        TakeFreeProperty(player, playerController);
    }

    private void chancekort10 (Player player, PlayerController playerController) {
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
    }

    private void chancekort11 (Player player) {
        System.out.println("Ryk til Strandpromenaden");
        moveSpecificField(player, 23);
    }

    private void chancekort12 (Player player, PlayerController playerController) {
        System.out.println(">>>Ingen indhold<<<");
    }

    private void chancekort13 (Player player, PlayerController playerController) {
        System.out.println(">>>Ingen indhold<<<");
    }

    private void chancekort14 (Player player, PlayerController playerController) {
        bankFromAll(player, playerController);
    }

    private void chancekort15 (Player player, PlayerController playerController) {
        System.out.println("Gratis felt.");
        System.out.println("Ryk frem til et Pink eller mørkeblåt felt.");
        System.out.println("Hvis det er ledigt, får du det Gratis! Ellers skal du Betale leje til ejeren.");
        moveSpecificFieldRange(player, "Pink", 7, 8, "Mørkeblå", 22, 23);
        TakeFreeProperty(player, playerController);
    }

    private void chancekort16 (Player player) {
        System.out.println("Du har lavet alle dine lektier. Modtag 2M fra Banken");
        addBank(player, 2);
    }

    private void chancekort17 (Player player, PlayerController playerController) {
        System.out.println("Gratis felt.");
        System.out.println("Ryk frem til et rødt felt.");
        System.out.println("Hvis det er ledigt, får du det Gratis! Ellers skal du Betale leje til ejeren.");
        moveSpecificFieldRange(player, "Rød", 13, 14);
        TakeFreeProperty(player, playerController);
    }

    private void chancekort18 (Player player) {
        moveSpecificField(player,10);
    }

    private void chancekort19 (Player player, PlayerController playerController) {
        moveSpecificFieldRange(player, "Lyseblå", 4, 5, "Rød", 13, 14);
        TakeFreeProperty(player, playerController);
    }

    private void chancekort20 (Player player, PlayerController playerController) {
        moveSpecificFieldRange(player, "Brun", 1, 2, "Gul", 16, 17);
        TakeFreeProperty(player, playerController);
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
            move = scan.nextInt(); }
        while (!(minMove == move|| maxMove == move || minMove2 == move || maxMove2 == move));

        player.setFieldNumber(move);
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
        ChanceCardController.cardUse = cardUse;
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

    //Total skrald løsning, men kan ikke lige komme på andet. Virker garanteret ikke..
    public void TakeFreeProperty(Player player, PlayerController playerController) {
         FieldController fieldController = new FieldController();
         fieldController.FreeProperty(player, playerController);
   }
}

