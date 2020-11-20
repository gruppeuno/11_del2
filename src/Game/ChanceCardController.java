package Game;

import Game.Fields.Property;

import java.util.Random;
import java.util.Scanner;

//TODO: der bliver ikke købt en grund når man lander 5 felter fremmme
public class ChanceCardController {



    private static boolean cardUse;
    private int i;
    private int tempMove;

    private int[] chanceArray;

    public ChanceCardController() {
        cardUse = false;
        i = 0;
        chanceArray = new int[]{1,2};
        //chanceArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
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

    public void chanceCard(Player player, PlayerController playerController, FieldController fieldController, GUIView guiView) {

        System.out.println("C H A N C E K O R T");

        switch (chanceArray[i]) {

            case 1: //Chance Kort 1
                chancekort1(player, playerController, fieldController, guiView);
                break;
            case 2: //Chance Kort 2
                chancekort2(player);
                break;
            case 3: //Chance Kort 3
                chancekort3(player, playerController);
                break;
            case 4: //Chance Kort 4
                chancekort4(player, playerController, fieldController, guiView);
                break;
            case 5: //Chance Kort 5
                chancekort5(player, playerController, fieldController, guiView);
                break;
            case 6: //Chance Kort 6
                chancekort6(player, playerController, fieldController, guiView);
                break;
            case 7: //Chance Kort 7
                chancekort7(player);
                break;
            case 8: //Chance Kort 8
                chancekort8(player, playerController, fieldController, guiView);
                break;
            case 9: //Chance Kort 9
                chancekort9(player, playerController, fieldController, guiView);
                break;
            case 10: //Chance Kort 10
                chancekort10(player, playerController, fieldController, guiView);
                break;
            case 11://Chancekort 11
                chancekort11(player);
                break;
            case 12://Chancekort 12
                chancekort12(player, playerController, fieldController, guiView);
                break;
            case 13://Chancekort 1
                chancekort13(player, playerController, fieldController, guiView);
                break;
            case 14:
                chancekort14(player, playerController);
                break;
            case 15://Chancekort 15
                chancekort15(player, playerController, fieldController, guiView);
                break;
            case 16://Chancekort 16
                chancekort16(player);
                break;
            case 17://Chancekort 17
                chancekort17(player, playerController, fieldController, guiView);
                break;
            case 18://Chancekort 18
                chancekort18(player);
                break;
            case 19://Chancekort 19
                chancekort19(player, playerController, fieldController, guiView);
                break;
            case 20://Chancekort 20
                chancekort20(player, playerController, fieldController, guiView);
                break;
            default:
                System.out.println("Der skete en fejl");
        }
        if (i > (chanceArray.length - 1)) {
            i = 0;
        } else {
            i++;
        }
}
    private void chancekort1 (Player player, PlayerController playerController, FieldController fieldController, GUIView guiView) {
        Player players [] = playerController.getPlayerArray();
        System.out.println( players[0].getPlayerName() + " " + "NÆSTE TUR skal du drøne frem og KØBE det første ledie felt du lander på!\nHvis der ikke er nogen ledige, så køb fra en anden spiller!\nDu får et chancekort mere\n");
        players[0].setSelectFieldCard(true);
        i++;
        chanceCard(player, playerController, fieldController, guiView);
    }

    private void chancekort2(Player player) {
        System.out.println(">>Ryk til START<< \nmodtag 2M");
        moveToStart(player);
        addBank(player, 2);
    }

    private void chancekort3(Player player, PlayerController playerController) {
        System.out.println(">>Ryk OP TIL 5 felter frem<<");
        moveFieldPLayerSelect(player, 1, 5, playerController);
    }

    private void chancekort4(Player player, PlayerController playerController, FieldController fieldController, GUIView guiView) {
        System.out.println(">>GRATIS FELT<<\nRyk frem til ORANGE felt\nHvis det er ledigt, får du det GRATIS!\nEllers BETAL til ejeren:(");

        moveSpecificFieldRange(player, "Orange", 10, 11);
        takeFreeProperty(player, playerController, fieldController, guiView);
    }

    private void chancekort5(Player player, PlayerController playerController, FieldController fieldController, GUIView guiView) {
        String valg;

        String ryk = "ryk";
        String traek = "træk";

        System.out.println("RYK 1 felt frem, eller TRÆK nyt chancekort!");

        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Skriv \"RYK\" eller \"TRÆK\"");
            valg = scan.nextLine();
        }
        while (!((traek.equals(valg.toLowerCase())) || (ryk.equals(valg.toLowerCase()))));

        if (valg.toLowerCase().equals(ryk)) {
            moveField(player, 1);
        } else if (valg.toLowerCase().equals(traek)) {
            i++;
            chanceCard(player, playerController, fieldController, guiView);
        }
    }

    private void chancekort6 (Player player, PlayerController playerController, FieldController fieldController, GUIView guiView) {
        Player players [] = playerController.getPlayerArray();
        System.out.println(players[1].getPlayerName() + " " + "\nNÆSTE TUR skal du sejle frem og KØBE det første ledige felt du lander på!\nHvis der ikke er nogen ledige, så køb fra en anden spiller!"+
                "\nE K S T R A   C H A N C E K O R T");
        players[1].setSelectFieldCard(true);
        i++;
        chanceCard(player, playerController, fieldController, guiView);
    }

    private void chancekort7(Player player) {
        System.out.println("ÆV du har spist for meget slik :( \nBetal 2M til banken");
        subBank(player, 2);
    }

    private void chancekort8 (Player player, PlayerController playerController, FieldController fieldController, GUIView guiView) {
        System.out.println(">>GRATIS FELT<<\nRyk frem til ORANGE eller GRØNT felt\nHvis det er ledigt får du det GRATIS!\nEllers BETAL til ejeren :(");
        moveSpecificFieldRange(player, "Orange", 10, 11, "Grøn", 19, 20);
        takeFreeProperty(player, playerController, fieldController, guiView);
    }

    private void chancekort9 (Player player, PlayerController playerController, FieldController fieldController, GUIView guiView) {
        System.out.println(">>GRATIS FELT<<\nRyk frem til LYSEBLÅT felt\nHvis det er ledigt får du det GRATIS\nEllers BETAL til ejeren:(");
        moveSpecificFieldRange(player, "Lyseblå", 4, 5);
        takeFreeProperty(player, playerController, fieldController, guiView);
    }

    private void chancekort10 (Player player, PlayerController playerController, FieldController fieldController, GUIView guiView) {
        System.out.println("Du har fået et 'Gratis ud af fængsel kort'. Du bruger det automatisk næste gang du ryger i fængsel! ");
        if(!getJailCardUse() == true) {
            System.out.println("Du har fået ");
            adjustJailCard(player);
            setJailCardUse(true);
        }

        if (getJailCardUse() == true) {
            i++;
            chanceCard(player, playerController, fieldController, guiView);
        }
    }

    private void chancekort11(Player player) {
        System.out.println("RYK til Strandpromenaden");
        moveSpecificField(player, 23);
    }

    private void chancekort12 (Player player, PlayerController playerController, FieldController fieldController, GUIView guiView) {
        if (playerController.getPlayerArrayLength() >= 3) {
        Player players [] = playerController.getPlayerArray();
        System.out.println(">>KATTEN<<\nNÆSTE TUR skal du liste hen og KØBE det første ledige felt du lander på!\nHvis der ikke er " +
                "nogen ledige, så køb fra en anden spiller!\nDu får et chancekort mere\n" +"\nE K S T R A   C H A N C E K O R T");
        players[2].setSelectFieldCard(true); }
        i++;
        chanceCard(player, playerController, fieldController, guiView);
    }

    private void chancekort13 (Player player, PlayerController playerController, FieldController fieldController, GUIView guiView) {
        if (playerController.getPlayerArrayLength() >= 4) {
        Player players [] = playerController.getPlayerArray();
        System.out.println(">>HUNDEN<<\nNÆSTE TUR skal du hoppe hen og KØBE det første ledige felt du lander på!\nHvis der ikke er " +
                "nogen ledige, så køb fra en anden spiller!\nDu får et chancekort mere\n" + "\nE K S T R A   C H A N C E K O R T");
        players[3].setSelectFieldCard(true); }
        i++;
        chanceCard(player, playerController, fieldController, guiView);
    }

    private void chancekort14 (Player player, PlayerController playerController) {

        bankFromAll(player, playerController);
        System.out.println("Du modtager 1m fra alle andre spillere. \n Du har nu" + player.getBankAccount().getBalance());
    }

    private void chancekort15(Player player, PlayerController playerController, FieldController fieldController, GUIView guiView) {
        System.out.println(">>GRATIS FELT<<\nRyk frem til PINK eller MØRKEBLÅT felt\nHvis det er ledigt får du det GRATIS\nEllers BETAL til ejeren:(");
        moveSpecificFieldRange(player, "Pink", 7, 8, "Mørkeblå", 22, 23);
        takeFreeProperty(player, playerController, fieldController, guiView);
    }

    private void chancekort16(Player player) {
        System.out.println(">>Du har lavet alle dine lektier<< \nModtag 2M fra Banken");
        addBank(player, 2);
    }

    private void chancekort17(Player player, PlayerController playerController, FieldController fieldController, GUIView guiView) {
        System.out.println(">>GRATIS FELT<<\nRyk frem til RØDT felt.\nHvis det er ledigt, får du det GRATIS! \nEllers BETAL leje til ejeren");
        moveSpecificFieldRange(player, "Rød", 13, 14);
        takeFreeProperty(player, playerController, fieldController, guiView);
    }

    private void chancekort18(Player player) {
        moveSpecificField(player, 10);
    }

    private void chancekort19(Player player, PlayerController playerController, FieldController fieldController, GUIView guiView) {
        System.out.println(">>GRATIS FELT<<\nRyk frem til LYSEBLÅT eller GRØNT felt\nHvis det er ledigt får du det GRATIS. \nEllers BETAL leje til ejeren:(");
        moveSpecificFieldRange(player, "Lyseblå", 4, 5, "Rød", 13, 14);
        takeFreeProperty(player, playerController, fieldController, guiView);
    }

    private void chancekort20(Player player, PlayerController playerController, FieldController fieldController, GUIView guiView) {
        System.out.println(">>GRATIS FELT<<\nRyk frem til BRUNT eller GULT felt\nHvis det er ledigt får du det GRAITS. \nEllers BETAL leje til ejeren");
        moveSpecificFieldRange(player, "Brun", 1, 2, "Gul", 16, 17);
        takeFreeProperty(player, playerController, fieldController, guiView);
    }

    public void moveField(Player player, int move) {
        player.setFieldNumber(player.getFieldNumber()+ move);
    }

    public void moveFieldPLayerSelect(Player player, int minField, int maxField, PlayerController playerController) {
        int move;

        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("Skriv tal mellem " + minField + " og " + maxField);
            move = scan.nextInt();
        }
        while (minField > move || maxField < move);

        playerController.movePlayer(player, move);
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
            System.out.println("VÆLG " + Color + " felt: " + minMove + " eller " + maxMove);
            System.out.print("\nSkriv hvilket felt du ønsker her: ");
            move = scan.nextInt();
        }
        while (!(minMove == move || maxMove == move));

        player.setFieldNumber(move);
    }

    public void moveSpecificFieldRange(Player player, String Color, int minMove, int maxMove, String Color2, int minMove2, int maxMove2) {
        int move;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("VÆLG " + Color + " eller " + Color2 + " felt: " + minMove + ", " + maxMove + ", "
                    + minMove2 + " eller " + maxMove2);
            System.out.print("\nSkriv hvilket felt du ønsker her: ");
            move = scan.nextInt();
        }
        while (!(minMove == move || maxMove == move || minMove2 == move || maxMove2 == move));

        player.setFieldNumber(move);
    }

    public void addBank(Player player, int moneyChange) {
        player.getBankAccount().addBalance(moneyChange);
    }

    public void subBank(Player player, int moneyChange) {
        player.getBankAccount().subBalance(moneyChange);
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
            tempPlayer.getBankAccount().subBalance(1);
        }

        player.getBankAccount().addBalance(playerController.getPlayerArrayLength() + 1);
    }

    public void takeFreeProperty(Player player, PlayerController playerController, FieldController fieldController, GUIView guiView) {
         fieldController.freeProperty(player, playerController, guiView);
   }

   //Spiller 1 er bil
    // Spiller 2 er skib
    // spiller 3 hund
    // spiller 4 kat


   public void selectMoveProperty (Player player, PlayerController playerController, FieldController fieldController, GUIView guiView) {

        if (player.getSelectFieldCard()) {

        tempMove = player.getFieldNumber();

       int[] propertyAvailArr = {1,2,4,5,7,8,10,11,13,14,16,17,19,20,22,23};
       String arrOut = "";

       for (int availProp : propertyAvailArr) {

           arrOut += availProp + " ";
       }
       System.out.println("Mulige felter du kan vælge i mellem: " + arrOut);

       Scanner scan = new Scanner(System.in);
       System.out.print("Skriv her hvilket felt du vil lande på: ");
       player.setFieldNumber(scan.nextInt());

       checkOwnership(player, playerController, fieldController, guiView);}
   }

   public void checkOwnership (Player player, PlayerController playerController, FieldController fieldController, GUIView guiView) {

        Property property = fieldController.getProperty(player);

        if (property.getOwnerName() == null) {chooseProperty(player, playerController, fieldController, guiView);}
        else if (property.getOwnerName().equals(player.getPlayerName())) {
            System.out.println("Du skal vælge en grund du ikke selv ejer");
            player.setFieldNumber(tempMove);
            selectMoveProperty(player, playerController, fieldController, guiView);
        }
        else {chooseProperty(player, playerController, fieldController, guiView);}
   }

   public void chooseProperty (Player player, PlayerController playerController, FieldController fieldController, GUIView guiView) {

        fieldController.chanceCardBuyProperty(player, playerController, guiView);
        player.setSelectFieldCard(false);

   }
}

