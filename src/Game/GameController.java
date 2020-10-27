package Game;

import gui_fields.GUI_Car;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.awt.*;
import java.util.Scanner;

public class GameController {

    //TODO: inddel GameController i mindre metoder
    private int turnCount;
    //skaber nye objekter af Field, RaffleCup og PlayerCreator
    final private Field field = new Field();
    final private PlayerController playerController = new PlayerController();
    final private RaffleCup cup = new RaffleCup();
    Scanner scan = new Scanner(System.in);

    public void gameController() {

        //TODO: Rigtige metode til at køre med 2-8 spillere samt tildele navne
        playerController.playerCreator();

        //TODO: test metode til 2 spillere
        //playerCreator.testPlayerCreator();
        int numberOfPlayers = playerController.getPlayerArrayLength();


        GUI gui = new GUI(FieldController.MY_GUI_FIELDS);
        Color[] myColors = {Color.RED, Color.BLUE, Color.YELLOW, Color.PINK, Color.GREEN, Color.BLACK, Color.WHITE, Color.CYAN};

        GUI_Player[] myPlayers = new GUI_Player[playerController.getPlayerArrayLength()];
        GUI_Car[] myCars = new GUI_Car[playerController.getPlayerArrayLength()];
        //laver spillere for GUI

        for (int i = 0; i < numberOfPlayers; i++) {
            myCars[i] = new GUI_Car();
            myCars[i].setPrimaryColor(myColors[i]);
            myPlayers[i] = new GUI_Player(playerController.playerArray[i].getPlayerName(), 1000, myCars[i]);
            gui.addPlayer(myPlayers[i]);
        }

        while (!playerController.playerArray[turnCount].getPlayerWin()) {
            //Fokortelse af variabler
            Player currentPlayer = playerController.playerArray[turnCount];
            String currentPlayerName = currentPlayer.getPlayerName();
            do {

                //loop til afvente spillerens roll commando i consollen
                //TODO: edit ind når spillet skal køre med input fra consol
                //playerRollInput();

                //ruller terninger med RaffleCup samt sætter fieldNumber = terningeværdien
                //og kalder på setField
                cup.roll();
                field.setFieldNumber(cup.getDiceValue());
                currentPlayer.setRollAgain(field.getRollAgain());

                gui.setDice(cup.getDie1Value(), cup.getDie2Value());

                System.out.println(currentPlayerName + " landede på felt " + field.getFieldNumber() + "\n" + currentPlayerName + field.getFieldMSG());

                //ingsætter terningernes værdi og spilleren hvis tur det er, i gameturn
                //som sørger for at der sker det rigtige ud fra hvad terningerne viser

                currentPlayer.b.updateBalance(field.getFieldValue());
                System.out.println(currentPlayerName + " har nu " + currentPlayer.b.getBalance() + "kr på sin bankkonto");


                myPlayers[turnCount].setBalance(currentPlayer.b.getBalance());


                //giver mulighed for køre igennem flere gange hvis man slår dobbelt
                //fra CDIO, Vi beholder da vi muligvis skal bruge i CDIO3
            } while (currentPlayer.getRollAgain());

            //checker om der er fundet en vinder efter turen
            if (currentPlayer.getPlayerWin()) {
                System.out.println("WINNER!!!!! =  " + currentPlayerName);
                break;
            }

            //giver mulighed for at tilføje flere spillere, turn turnCount+1%playerArray.length
            //giver turen til spiller 1 fra den sidste spiller, eller giver turen videre fra spiller 1 til 2
            turnCount = (turnCount + 1) % numberOfPlayers;
            System.out.println("========================================");
            System.out.println();
        }
    }

    private void playerRollInput() {
        String rollInput;

        do {
            System.out.println("Det er din tur " + playerController.playerArray[turnCount].getPlayerName() + "\nSkriv \"Roll\" og tryk enter for slå med terningerne!");

            rollInput = scan.nextLine();
        }
        while (!rollInput.toLowerCase().equals("roll"));

        //Lukker scanner hvis der er fundet en vinder
        if (playerController.playerArray[turnCount].getPlayerWin())
            scan.close();
    }

}