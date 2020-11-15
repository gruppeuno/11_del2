package Game;


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
    Scanner scan = new Scanner(System.in);
    GUIView guiView = new GUIView();

    /**
     * Main metode, kører spillet
     */
    public void gameController() {

        //TODO: Rigtige metode til at køre med 2-6 spillere samt tildele navne
        playerController.playerCreator();

        //TODO: test metode til 2 spillere
        //playerController.createPlayers(2);

        //laver spillere i GUI
      guiView.createGUIPlayers(playerController.getPlayerArray());
      //startMessage();

        while (!playerController.getPlayerArray()[turnCount].b.getBankrupt()) {
            //Fokortelse af variabler
            Player currentPlayer = playerController.getPlayerArray()[turnCount];
            String currentPlayerName = currentPlayer.getPlayerName();
            //loop til afvente spillerens roll commando i consollen
            //playerRollInput();

            //ruller terninger med RaffleCup samt opdaterer spillerens position
            die.roll();
            System.out.println(currentPlayerName + " slog " + die.getDiceValue());

            playerController.movePlayer(currentPlayer, die.getDiceValue());

            fieldController.landOnField(currentPlayer, playerController);


            //Terningernes værdier sættes
            guiView.gui.setDie(die.getDiceValue());

            //placerer spillers bil på det rette felt
//            GUIView.MY_GUI_FIELDS[die.getDiceValue()].setCar(guiView.getGUIPlayer(turnCount), true);

            if (currentPlayer.b.getBankrupt()) {
                System.out.println(currentPlayerName + " ER GÅET FALLIT!!!");
                findWinner(playerController.getPlayerArray());
                break;
            }

            System.out.println(currentPlayerName + " har nu " + currentPlayer.b.getBalance() + "M på sin bankkonto");

            //I GUI sættes spillers balance
            //           guiView.getGUIPlayer(turnCount).setBalance(currentPlayer.b.getBalance());
//
//           guiView.getMyGUI().showMessage(currentPlayerName + field.getFieldMSG());

            //giver turen til spiller 1 fra den sidste spiller, eller giver turen videre fra spiller 1 til 2 fx
            turnCount = (turnCount + 1) % playerController.getPlayerArray().length;
            System.out.println("========================================\n");
        }
    }

    private void startMessage() {
        String start;
        String startMSG = "Spillet er klar - \nSkriv \"Start\" og tryk enter for at starte og slå de første terninger!" +
                "\nTryk \"OK\" på spillepladen for at lade turen gå videre!";

        do {
            System.out.println(startMSG);

            start = scan.nextLine();
        }
        while (!start.toLowerCase().equals("start"));

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
            System.out.println("Det er din tur " + playerController.getPlayerArray()[turnCount].getPlayerName()
                    + "\nSkriv \"Roll\" og tryk enter for at slå med terningerne!");

            rollInput = scan.nextLine();
        }
        while (!rollInput.toLowerCase().equals("roll"));

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
            System.out.println("SPILLET ER UAFGJORT!!!");
        } else {
            leadingPlayer.setPlayerWin();
            System.out.println(leadingPlayer.getPlayerName() + " HAR VUNDET MED " + leadingPlayer.b.getBalance() + "M SAMT "
                    + leadingPlayer.getTotalPropertyValue() + "M I EJENDOMME!!");
        }
    }
}