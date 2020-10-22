package Game;

import java.util.Scanner;

public class GameController {

    private int turnCount = 0;

    //skaber nye objekter af hhv. GameTurn, Player for hver spille, RaffleCup og Scanner
    private final Field turn = new Field();
    private final Player player1 = new Player("gab");
    private final Player player2 = new Player("kris");
    private final Scanner scan = new Scanner(System.in);
    //array med spillere, bruges sammen med turncount for at skifte spiller
    private final Player[] playerArray = {player1, player2};

    public void gameController() {

        System.out.println("Player 1 skriv dit navn og tryk enter:");
        String namePlayer1 = scan.nextLine();
        player1.setPlayerName(namePlayer1);
        System.out.println("\nPlayer 2 skriv dit navn og tryk enter:");
        String namePlayer2 = scan.nextLine();

        while (namePlayer1.toLowerCase().equals(namePlayer2.toLowerCase())) {
            System.out.println("Begge spillere kan ikke have samme nav. Player 2 vælg nyt navn.");
            namePlayer2 = scan.nextLine();
        }

        player2.setPlayerName(namePlayer2);
        System.out.println("\nSpillet starter....");

        while (!playerArray[turnCount].getPlayerWin()){
            do {

                //loop til afvente spillerens roll commando i consollen
                String rollInput;
                do {
                    System.out.println("Det er din tur " + playerArray[turnCount].getPlayerName() + "\nSkriv \"Roll\" og tryk enter for slå med terningerne!");

                    rollInput = scan.nextLine();
                }
                while (!rollInput.toLowerCase().equals("roll"));


                //ingsætter terningernes værdi og spilleren hvis tur det er, i gameturn
                //som sørger for at der sker det rigtige ud fra hvad terningerne viser

                turn.FieldValue(/*BankKnonto balance her*/, playerArray[turnCount]);

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
