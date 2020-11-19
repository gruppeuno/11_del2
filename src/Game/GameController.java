package Game;


import java.util.Scanner;

/**
 * GameController
 *
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
    MessageController m = new MessageController();

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
        guiView.createGUIPlayers(playerController.getPlayerArray(), playerController.getPlayerArray()[0].getBankAccount().getBalance());
        startMessage();

        while (!playerController.getPlayerArray()[turnCount].getBankAccount().getBankrupt()) {

            //Fokortelse af variabler
            Player currentPlayer = playerController.getPlayerArray()[turnCount];
            String currentPlayerName = currentPlayer.getPlayerName();
            int nextPlayerTurnCount = (turnCount + 1) % playerController.getPlayerArray().length;
            int previousField = currentPlayer.getFieldNumber();

            //loop til afvente spillerens roll commando i consollen
            //playerRollInput();
            //ruller terninger med RaffleCup samt opdaterer spillerens position
            //TODO: rigtig terning
            die.roll();
            m.print(m.playerDieRollMsg(currentPlayerName, die.getDiceValue()));

            //TODO: testterninger, SKAL KALDE SPILLERE "GAB" OG "SEB" FOR AT DET VIRKER (til test af sellProperty)
            //if(currentPlayerName.equals("GAB"))
            //die.rollPlayer0();
            //else if(currentPlayerName.equals("SEB"))
            //die.rollPlayer1();

            guiView.getMyGUI().getFields()[currentPlayer.getFieldNumber()].setCar(guiView.getGUIPlayer(turnCount), false);

            playerController.movePlayer(currentPlayer, die.getDiceValue());
            guiView.getMyGUI().getFields()[currentPlayer.getFieldNumber()].setCar(guiView.getGUIPlayer(turnCount), true);

            fieldController.landOnField(currentPlayer, playerController, fieldController, guiView);

            guiView.getMyGUI().getFields()[previousField].setCar(guiView.getGUIPlayer(turnCount), false);

            guiView.getMyGUI().getFields()[currentPlayer.getFieldNumber()].setCar(guiView.getGUIPlayer(turnCount), true);

            guiView.removeAllCarsFromChanceFields(turnCount);
            guiView.removeCarFromJailField(turnCount);

            //Terningernes værdier sættes
            guiView.getMyGUI().setDie(die.getDiceValue());

            //placerer spillers bil på det rette felt

            if (currentPlayer.getBankAccount().getBankrupt()) {
                guiView.getMyGUI().showMessage(currentPlayerName + m.bankruptMsg(currentPlayerName));
                m.print(m.bankruptMsg(currentPlayerName));
                findWinner(playerController.getPlayerArray());
                break;
            }

            m.print(m.currentBalanceMsg(currentPlayerName, currentPlayer.getBankAccount().getBalance()));
            m.print(m.myTurnMsg(playerController.getPlayerArray()[nextPlayerTurnCount].getPlayerName()));

            //I GUI sættes spillers balance
            guiView.getGUIPlayer(turnCount).setBalance(currentPlayer.getBankAccount().getBalance());


            //TODO commenter ud for autoroll
            guiView.getMyGUI().showMessage(currentPlayerName +" "+ fieldController.getFields()[currentPlayer.getFieldNumber()].getMsg());

            //giver turen til spiller 1 fra den sidste spiller, eller giver turen videre fra spiller 1 til 2 fx
            turnCount = (turnCount + 1) % playerController.getPlayerArray().length;
            m.print(m.lineMsg());
        }
    }

    private void startMessage() {
        String start;
        String playerOne = playerController.getPlayerArray()[0].getPlayerName();

        do {
            m.print(m.startMsg(playerOne));

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
    }

    private void printGameResult(boolean uafgjort, Player leadingPlayer) {
        if (uafgjort) {
            m.print(m.tieMsg());
            guiView.getMyGUI().showMessage(m.tieMsg());
        } else {
            leadingPlayer.setPlayerWin();
            m.print(m.winMsg(leadingPlayer.getPlayerName(), leadingPlayer.getBankAccount().getBalance(), leadingPlayer.getTotalPropertyValue()));
            guiView.getMyGUI().showMessage(m.winMsg(leadingPlayer.getPlayerName(), leadingPlayer.getBankAccount().getBalance(), leadingPlayer.getTotalPropertyValue()));

        }
    }
}