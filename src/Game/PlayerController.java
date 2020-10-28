package Game;

import java.util.Scanner;

public class PlayerController {


    private String currentName;
    private int numberOfPlayers = 0;
    Scanner scan = new Scanner(System.in);
    //ARRAY
    Player[] playerArray;
    String[] playerNamesArray;

    //TODO: test metode
    public void testPlayerCreator(){
        this.playerArray= new Player[2];
        playerArray[0] = new Player("Stigh Høgh");
        playerArray[1] = new Player("Mads Nyborg");
    }

    public void playerCreator(){
        numberOfPlayers();
        createPlayers();
        playerNamesArray = new String[playerArray.length];

        for (int i = 0; i < playerArray.length; i++){
            int nr = i+1;
            System.out.println("spiller " + nr + " Indtast et navn der er mellem 3-12 tegn, spillere må ikke have samme navn:");
            String currentName = scan.next();
            playerNamesArray[i] = currentName;

           while (checkPlayerName(currentName,playerArray)) {
               System.out.print("Navnet du ønsker er ugyldigt. Vælg nyt navn: ");
               currentName = scan.next();
           }
            playerArray[i].setPlayerName(currentName);
        }
        System.out.println("========================================\n");
    }

    public void numberOfPlayers(){
        final int MAX = 8;
        final int MIN = 2;
        //While loop til at sikre at der er indtastet mellem 2-8 spillere
        System.out.println("Indtast et antal spillere mellem 2-8");
        do{
            while (!scan.hasNextInt()) {
                System.out.println("Ugyldigt input. Indtast et antal spillere mellem 2-8");
                scan.next();
            }
            numberOfPlayers = scan.nextInt();

            if (numberOfPlayers< MIN || numberOfPlayers> MAX)
                System.out.println("Ugyldigt antal spillere. Indtast et antal spillere mellem 2-8");
        }while (numberOfPlayers< MIN || numberOfPlayers> MAX);
        System.out.println("numberOfPlayers " + numberOfPlayers + "\n");
    }

    public void createPlayers(){
        this.playerArray = new Player[numberOfPlayers];
        for (int i = 0; i < playerArray.length; i++) {
            playerArray[i] = new Player("p" + i);
        }
    }

    public int getNumberOfPlayers(){
        return numberOfPlayers;
    }

    public boolean checkPlayerName(String name, Player[] array)
    {
        //Kontrollerer om navnet allerede er brugt
        for (int i = 0; i < playerArray.length; i++) {
            if (playerArray[i].getPlayerName().toLowerCase().equals(name.toLowerCase()))
                return true;
        }
        if (name.length() > 12 || name.length() < 3) {
            return true;
        } else {
            return false;
        }
    }

    public int getPlayerArrayLength(){
        return playerArray.length;
    }

    public String[] getPlayerNames() {
        return playerNamesArray;
    }

}




