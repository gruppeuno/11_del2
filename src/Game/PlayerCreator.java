package Game;

import java.util.Arrays;
import java.util.Scanner;

public class PlayerCreator {

    private final int MAX = 8;
    private final int MIN = 2;
    private String currentName;

    //ARRAY
    Player[] playerArray;

    public void testPlayerCreator(){
        this.playerArray= new Player[2];
        playerArray[0] = new Player("gab");
        playerArray[1] = new Player("dan");

    }


    public void playerCreator(){

        Scanner scan = new Scanner(System.in);

        this.playerArray = new Player[numberOfPlayers()];

        for (int i = 0; i < playerArray.length; i++){
            int nr = i+1;
            System.out.println("spiller " + nr + " Indtast et navn der er mellem 3-12 tegn, spillere må ikke have samme navn:");
            currentName = scan.next();

            while (playerNameEquals(currentName,playerArray)) {
                System.out.print("Navnet du ønsker er ugyldigt. Vælg nyt navn: ");
                currentName = scan.next();
            }
            playerArray[i] = new Player(currentName);

        }
        //muligt fjern
        scan.close();
    }

    public int numberOfPlayers(){
        //TODO: do while
        Scanner scan = new Scanner(System.in);
        int numberOfPlayers = 0;
        //While loop til at sikre at der er indtastet mellem 2-8 spillere
        while (numberOfPlayers<MIN || numberOfPlayers>MAX){
            System.out.println("Indtast et antal spillere mellem 2-8");
            numberOfPlayers = scan.nextInt();

            if (numberOfPlayers<MIN || numberOfPlayers>MAX)
                System.out.println("Ugyldigt antal spillere");
        }
        System.out.println("numberOfPlayers " + numberOfPlayers);
        System.out.println();

        //muligt fjern
        scan.close();
        return numberOfPlayers;
    }

    public boolean playerNameEquals(String name, Player[] array)
    {
        if(Arrays.asList(array).toString().contains(name.toLowerCase())){
            return true;
        }
        else if (name.length()>12 || name.length()<3){
            return true;
        }
        else {
            return false;
        }

    }


}




