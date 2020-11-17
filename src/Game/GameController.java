package Game;


import java.util.Scanner;

/**
 * GameController
 * @author Gruppe11
 */

public class GameController {

    private int turnCount;
    private int nextPlayerTurnCount;
    //skaber nye objekter af Field, RaffleCup og PlayerCreator
    final private FieldController fieldController = new FieldController();
    final private PlayerController playerController = new PlayerController();
    final private Die die = new Die();
    final private Scanner scan = new Scanner(System.in);
    final private GUIView guiView = new GUIView();
    MessageController messageController = new MessageController();

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
      guiView.createGUIPlayers(playerController.getPlayerArray(), playerController.getPlayerArray()[0].bankAccount.getBalance());
      startMessage();

        while (!playerController.getPlayerArray()[turnCount].bankAccount.getBankrupt()) {

            //Fokortelse af variabler
            Player currentPlayer = playerController.getPlayerArray()[turnCount];
            String currentPlayerName = currentPlayer.getPlayerName();
            nextPlayerTurnCount = (turnCount + 1) % playerController.getPlayerArray().length;
            //loop til afvente spillerens roll commando i consollen
            //playerRollInput();
            //ruller terninger med RaffleCup samt opdaterer spillerens position
            die.roll();
            messageController.print(messageController.playerDieRollMsg(currentPlayerName, die.getDiceValue()));
            guiView.getMyGUI().getFields()[currentPlayer.getFieldNumber()].setCar(guiView.getGUIPlayer(turnCount),false);

            playerController.movePlayer(currentPlayer, die.getDiceValue());

            fieldController.landOnField(currentPlayer, playerController);
            guiView.getMyGUI().getFields()[currentPlayer.getFieldNumber()].setCar(guiView.getGUIPlayer(turnCount),true);


            //Terningernes værdier sættes
            guiView.getMyGUI().setDie(die.getDiceValue());

            //placerer spillers bil på det rette felt

            if (currentPlayer.bankAccount.getBankrupt()) {
                guiView.getMyGUI().showMessage(currentPlayerName + messageController.bankruptMsg(currentPlayerName));
                messageController.print(messageController.bankruptMsg(currentPlayerName));
                findWinner(playerController.getPlayerArray());
                break;
            }

            messageController.print(messageController.currentBalanceMsg(currentPlayerName,currentPlayer.bankAccount.getBalance()));
            messageController.print(messageController.myTurnMsg(playerController.getPlayerArray()[nextPlayerTurnCount].getPlayerName()));

            //I GUI sættes spillers balance
            guiView.getGUIPlayer(turnCount).setBalance(currentPlayer.bankAccount.getBalance());

            guiView.getMyGUI().showMessage(currentPlayerName +" "+ fieldController.getFields()[currentPlayer.getFieldNumber()].getMsg());

            //giver turen til spiller 1 fra den sidste spiller, eller giver turen videre fra spiller 1 til 2 fx
            turnCount = (turnCount + 1) % playerController.getPlayerArray().length;
            messageController.print(messageController.lineMsg());
        }
    }

    private void startMessage() {
        String start;
        String playerOne = playerController.getPlayerArray()[0].getPlayerName();

        do {
            messageController.print(messageController.startMsg(playerOne));

            start = scan.nextLine();
        }
        while (!start.isEmpty());

        //Lukker scanner hvis der er fundet en vinder
        if (playerController.getPlayerArray()[turnCount].getPlayerWin())
            scan.close();
    }

    public void findWinner(Player[] playerArray) {

        boolean itsATie = false;
        Player leadingPlayer = playerArray[0];

        for (int i = 0; i < playerArray.length-1; i++) {
                if (playerArray[i+1].bankAccount.getBalance() > leadingPlayer.bankAccount.getBalance()) {
                    leadingPlayer = playerArray[i+1];
                }
        }
        for (int j = 0; j < playerArray.length; j++) {
            if (leadingPlayer.getPlayerName().equals(playerArray[j].getPlayerName())==false) {
                if (playerArray[j].bankAccount.getBalance() == leadingPlayer.bankAccount.getBalance()) {
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
            messageController.print(messageController.tieMsg());
            guiView.getMyGUI().showMessage(messageController.tieMsg());
        } else {
            leadingPlayer.setPlayerWin();
            messageController.print(messageController.winMsg(leadingPlayer.getPlayerName(), leadingPlayer.bankAccount.getBalance(), leadingPlayer.getTotalPropertyValue()));
            guiView.getMyGUI().showMessage(messageController.winMsg(leadingPlayer.getPlayerName(), leadingPlayer.bankAccount.getBalance(), leadingPlayer.getTotalPropertyValue()));

        }
    }
}