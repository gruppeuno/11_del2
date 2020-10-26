package Game;

import java.util.Arrays;
import java.util.Scanner;

public class PlayerCreator {

    private int numberOfPlayers = 0;
    Scanner scan = new Scanner(System.in);

    //ARRAY
    Player[] playerArray;

    //TODO: test metode
    public void testPlayerCreator(){
        this.playerArray= new Player[2];
        playerArray[0] = new Player("Stigh Høgh");
        playerArray[1] = new Player("Mads Nyborg");
    }

    public void playerCreator(){

        numberOfPlayers();

        this.playerArray = new Player[numberOfPlayers];

        for (int i = 0; i < playerArray.length; i++){
            int nr = i+1;
            System.out.println("spiller " + nr + " Indtast et navn der er mellem 3-12 tegn, spillere må ikke have samme navn:");
            String currentName = scan.next();

            while (playerNameEquals(currentName,playerArray)) {
                System.out.print("Navnet du ønsker er ugyldigt. Vælg nyt navn: ");
                currentName = scan.next();
            }
            playerArray[i] = new Player(currentName);
        }
        System.out.println("========================================\n");
    }

    public void numberOfPlayers(){
        //While loop til at sikre at der er indtastet mellem 2-8 spillere
        System.out.println("Indtast et antal spillere mellem 2-8");
        final int MAX = 8;
        final int MIN = 2;
        do{
            numberOfPlayers = scan.nextInt();

            if (numberOfPlayers< MIN || numberOfPlayers> MAX)
                System.out.println("Ugyldigt antal spillere. Indtast et antal spillere mellem 2-8");
        }while (numberOfPlayers< MIN || numberOfPlayers> MAX);
        System.out.println("numberOfPlayers " + numberOfPlayers);
        System.out.println();
    }

    public boolean playerNameEquals(String name, Player[] array)
    {
        //Kontrollerer om navnet allerede er brugt
        for (int i = 1; i < playerArray.length; i++) {
            if (playerArray[i].getPlayerName().equals(name.toLowerCase()))
                return true;
        }
        if (name.length()>12 || name.length()<3){
            return true;
        }
        else {
            return false;
        }

    }

    public int getPlayerArrayLength(){
        return playerArray.length;
    }



}




