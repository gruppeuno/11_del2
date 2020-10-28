package Test;

import Game.Player;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


class PlayerControllerTest {

    public int numberOfPlayers;
    Player[] playerArray;

    @Test
    public void NumberOfPlayerTest() {
        numberOfPlayers();
        createPlayers();
        assertTrue(2 <= playerArray.length && playerArray.length <= 8);
    }

    public void numberOfPlayers(){


        //While loop til at sikre at der er indtastet mellem 2-8 spillere
        System.out.println("Indtast et antal spillere mellem 2-8");
        final int MAX = 8;
        final int MIN = 2;
        do{
            numberOfPlayers = (int)(Math.random() * 7) + 2;

            if (numberOfPlayers< MIN || numberOfPlayers> MAX)
                System.out.println("Ugyldigt antal spillere. Indtast et antal spillere mellem 2-8");
        }while (numberOfPlayers< MIN || numberOfPlayers> MAX);
        System.out.println("numberOfPlayers " + numberOfPlayers);
        System.out.println();
    }
    public void createPlayers(){
        this.playerArray = new Player[numberOfPlayers];
        for (int i = 0; i < playerArray.length; i++) {
            playerArray[i] = new Player("p" + i);
        }
    }
}