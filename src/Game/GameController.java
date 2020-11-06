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
    //playerCreator.testPlayerCreator();

    //laver spillere i GUI
//    guiView.createGUIPlayers(playerController.getPlayerArray());
//
//    startMessage();

    while (!playerController.getPlayerArray()[turnCount].getPlayerWin()) {
        //Fokortelse af variabler
        Player currentPlayer = playerController.getPlayerArray()[turnCount];
        String currentPlayerName = currentPlayer.getPlayerName();
        do {
            //loop til afvente spillerens roll commando i consollen
            playerRollInput();

            //ruller terninger med RaffleCup samt opdaterer spillerens position
            die.roll();
            playerController.movePlayer(currentPlayer, die.getDiceValue());

            fieldController.landOnField(currentPlayer,playerController);

            //Terningernes værdier sættes
           // guiView.gui.setDice(cup.getDiceValue());

            System.out.println(currentPlayerName + " landede på felt " + currentPlayer.getFieldNumber());

            //placerer spillers bil på det rette felt
//            GUIView.MY_GUI_FIELDS[die.getDiceValue()].setCar(guiView.getGUIPlayer(turnCount), true);

            System.out.println(currentPlayerName + " har nu " + currentPlayer.b.getBalance() + "kr på sin bankkonto");

            //I GUI sættes spillers balance
 //           guiView.getGUIPlayer(turnCount).setBalance(currentPlayer.b.getBalance());
//
 //           guiView.getMyGUI().showMessage(currentPlayerName + field.getFieldMSG());

            //giver mulighed for køre igennem flere gange hvis man slår dobbelt
        } while (currentPlayer.getRollAgain());

        //checker om der er fundet en vinder efter turen
        if (currentPlayer.getPlayerWin()) {
            System.out.println("WINNER!!!!! =  " + currentPlayerName);
            break;
        }

        //giver mulighed for at tilføje flere spillere, turn turnCount+1%playerArray.length
        //giver turen til spiller 1 fra den sidste spiller, eller giver turen videre fra spiller 1 til 2
        turnCount = (turnCount + 1) % playerController.getPlayerArrayLength();;
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
    *
     * Loop der kører indtil spilleren har indtastet "roll"
     * hvis spilleren har vunder lukkes scanneren
*/
    private void playerRollInput() {
        String rollInput;

        do {
            System.out.println("Det er din tur " + playerController.getPlayerArray()[turnCount].getPlayerName() + "\nSkriv \"Roll\" og tryk enter for at slå med terningerne!");

            rollInput = scan.nextLine();
        }
        while (!rollInput.toLowerCase().equals("roll"));

        //Lukker scanner hvis der er fundet en vinder
        if (playerController.getPlayerArray()[turnCount].getPlayerWin())
            scan.close();
    }

}