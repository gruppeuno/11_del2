package Game;

import gui_fields.GUI_Car;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
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

        GUI_Street gs1 = new GUI_Street("START", "GOOD LUCK", " ", " ", Color.RED, Color.BLACK);
        GUI_Street gs2 = new GUI_Street("1", " ", " ", " ", Color.RED, Color.BLACK);
        GUI_Street gs3 = new GUI_Street("2", "TOWER", "Et helligt tårn er gemt her..", "250 kr", Color.LIGHT_GRAY, Color.BLACK);
        GUI_Street gs4 = new GUI_Street("3", "CRATER", "Pas på krateret!!)", "-100kr", Color.YELLOW, Color.BLUE);
        GUI_Street gs5 = new GUI_Street("4", "PALACE GATES", "Hvad gemmer sig mon bag paladsets porte?", "100 kr", Color.GRAY, Color.PINK);
        GUI_Street gs6 = new GUI_Street("5", "COLD DESSERT", "Pak kufferten, for ellers ..", "-20 kr", Color.ORANGE, Color.BLUE);
        GUI_Street gs7 = new GUI_Street("6", "WALLED CITY", "Det siges man skal investere i mursten ..", "180 kr", Color.PINK, Color.RED);
        GUI_Street gs8 = new GUI_Street("7", "MONASTERY", "Hils på munke", "0 kr", Color.GREEN, Color.BLUE);
        GUI_Street gs9 = new GUI_Street("8", "BLACK CAVE", "Sku' ha' gået til Louis Nielsen", "-70 kr", Color.BLACK, Color.GREEN);
        GUI_Street gs10 = new GUI_Street("9", "HUTS IN THE MOUNTAIN", "Kan du finde hytten?", "60kr", Color.WHITE, Color.BLUE);
        GUI_Street gs11 = new GUI_Street("10", "THE WEREWALL", "Vogt dig.. ikke for sarte sjæle", "-80 kr", Color.GRAY, Color.YELLOW);
        GUI_Street gs12 = new GUI_Street("11", "THE PIT", "Take Care, man skulle jo nødig, tabe noget", "-50 kr", Color.RED, Color.BLUE);
        GUI_Street gs13 = new GUI_Street("12", "GOLDMINE", "$$$ KACHING $$$", "650 kr", Color.ORANGE, Color.YELLOW);
        GUI_Street gs14 = new GUI_Street("13", "QUICKSAND", "No trespassing", "-300kr", Color.YELLOW, Color.RED);
        GUI_Street gs15 = new GUI_Street("14", "'RONA HOTBOX", "Kom og hyg", " ", Color.MAGENTA, Color.YELLOW);
        GUI_Street gs16 = new GUI_Street("15", "BALLERUP PIZZA BURGER GRILL", "Vand til 5 kr", "200kr", Color.LIGHT_GRAY, Color.BLACK);

        GUI gui = new GUI(new GUI_Street[]{gs1, gs2, gs3, gs4, gs5, gs6, gs7, gs8, gs9, gs10, gs11, gs12, gs13, gs14, gs15, gs16});

        //TODO: Rigtige metode til at køre med 2-8 spillere samt tildele navne
        playerController.playerCreator();

        //TODO: test metode til 2 spillere
        //playerCreator.testPlayerCreator();
        int numberOfPlayers = playerController.getPlayerArrayLength();



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