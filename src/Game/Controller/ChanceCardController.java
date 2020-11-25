package Game.Controller;

import Game.View.GUIView;
import Game.Model.Player;

import java.util.Random;
import java.util.Scanner;

//TODO: der bliver ikke købt en grund når man lander 5 felter fremmme
public class ChanceCardController {

    private static boolean cardUse;
    private int i;
    private int tempMove;
    ChanceCardMessageController ccm = new ChanceCardMessageController();

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
        for (int c = 0; c < chanceArray.length; c++) {
            int random = rand.nextInt(chanceArray.length);
            int temp = chanceArray[random];
            chanceArray[random] = chanceArray[c];
            chanceArray[c] = temp;
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

        System.out.println(ccm.number(1));
        
        switch (chanceArray[i]) {

            case 1: //Chance Kort 1
                chancekort1(player, playerController, fieldController, guiView);
                break;
            case 2: //Chance Kort 2
                chancekort2(player);
                break;
            case 3: //Chance Kort 3
                chancekort3(player, playerController, fieldController, guiView);
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
                chancekort18(player, playerController, fieldController, guiView);
                break;
            case 19://Chancekort 19
                chancekort19(player, playerController, fieldController, guiView);
                break;
            case 20://Chancekort 20
                chancekort20(player, playerController, fieldController, guiView);
                break;
            default:
                System.out.println(ccm.number(2));
        }
    nextCard();
}

    private void nextCard() {
        if (i >= (chanceArray.length - 1)) {
            i = 0;
        } else {
            i++;
        }
    }

    private void chancekort1 (Player player, PlayerController playerController, FieldController fieldController, GUIView guiView) {
        Player players [] = playerController.getPlayerArray();
        System.out.println(players[0].getPlayerName() + " " + ccm.number(16) + " " + ccm.number(17) + ccm.number(21) + "\n" + ccm.number(22) + "\n" + ccm.number(4) + "\n" + ccm.number(5) + "\n");
        players[0].setSelectFieldCard(true);
        nextCard();
        chanceCard(player, playerController, fieldController, guiView);
    }

    private void chancekort2(Player player) {
        System.out.println(ccm.number(5)+ "\n" + ccm.number(6));
        moveToStart(player);
        addBank(player, 2);
    }

    private void chancekort3(Player player, PlayerController playerController, FieldController fieldController, GUIView guiView) {
        System.out.println(ccm.number(7));
        moveFieldPLayerSelect(player, 1, 5, playerController);

        if (fieldController.getCheckIfProperty(player)) {
        fieldController.buyProperty(player, playerController, guiView);}

        else {
            System.out.println(player.getPlayerName() + ccm.number(59));
        }

    }

    private void chancekort4(Player player, PlayerController playerController, FieldController fieldController, GUIView guiView) {
        System.out.println(ccm.number(8) +"\n" + ccm.number(9)+ " " + ccm.number(29)+ " " + ccm.number(34) + "\n" + ccm.number(10) + "\n" + ccm.number(11));

        moveSpecificFieldRange(player, ccm.number(37), 10, 11);
        takeFreeProperty(player, playerController, fieldController, guiView);
    }

    private void chancekort5(Player player, PlayerController playerController, FieldController fieldController, GUIView guiView) {
        String valg;

        String ryk = ccm.number(12);
        String traek = ccm.number(13);

        System.out.println(ccm.number(14));

        Scanner scan = new Scanner(System.in);
        do {
            System.out.println(ccm.number(15));
            valg = scan.nextLine();
        }
        while (!((traek.equals(valg.toLowerCase())) || (ryk.equals(valg.toLowerCase()))));

        if (valg.toLowerCase().equals(ryk)) {
            moveField(player, 1);
            fieldController.buyProperty(player, playerController, guiView);
        } else if (valg.toLowerCase().equals(traek)) {
            nextCard();
            chanceCard(player, playerController, fieldController, guiView);
        }
    }

    private void chancekort6 (Player player, PlayerController playerController, FieldController fieldController, GUIView guiView) {
        Player players [] = playerController.getPlayerArray();
        System.out.println(players[1].getPlayerName() + " " + ccm.number(16) + " " + ccm.number(18) + ccm.number(21) + "\n" + ccm.number(22) + "\n" + ccm.number(4) + "\n" + ccm.number(5) + "\n");
        players[1].setSelectFieldCard(true);
        nextCard();
        chanceCard(player, playerController, fieldController, guiView);
    }

    private void chancekort7(Player player) {
        System.out.println(ccm.number(23)+ "\n" + ccm.number(24));
        subBank(player, 2);
    }

    private void chancekort8 (Player player, PlayerController playerController, FieldController fieldController, GUIView guiView) {
        System.out.println(ccm.number(8) + "\n" + ccm.number(9) + " " + ccm.number(29) + " " + ccm.number(31) + " " + ccm.number(32)  + " " + ccm.number(34) + "\n " + ccm.number(35) + "\n" + ccm.number(36));
        moveSpecificFieldRange(player, ccm.number(37), 10, 11, ccm.number(38), 19, 20);
        takeFreeProperty(player, playerController, fieldController, guiView);
    }

    private void chancekort9 (Player player, PlayerController playerController, FieldController fieldController, GUIView guiView) {
        System.out.println(ccm.number(8) + "\n" + ccm.number(9) + " " + ccm.number(28) + " " + ccm.number(34) + "\n" + ccm.number(10) + "\n " + ccm.number(11));
        moveSpecificFieldRange(player, ccm.number(39), 4, 5);
        takeFreeProperty(player, playerController, fieldController, guiView);
    }

    private void chancekort10 (Player player, PlayerController playerController, FieldController fieldController, GUIView guiView) {
        System.out.println(ccm.number(43) + "\n" +ccm.number(44) + "! ");
        if(!getJailCardUse() == true) {
            System.out.println(ccm.number(45) + ": ");
            adjustJailCard(player);
            setJailCardUse(true);
        }

        if (getJailCardUse() == true) {
            nextCard();
            chanceCard(player, playerController, fieldController, guiView);
        }
    }

    private void chancekort11(Player player) {
        System.out.println(ccm.number(46));
        moveSpecificField(player, 23);
    }

    private void chancekort12 (Player player, PlayerController playerController, FieldController fieldController, GUIView guiView) {
        if (playerController.getPlayerArrayLength() >= 3) {
        Player players [] = playerController.getPlayerArray();
        System.out.println(players[2].getPlayerName() + " " + ccm.number(16) + " " + ccm.number(19) + ccm.number(21) + "\n" + ccm.number(22) + "\n" + ccm.number(4) + "\n" + ccm.number(5) + "\n");
        players[2].setSelectFieldCard(true); }
        nextCard();
        chanceCard(player, playerController, fieldController, guiView);
    }

    private void chancekort13 (Player player, PlayerController playerController, FieldController fieldController, GUIView guiView) {
        if (playerController.getPlayerArrayLength() >= 4) {
        Player players [] = playerController.getPlayerArray();
        System.out.println(players[3].getPlayerName() + " " + ccm.number(16) + " " + ccm.number(20) + ccm.number(21) + "\n" + ccm.number(22) + "\n" + ccm.number(4) + "\n" + ccm.number(5) + "\n");
        players[3].setSelectFieldCard(true); }
        nextCard();
        chanceCard(player, playerController, fieldController, guiView);
    }

    private void chancekort14 (Player player, PlayerController playerController) {

        bankFromAll(player, playerController);
        System.out.println(ccm.number(29) +  "\n" + ccm.number(48) + player.getBankAccount().getBalance());
    }

    private void chancekort15(Player player, PlayerController playerController, FieldController fieldController, GUIView guiView) {
        System.out.println(ccm.number(8)+"\n" + ccm.number(9) + " "+ ccm.number(30) +  " " + ccm.number(31) + " "  + ccm.number(33) + " " + ccm.number(34) + "\n" + ccm.number(10) + "\n " + "\n" + ccm.number(11));
        moveSpecificFieldRange(player, ccm.number(40), 7, 8, ccm.number(41), 22, 23);
        takeFreeProperty(player, playerController, fieldController, guiView);
    }

    private void chancekort16(Player player) {
        System.out.println(ccm.number(49) + " \n " + ccm.number(50));
        addBank(player, 2);
    }

    private void chancekort17(Player player, PlayerController playerController, FieldController fieldController, GUIView guiView) {
        System.out.println(ccm.number(8)+ "\n" + ccm.number(9) + " " + ccm.number(59) + " " + ccm.number(34) + "\n" + ccm.number(10) + "\n" + ccm.number(11));
        moveSpecificFieldRange(player, ccm.number(42), 13, 14);
        takeFreeProperty(player, playerController, fieldController, guiView);
    }

    private void chancekort18(Player player, PlayerController playerController, FieldController fieldController, GUIView guiView) {
        System.out.println(ccm.number(9) + " " + ccm.number(60));
        moveSpecificField(player, 10);
        takeFreeProperty(player, playerController, fieldController, guiView);
    }

    private void chancekort19(Player player, PlayerController playerController, FieldController fieldController, GUIView guiView) {
        System.out.println(ccm.number(8) + "\n" + ccm.number(9)  + " " + ccm.number(28) +  " " + ccm.number(31) + " " + ccm.number(27) + " " + ccm.number(34) + "\n" + ccm.number(10) + "\n "+ ccm.number(11));
        moveSpecificFieldRange(player, ccm.number(39), 4, 5, ccm.number(42), 13, 14);
        takeFreeProperty(player, playerController, fieldController, guiView);
    }

    private void chancekort20(Player player, PlayerController playerController, FieldController fieldController, GUIView guiView) {
        System.out.println(ccm.number(8) + "\n" + ccm.number(9)  + " " + ccm.number(25) +  " " + ccm.number(31) + " " + ccm.number(26) + " " + ccm.number(34) +"\n" + ccm.number(10) + "\n " + ccm.number(11));
        moveSpecificFieldRange(player, ccm.number(61), 1, 2, ccm.number(62), 16, 17);
        takeFreeProperty(player, playerController, fieldController, guiView);
    }

    public void moveField(Player player, int move) {
        player.setFieldNumber(player.getFieldNumber()+ move);
    }

    public void moveFieldPLayerSelect(Player player, int minField, int maxField, PlayerController playerController) {
        int move;

        Scanner scan = new Scanner(System.in);

        do {
            System.out.println(ccm.number(51) + " " + minField + " " + ccm.number(52) + " " + maxField);
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
            System.out.println(ccm.number(53) + " " + Color + " felt: " + minMove +  " " + ccm.number(31) + " "  + maxMove);
            System.out.print("\n" + ccm.number(54) + " : ");
            move = scan.nextInt();
            if (move < minMove || move > maxMove){

            }
        }
        while (!(minMove == move || maxMove == move));

        player.setFieldNumber(move);
    }

    public void moveSpecificFieldRange(Player player, String Color, int minMove, int maxMove, String Color2, int minMove2, int maxMove2) {
        int move;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println(ccm.number(53) + " " + Color + " " + ccm.number(31) + " " + Color2 + " " + ccm.number(34) + " : " + minMove + ", " + maxMove + ", "
                    + minMove2 +  " " + ccm.number(31) + " "  + maxMove2);
            System.out.print("\n" + ccm.number(54) +" ");
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

   public void selectMoveProperty (Player player, PlayerController playerController, FieldController fieldController, GUIView guiView) {

        if (player.getSelectFieldCard()) {

        tempMove = player.getFieldNumber();

       int[] propertyAvailArr = {1,2,4,5,7,8,10,11,13,14,16,17,19,20,22,23};
       String arrOut = "";

       for (int availProp : propertyAvailArr) {

           arrOut += availProp + " ";
       }
       System.out.println(player.getPlayerName() + " " + ccm.number(55) + " " + arrOut);

       Scanner scan = new Scanner(System.in);

       boolean withinArray = false;
       System.out.print(ccm.number(54));
       int move = scan.nextInt();

       for (int c = 0; c < propertyAvailArr.length; c++) {
           if (move == propertyAvailArr[c]) {
               withinArray = true;
           }
       }
       if (!withinArray) {selectMoveProperty(player, playerController,fieldController, guiView);}

       else if (withinArray) {
       player.setFieldNumber(move);

       fieldController.checkOwnership(player, playerController, fieldController, guiView);}}
   }

   public int getTempMove() {
        return tempMove;
   }

   public void chooseProperty (Player player, PlayerController playerController, FieldController fieldController, GUIView guiView) {

        fieldController.chanceCardBuyProperty(player, playerController, guiView);
        player.setSelectFieldCard(false);

   }
}

