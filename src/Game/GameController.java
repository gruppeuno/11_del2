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
//GUIView guiView = new GUIView();

/**
 * Main metode, kører spillet
 */
public void gameController() {

    //TODO: Rigtige metode til at køre med 2-6 spillere samt tildele navne
    playerController.playerCreator();

    //TODO: test metode til 2 spillere
    //playerController.createPlayers(2);

    //laver spillere i GUI
//    guiView.createGUIPlayers(playerController.getPlayerArray());
//    startMessage();

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

            fieldController.landOnField(currentPlayer,playerController);

            //Terningernes værdier sættes
           // guiView.gui.setDice(cup.getDiceValue());

            //placerer spillers bil på det rette felt
//            GUIView.MY_GUI_FIELDS[die.getDiceValue()].setCar(guiView.getGUIPlayer(turnCount), true);

        if(currentPlayer.b.getBankrupt()){
            System.out.println( currentPlayerName + " ER GÅET FALLIT!!!");
            break;
        }

        System.out.println(currentPlayerName + " har nu " + currentPlayer.b.getBalance() + "M på sin bankkonto");

            //I GUI sættes spillers balance
 //           guiView.getGUIPlayer(turnCount).setBalance(currentPlayer.b.getBalance());
//
//           guiView.getMyGUI().showMessage(currentPlayerName + field.getFieldMSG());

        //giver turen til spiller 1 fra den sidste spiller, eller giver turen videre fra spiller 1 til 2 fx
        turnCount = (turnCount + 1) % playerController.getPlayerArrayLength();
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

    public void findWinner(){
        Player winner;

        for (int i = 1; i < playerController.getPlayerArray().length; i++) {
            Player currentPlayer = playerController.getPlayerArray()[i-1];
            if (!currentPlayer.b.getBankrupt())
                if(currentPlayer.b.getBalance()>playerController.getPlayerArray()[i].b.getBalance())
                    winner = currentPlayer;
        }
        for (int j = 1; j < playerController.getPlayerArray().length; j++) {
            Player currentPlayer = playerController.getPlayerArray()[j-1];
            if (currentPlayer.b.getBalance()==playerController.getPlayerArray()[j].b.getBalance())
                if(currentPlayer.b.getPropertyValue()>playerController.getPlayerArray()[j].b.getPropertyValue())
                    winner=currentPlayer;
                else System.out.println("Spillet er uafgjort");

        }

    }

    //TODO; findWinner testmetode
    public void findWinner(Player[] playerArray){
        Player winner = playerArray[3];

        for (int i = 1; i < playerArray.length; i++) {
            Player currentPlayer = playerArray[i-1];
            if (!currentPlayer.b.getBankrupt())
                if(currentPlayer.b.getBalance()>playerArray[i].b.getBalance())
                    winner = currentPlayer;
        }
        if(winner.b.getBalance()<playerArray[playerArray.length-1].b.getBalance())
            winner=playerArray[playerArray.length-1];

        for (int j = 1; j < playerArray.length; j++) {
            Player currentPlayer = playerArray[j-1];
            if (currentPlayer.b.getBalance()==playerArray[j].b.getBalance())
                if(currentPlayer.b.getPropertyValue()>playerArray[j].b.getPropertyValue())
                    winner=currentPlayer;
                else System.out.println("Spillet er uafgjort");
        }
        winner.setPlayerWin();
    }

}