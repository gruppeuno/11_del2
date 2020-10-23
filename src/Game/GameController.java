package Game;

import java.util.Scanner;

public class GameController {

    private int turnCount = 0;

    //skaber nye objekter af hhv. GameTurn, Player for hver spille, RaffleCup og Scanner
    private final Field field = new Field();
    PlayerCreator playerCreator = new PlayerCreator();
    private final RaffleCup cup = new RaffleCup();
    private final Scanner scan = new Scanner(System.in);
    //array med spillere, bruges sammen med turncount for at skifte spiller

    public void gameController() {


        playerCreator.numberOfPlayers();
        playerCreator.playerCreator();


        Player[] playerArray = playerCreator.playerArray;

        while (!playerArray[turnCount].getPlayerWin()){
            do {

                //loop til afvente spillerens roll commando i consollen
                String rollInput;
                do {
                    System.out.println("Det er din tur " + playerArray[turnCount].getPlayerName() + "\nSkriv \"Roll\" og tryk enter for slå med terningerne!");

                    rollInput = scan.nextLine();
                }
                while (!rollInput.toLowerCase().equals("roll"));

                //ruller terninger med RaffleCup
                cup.roll();

                //ingsætter terningernes værdi og spilleren hvis tur det er, i gameturn
                //som sørger for at der sker det rigtige ud fra hvad terningerne viser


                field.getFieldValue();

                //køre igennem flere gange hvis man slår dobbelt
            }while (playerArray[turnCount].getRollAgain());

            //checker om der er fundet en vinder efter turen
            if (playerArray[turnCount].getPlayerWin()){
                break;
            }

            //giver mulighed for at tilføje flere spillere, turn turnCount+1%playerArray.length
            //giver turen til spiller 1 fra den sidste spiller, eller giver turen videre fra spiller 1 til 2
            turnCount= (turnCount+1)%playerArray.length;
            System.out.println("========================================");
            System.out.println();
        }
        //lukker scanner
        scan.close();
    }
}
