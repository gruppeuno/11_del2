package Game;


import Game.Fields.Property;

import java.util.Scanner;

/**
 * GameController
 * @author Gruppe11
 */

public class GameController {

    private int turnCount;
    //skaber nye objekter af Field, RaffleCup og PlayerCreator
    final private FieldController fieldController = new FieldController();
    final private PlayerController playerController = new PlayerController();
    final private Die die = new Die();
    final private Scanner scan = new Scanner(System.in);
    final private GUIView guiView = new GUIView();
    Outputs o = new Outputs();

    /**
     * Main metode, kører spillet
     */
    public void gameController() {

        //TODO: Rigtige metode til at køre med 2-4 spillere samt tildele navne
        playerController.playerCreator();
        fieldController.doRandomize();

        //TODO: test metode til 2 spillere
        //playerController.createPlayers(2);

        //laver spillere i GUI
      guiView.createGUIPlayers(playerController.getPlayerArray(), playerController.getPlayerArray()[0].b.getBalance());
      startMessage();

        while (!playerController.getPlayerArray()[turnCount].b.getBankrupt()) {
            //Fokortelse af variabler
            Player currentPlayer = playerController.getPlayerArray()[turnCount];
            String currentPlayerName = currentPlayer.getPlayerName();
            //loop til afvente spillerens roll commando i consollen
            //playerRollInput();
            //ruller terninger med RaffleCup samt opdaterer spillerens position
            //TODO: rigtig terning
            //die.roll();
            //TODO: testterninger, SKAL KALDE SPILLERE GAB OG SEB FOR AT DET VIRKER
            if(currentPlayerName.equals("gab"))
            die.rollPlayer0();
            else if(currentPlayerName.equals("seb"))
            die.rollPlayer1();


            o.print(o.playerDieRollMsg(currentPlayerName, die.getDiceValue()));
            guiView.getMyGUI().getFields()[currentPlayer.getFieldNumber()].setCar(guiView.getGUIPlayer(turnCount),false);

            playerController.movePlayer(currentPlayer, die.getDiceValue());

            fieldController.landOnField(currentPlayer, playerController, guiView);
            guiView.getMyGUI().getFields()[currentPlayer.getFieldNumber()].setCar(guiView.getGUIPlayer(turnCount),true);

            //Terningernes værdier sættes
            guiView.getMyGUI().setDie(die.getDiceValue());

            //TODO: test af sellProperty
            Property testProperty = (Property) fieldController.getFields()[16];
            if (currentPlayer.getFieldNumber()==16 && testProperty.getOwnerName()!=currentPlayerName)
                fieldController.sellProperty(currentPlayer, 3,guiView);

            //placerer spillers bil på det rette felt

            if (currentPlayer.b.getBankrupt()) {
                guiView.getMyGUI().showMessage(currentPlayerName + o.bankruptMsg(currentPlayerName));
                o.print(o.bankruptMsg(currentPlayerName));
                findWinner(playerController.getPlayerArray());
                break;
            }

            o.print(o.currentBalanceMsg(currentPlayerName,currentPlayer.b.getBalance()));

            //I GUI sættes spillers balance
            guiView.getGUIPlayer(turnCount).setBalance(currentPlayer.b.getBalance());

            guiView.getMyGUI().showMessage(currentPlayerName +" "+ fieldController.getFields()[currentPlayer.getFieldNumber()].getMsg());

            //giver turen til spiller 1 fra den sidste spiller, eller giver turen videre fra spiller 1 til 2 fx
            turnCount = (turnCount + 1) % playerController.getPlayerArray().length;
            o.print(o.lineMsg());
        }
    }

    private void startMessage() {
        String start;

        do {
            o.print(o.startMsg());

            start = scan.nextLine();
        }
        while (!start.toLowerCase().equals(o.startInputMsg()));

        //Lukker scanner hvis der er fundet en vinder
        if (playerController.getPlayerArray()[turnCount].getPlayerWin())
            scan.close();
    }

    /*
     * Loop der kører indtil spilleren har indtastet "roll"
     * hvis spilleren har vunder lukkes scanneren
     */
    private void playerRollInput() {
        String rollInput;

        do {
            o.print(o.myTurnMsg(playerController.getPlayerArray()[turnCount].getPlayerName()));

            rollInput = scan.nextLine();
        }
        while (!rollInput.toLowerCase().equals(o.rollInputMsg()));

        //Lukker scanner hvis der er fundet en vinder
        if (playerController.getPlayerArray()[turnCount].getPlayerWin())
            scan.close();
    }

    public void findWinner(Player[] playerArray) {

        boolean itsATie = false;
        Player leadingPlayer = playerArray[0];

        for (int i = 0; i < playerArray.length-1; i++) {
                if (playerArray[i+1].b.getBalance() > leadingPlayer.b.getBalance()) {
                    leadingPlayer = playerArray[i+1];
                }
        }
        for (int j = 0; j < playerArray.length; j++) {
            if (leadingPlayer.getPlayerName().equals(playerArray[j].getPlayerName())==false) {
                if (playerArray[j].b.getBalance() == leadingPlayer.b.getBalance()) {
                    if (playerArray[j].getTotalPropertyValue() > leadingPlayer.getTotalPropertyValue()) {
                        leadingPlayer = playerArray[j];
                    } else if (playerArray[j].getTotalPropertyValue() == leadingPlayer.getTotalPropertyValue())
                        itsATie = true;
                }
            }
        }
        printGameResult(itsATie,leadingPlayer);
    }

    private void printGameResult(boolean uafgjort, Player leadingPlayer){
        if (uafgjort) {
            o.print(o.tieMsg());
            guiView.getMyGUI().showMessage(o.tieMsg());
        } else {
            leadingPlayer.setPlayerWin();
            o.print(o.winMsg(leadingPlayer.getPlayerName(), leadingPlayer.b.getBalance(), leadingPlayer.getTotalPropertyValue()));
            guiView.getMyGUI().showMessage(o.winMsg(leadingPlayer.getPlayerName(), leadingPlayer.b.getBalance(), leadingPlayer.getTotalPropertyValue()));

        }
    }
}