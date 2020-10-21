import Game.Player;

import java.util.Arrays;
import java.util.Scanner;

public class PlayerCreator {

    private final int MAX = 8;
    private final int MIN = 2;
    private String currentName;
    private final int numberOfPlayers;

    Scanner scan = new Scanner(System.in);


    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void PlayerCreator(){

        Player[] playerArray = new Player[numberOfPlayers];

        for (int i = 0; i < numberOfPlayers; i++){
            int nr = i+1;

            playerArray[i] = new Player(currentName);


            while (!playerNameEquals(currentName,playerArray)) {
                System.out.println("spiller " + nr + " Indtast dit navn");
                currentName = scan.next();
                playerArray[i].setPlayerName(currentName);
                System.out.println("playernavn  " + playerArray[i]);
            }
        }
    }

    public void numberOfPlayers(){
        //While loop til at sikre at der er indtastet mellem 2-8 spillere
        while (numberOfPlayers<MIN || numberOfPlayers>MAX){
            System.out.println("Indtast antal spillere");
            numberOfPlayers = scan.nextInt();
        }

        System.out.println("numberOfPlayers" + numberOfPlayers);
        System.out.println();
    }

    public boolean playerNameEquals(String name, Player[] array)
    {
        if(Arrays.asList(array).contains(name)){
            return true;
        }
        else return false;
    }



}

class test {
    public static void main(String[] args) {
        PlayerCreator payer = new PlayerCreator();
        payer.numberOfPlayers();
        payer.PlayerCreator();
    }
}

