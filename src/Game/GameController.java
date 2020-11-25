package Game;


import java.util.Scanner;

/**
 * GameController
 *
 * @author Gruppe11
 */

public class GameController {

        //nb meget vigtigt ChangeLanguage står først
        ChangeLanguage c;
        private int turnCount;
        //skaber nye objekter af Field, RaffleCup og PlayerCreator
        private FieldController fieldController;
        private PlayerController playerController;
        private Die die;
        private Scanner scan;
        private GUIView guiView;
        private MessageController m;

        public GameController(){
            c = new ChangeLanguage();
            fieldController = new FieldController();
            playerController = new PlayerController();
            die = new Die();
            scan = new Scanner(System.in);
            guiView = new GUIView();
            m = new MessageController();
        }

        public GameController(boolean test){

            fieldController = new FieldController();
            playerController = new PlayerController();
            die = new Die();
            scan = new Scanner(System.in);
            guiView = new GUIView();
            m = new MessageController();
        }

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

            //TODO: rigtig terning
            die.roll();
            guiView.getMyGUI().setDie(die.getDiceValue());
            //TODO: bedre navngivning til "m"
            m.println(m.playerDieRollMsg(currentPlayerName, die.getDiceValue()));

            //TODO: testterninger, SKAL KALDE SPILLERE "GAB" OG "SEB" FOR AT DET VIRKER (til test af sellProperty)
            //if(currentPlayerName.equals("GAB"))
            //die.rollPlayer0();
            //else if(currentPlayerName.equals("SEB"))
            //die.rollPlayer1();

            playerController.movePlayer(currentPlayer, die.getDiceValue());

            guiView.getMyGUI().getFields()[currentPlayer.getFieldNumber()].setCar(guiView.getGUIPlayer(turnCount), true);

            fieldController.landOnField(currentPlayer, playerController, guiView);

            guiView.getMyGUI().getFields()[currentPlayer.getFieldNumber()].setCar(guiView.getGUIPlayer(turnCount), true);

            guiView.removeAllCarsFromChanceFields(turnCount);
            guiView.removeCarFromJailField(turnCount);

            //I GUI sættes spillers balance
            guiView.getGUIPlayer(turnCount).setBalance(currentPlayer.getBankAccount().getBalance());


            if (currentPlayer.getBankAccount().getBankrupt()) {
                guiView.getMyGUI().showMessage(currentPlayerName + m.bankruptMsg(currentPlayerName));
                m.println(m.bankruptMsg(currentPlayerName));
                findWinner(playerController.getPlayerArray());
                break;
            }

            m.println(m.currentBalanceMsg(currentPlayerName, currentPlayer.getBankAccount().getBalance()));
            m.println(m.myTurnMsg(playerController.getPlayerArray()[nextPlayerTurnCount].getPlayerName()));


            //TODO commenter ud for autoroll
            //guiView.getMyGUI().showMessage(currentPlayerName +" "+ fieldController.getFields()[currentPlayer.getFieldNumber()].getMsg());

            //giver turen til spiller 1 fra den sidste spiller, eller giver turen videre fra spiller 1 til 2 fx
            turnCount = (turnCount + 1) % playerController.getPlayerArray().length;
            m.println(m.lineMsg());
        }
    }

    private void startMessage() {
        String start;
        String playerOne = playerController.getPlayerArray()[0].getPlayerName();

        do {
            m.println(m.startMsg(playerOne));

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
            m.println(m.tieMsg());
            guiView.getMyGUI().showMessage(m.tieMsg());
        } else {
            leadingPlayer.setPlayerWin();
            m.println(m.winMsg(leadingPlayer.getPlayerName(), leadingPlayer.getBankAccount().getBalance(), leadingPlayer.getTotalPropertyValue()));
            guiView.getMyGUI().showMessage(m.winMsg(leadingPlayer.getPlayerName(), leadingPlayer.getBankAccount().getBalance(), leadingPlayer.getTotalPropertyValue()));

        }
    }

    private void printOwnedProperties(){
        for (Player player : playerController.getPlayerArray()){
            m.print(player.getPlayerName() + ":");
            for (int i = 0; i < player.getPropertiesOwned().size(); i++){
                m.print("[" +player.getPropertiesOwned().get(i).getName() + "]");
            }
            m.println("");
        }
    }

}