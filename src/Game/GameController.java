package Game;

import java.util.Scanner;

public class GameController {

    private int turnCount = 0;
    //skaber nye objekter af hhv. GameTurn, Player for hver spille, RaffleCup og Scanner
    //Final modifier?
    private Field field = new Field();
    PlayerCreator playerCreator = new PlayerCreator();
    private RaffleCup cup = new RaffleCup();
    private String rollInput;


    //array med spillere, bruges sammen med turncount for at skifte spiller
    public void gameController() {

        playerCreator.playerCreator();

        //test metode til 2 spillere
        //playerCreator.testPlayerCreator();

        Scanner scan2 = new Scanner(System.in);

        while (!playerCreator.playerArray[turnCount].getPlayerWin()){
            do {

                //loop til afvente spillerens roll commando i consollen
                do {
                    System.out.println("Det er din tur " + playerCreator.playerArray[turnCount].getPlayerName() + "\nSkriv \"Roll\" og tryk enter for slå med terningerne!");

                    rollInput = scan2.nextLine();
                }
                while (!rollInput.toLowerCase().equals("roll"));

                //ruller terninger med RaffleCup
                cup.roll();

                //ingsætter terningernes værdi og spilleren hvis tur det er, i gameturn
                //som sørger for at der sker det rigtige ud fra hvad terningerne viser

                playerCreator.playerArray[turnCount].b.newBalance();


                //køre igennem flere gange hvis man slår dobbelt
            }while (playerCreator.playerArray[turnCount].getRollAgain());

            //checker om der er fundet en vinder efter turen
            if (playerCreator.playerArray[turnCount].getPlayerWin()){
                break;
            }

            //giver mulighed for at tilføje flere spillere, turn turnCount+1%playerArray.length
            //giver turen til spiller 1 fra den sidste spiller, eller giver turen videre fra spiller 1 til 2
            turnCount= (turnCount+1)%playerCreator.playerArray.length;
            System.out.println("========================================");
            System.out.println();
        }
        //lukker scanner
        scan2.close();
    }
}
