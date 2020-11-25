package Game.Controller;


import Game.Model.Die;
import Game.Model.GameOutputModel;
import Game.Model.Player;
import Game.View.GUIView;

import java.util.Scanner;

/**
 * GameController
 *
 * @author Gruppe11
 */

public class GameController {

        //nb meget vigtigt ChangeLanguage står først
        LanguageChangeController languageChanger;
        private int turnCount;
        //skaber nye objekter af Field, RaffleCup og PlayerCreator
        private FieldController fieldController;
        private PlayerController playerController;
        private Die die;
        private Scanner scan;
        private GUIView guiView;
        private GameOutputModel msgController;

        public GameController(){
            languageChanger = new LanguageChangeController();
            fieldController = new FieldController();
            playerController = new PlayerController();
            die = new Die();
            scan = new Scanner(System.in);
            guiView = new GUIView();
            msgController = new GameOutputModel();
        }

        public GameController(boolean test){

            fieldController = new FieldController();
            playerController = new PlayerController();
            die = new Die();
            scan = new Scanner(System.in);
            guiView = new GUIView();
            msgController = new GameOutputModel();
        }

    /**
     * Main metode, kører spillet
     */
    public void gameController() {

        //metode til at køre med 2-4 spillere samt tildele navne
        playerController.playerCreator();
        //metode som shuffler chancekort
        fieldController.doRandomize();

        //laver spillere i GUI
        guiView.createGUIPlayers(playerController.getPlayerArray(), playerController.getPlayerArray()[0].getBankAccount().getBalance());
        startMessage();

        Player currentPlayer;
        String currentPlayerName;
        int nextPlayerTurnCount;

        while (!playerController.getPlayerArray()[turnCount].getBankAccount().getBankrupt()) {

            //Fokortelse af variabler
            currentPlayer = playerController.getPlayerArray()[turnCount];
            currentPlayerName = currentPlayer.getPlayerName();
            nextPlayerTurnCount = (turnCount + 1) % playerController.getPlayerArray().length;


            //ruller terninger med RaffleCup samt opdaterer spillerens position
            printOwnedProperties();

            guiView.getMyGUI().getFields()[currentPlayer.getFieldNumber()].setCar(guiView.getGUIPlayer(turnCount), false);

            //kaster terning
            die.roll();
            guiView.getMyGUI().setDie(die.getDiceValue());

            msgController.println(msgController.playerDieRollMsg(currentPlayerName, die.getDiceValue()));

            playerController.movePlayer(currentPlayer, die.getDiceValue());

            guiView.getMyGUI().getFields()[currentPlayer.getFieldNumber()].setCar(guiView.getGUIPlayer(turnCount), true);

            fieldController.landOnField(currentPlayer, playerController, guiView);

            guiView.getMyGUI().getFields()[currentPlayer.getFieldNumber()].setCar(guiView.getGUIPlayer(turnCount), true);

            guiView.removeAllCarsFromChanceFields(turnCount);
            guiView.removeCarFromJailField(turnCount);

            //I GUI sættes spillers balance
            guiView.getGUIPlayer(turnCount).setBalance(currentPlayer.getBankAccount().getBalance());


            if (currentPlayer.getBankAccount().getBankrupt()) {
                guiView.getMyGUI().showMessage(currentPlayerName + msgController.bankruptMsg(currentPlayerName));
                msgController.println(msgController.bankruptMsg(currentPlayerName));
                findWinner(playerController.getPlayerArray());
                break;
            }

            msgController.println(msgController.currentBalanceMsg(currentPlayer.getBankAccount().getBalance()));
            msgController.println(msgController.myTurnMsg(playerController.getPlayerArray()[nextPlayerTurnCount].getPlayerName()));


            //ok knap som ruller terninger
            guiView.getMyGUI().showMessage(currentPlayerName +" "+ fieldController.getFields()[currentPlayer.getFieldNumber()].getMsg());

            //giver turen til spiller 1 fra den sidste spiller, eller giver turen videre fra spiller 1 til 2 fx
            turnCount = (turnCount + 1) % playerController.getPlayerArray().length;
            msgController.println(msgController.lineMsg());
        }
    }

    private void startMessage() {
        String start;
        String playerOne = playerController.getPlayerArray()[0].getPlayerName();

        do {
            msgController.println(msgController.startMsg(playerOne));

            start = scan.nextLine();
        }
        while (!start.isEmpty());
    }

    public void findWinner(Player[] playerArray) {

        boolean itsATie = false;
        Player leadingPlayer = playerArray[0];

        for (int i = 0; i < playerArray.length - 1; i++) {
            if (playerArray[i + 1].getBankAccount().getBalance() > leadingPlayer.getBankAccount().getBalance()) {
                leadingPlayer = playerArray[i + 1];
            }
        }
        for (int j = 0; j < playerArray.length; j++) {
            if (leadingPlayer.getPlayerName().equals(playerArray[j].getPlayerName()) == false) {
                if (playerArray[j].getBankAccount().getBalance() == leadingPlayer.getBankAccount().getBalance()) {
                    if (playerArray[j].getTotalPropertyValue() > leadingPlayer.getTotalPropertyValue()) {
                        leadingPlayer = playerArray[j];
                    } else if (playerArray[j].getTotalPropertyValue() == leadingPlayer.getTotalPropertyValue())
                        itsATie = true;
                }
            }
        }
        printGameResult(itsATie, leadingPlayer);
        scan.close();
    }

    private void printGameResult(boolean uafgjort, Player leadingPlayer) {
        if (uafgjort) {
            msgController.println(msgController.tieMsg());
            guiView.getMyGUI().showMessage(msgController.tieMsg());
        } else {
            leadingPlayer.setPlayerWin();
            msgController.println(msgController.winMsg(leadingPlayer.getPlayerName(), leadingPlayer.getBankAccount().getBalance(), leadingPlayer.getTotalPropertyValue()));
            guiView.getMyGUI().showMessage(msgController.winMsg(leadingPlayer.getPlayerName(), leadingPlayer.getBankAccount().getBalance(), leadingPlayer.getTotalPropertyValue()));

        }
    }

    private void printOwnedProperties(){
        for (Player player : playerController.getPlayerArray()){
            msgController.print(player.getPlayerName() + ":");
            for (int i = 0; i < player.getPropertiesOwned().size(); i++){
                msgController.print("[" +player.getPropertiesOwned().get(i).getName() + "]");
            }
            msgController.println("");
        }
    }

}