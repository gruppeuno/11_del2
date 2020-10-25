package Game;

import gui_fields.GUI_Car;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.awt.*;
import java.util.Scanner;

public class GameController {

    //TODO: inddel GameController i mindre metoder
    private int turnCount = 0;
    //skaber nye objekter af hhv. GameTurn, Player for hver spille, RaffleCup og Scanner
    //Final modifier?
    private Field field = new Field();
    PlayerCreator playerCreator = new PlayerCreator();
    private RaffleCup cup = new RaffleCup();
    GUI gui = new GUI();

    //array med spillere, bruges sammen med turncount for at skifte spiller
    public void gameController() {

        //TODO: Rigtige metode til at køre med 2-8 spillere samt tildele navne
        //playerCreator.playerCreator();

        //TODO: test metode til 2 spillere
        playerCreator.testPlayerCreator();


        //laver spillere for GUI
        /*for (int i = 0; i < playerCreator.getPlayerArrayLength(); i++){

            GUI_Car car = new GUI_Car();
            car.setPrimaryColor(Color.PINK);
            GUI_Player player = new GUI_Player(playerCreator.playerArray[turnCount].getPlayerName(),1000, car);
            gui.addPlayer(player);
        }*/

        GUI_Car car1 = new GUI_Car();
        car1.setPrimaryColor(Color.BLUE); //Lad den være gul
        GUI_Player Stig = new GUI_Player("Stig",1000,car1);
        gui.addPlayer(Stig);

        GUI_Car car2 = new GUI_Car();
        car2.setPrimaryColor(Color.RED); //Lad den være gul
        GUI_Player Mads = new GUI_Player("Mads",1000,car2);
        gui.addPlayer(Mads);

        while (!playerCreator.playerArray[turnCount].getPlayerWin()){
            String currentPlayerName = playerCreator.playerArray[turnCount].getPlayerName();
            do {

                //loop til afvente spillerens roll commando i consollen
                playerRollInput();

                //ruller terninger med RaffleCup samt sætter fieldNumber = terningeværdien
                //og kalder på setField
                field.setFieldNumber(cup.roll());
                gui.setDice(cup.getDie1Value(), cup.getDie2Value());
                System.out.println(currentPlayerName +" landede på felt " + field.getFieldNumber() + "\n" + currentPlayerName + field.getFieldMSG());

                //ingsætter terningernes værdi og spilleren hvis tur det er, i gameturn
                //som sørger for at der sker det rigtige ud fra hvad terningerne viser

                playerCreator.playerArray[turnCount].b.newBalance(field.getFieldValue());
                System.out.println(currentPlayerName + " har nu " + playerCreator.playerArray[turnCount].b.getBalance() + "kr på sin bankkonto");

                if (turnCount == 0) {
                    Stig.setBalance(playerCreator.playerArray[turnCount].b.getBalance());
                } else {
                    Mads.setBalance(playerCreator.playerArray[turnCount].b.getBalance());
                }

                //giver mulighed for køre igennem flere gange hvis man slår dobbelt
                //fra CDIO, Vi beholder da vi muligvis skal bruge i CDIO3
            }while (playerCreator.playerArray[turnCount].getRollAgain());

            //checker om der er fundet en vinder efter turen
            if (playerCreator.playerArray[turnCount].getPlayerWin()){
                System.out.println("WINNER!!!!! =  " + currentPlayerName);
                break;
            }

            //giver mulighed for at tilføje flere spillere, turn turnCount+1%playerArray.length
            //giver turen til spiller 1 fra den sidste spiller, eller giver turen videre fra spiller 1 til 2
            turnCount= (turnCount+1)%playerCreator.playerArray.length;
            System.out.println("========================================");
            System.out.println();
        }
    }

    private void playerRollInput(){
        Scanner scan2 = new Scanner(System.in);
        String rollInput;
        //TODO: comment ind igen efter test
        /*
        do {
            System.out.println("Det er din tur " + playerCreator.playerArray[turnCount].getPlayerName() + "\nSkriv \"Roll\" og tryk enter for slå med terningerne!");

            rollInput = scan2.nextLine();
        }
        while (!rollInput.toLowerCase().equals("roll"));

        //Lukker scanner hvis der er fundet en vinder
        if (playerCreator.playerArray[turnCount].getPlayerWin())
            scan2.close();

         */
    }


}
