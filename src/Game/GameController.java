package Game;


import java.util.Scanner;

/**
 * GameController
 * @author Gruppe11
 */

public class GameController {

    private int turnCount;
    //skaber nye objekter af Field, RaffleCup og PlayerCreator
    final private Field field = new Field();
    final private PlayerController playerController = new PlayerController();
    final private RaffleCup cup = new RaffleCup();
    Scanner scan = new Scanner(System.in);
    GUIView guiView = new GUIView();


    /**
     * Main metode, kører spillet
     */
    public void gameController() {

        //TODO: Rigtige metode til at køre med 2-6 spillere samt tildele navne
        playerController.playerCreator();

        //TODO: test metode til 2 spillere
        //playerCreator.testPlayerCreator();

        //laver spillere i GUI
        guiView.createGUIPlayers(playerController.playerArray);

        startMessage();

        while (!playerController.playerArray[turnCount].getPlayerWin()) {
            //Fokortelse af variabler
            Player currentPlayer = playerController.playerArray[turnCount];
            String currentPlayerName = currentPlayer.getPlayerName();
            do {
                //loop til afvente spillerens roll commando i consollen
                //TODO: edit ind her når spillet skal køre med input fra consol

                //fjerner alle biler fra brættet (GUI)
                GUIView.MY_GUI_FIELDS[cup.getDiceValue()].removeAllCars();

                //ruller terninger med RaffleCup samt sætter fieldNumber = terningeværdien
                //og kalder på setField
                cup.roll();
                field.setFieldNumber(cup.getDiceValue());
                currentPlayer.setRollAgain(field.getRollAgain());

                //Terningernes værdier sættes
                guiView.gui.setDice(cup.getDie1Value(),cup.getDie2Value());

                System.out.println(currentPlayerName + " landede på felt " + field.getFieldNumber() + "\n" + currentPlayerName + field.getFieldMSG());

                //placerer spillers bil på det rette felt
                GUIView.MY_GUI_FIELDS[cup.getDiceValue()].setCar(guiView.getGUIPlayer(turnCount), true);

                //ingsætter terningernes værdi og spilleren hvis tur det er, i gameturn
                //som sørger for at der sker det rigtige ud fra hvad terningerne viser

                currentPlayer.b.updateBalance(field.getFieldValue());
                System.out.println(currentPlayerName + " har nu " + currentPlayer.b.getBalance() + "kr på sin bankkonto");

                //I GUI sættes spillers balance
                guiView.getGUIPlayer(turnCount).setBalance(currentPlayer.b.getBalance());

                guiView.getMyGUI().showMessage(currentPlayerName + field.getFieldMSG());

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
        if (playerController.playerArray[turnCount].getPlayerWin())
            scan.close();

    }

/*
    *
     * Loop der kører indtil spilleren har indtastet "roll"
     * hvis spilleren har vunder lukkes scanneren
*/
/*    private void playerRollInput() {
        String rollInput;

        do {
            System.out.println("Det er din tur " + playerController.playerArray[turnCount].getPlayerName() + "\nSkriv \"Roll\" og tryk enter for at slå med terningerne!");

            rollInput = scan.nextLine();
        }
        while (!rollInput.toLowerCase().equals("roll"));

        //Lukker scanner hvis der er fundet en vinder
        if (playerController.playerArray[turnCount].getPlayerWin())
            scan.close();
    }*/

}