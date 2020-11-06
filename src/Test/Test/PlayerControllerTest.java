package Test;

import Game.Player;
import Game.PlayerController;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


class PlayerControllerTest {

    //test af getPlayer
    @Test
    public void getPlayerTest(){
        PlayerController playerController = new PlayerController();
        playerController.createPlayers(2);
        Player player =playerController.getPlayerByName("p1");

        String actual = "p1";
        assertEquals(actual,player.getPlayerName());
    }

    //test af move player fra start
    @Test
    public void movePlayerTest(){
        PlayerController playerController = new PlayerController();
        playerController.createPlayers(2);

        playerController.movePlayer(playerController.getPlayerByName("p0"),5);
        int actual = 5;
        assertEquals(actual,playerController.getPlayerByName("p0").getFieldNumber());
    }

    //test af move player fra sidste matadorfelt
    @Test
    public void movePlayerFromLastFieldTest(){
        PlayerController playerController = new PlayerController();
        playerController.createPlayers(2);
        playerController.getPlayerByName("p0").setFieldNumber(23);
        playerController.movePlayer(playerController.getPlayerByName("p0"),1);
        int actual = 0;
        assertEquals(actual,playerController.getPlayerByName("p0").getFieldNumber());
    }

    /**Test af startbalance bliver opdateret*/

    //spiller 1
    @Test
    public void startBalance2PlayerTest(){
        PlayerController playerController = new PlayerController();
        playerController.createPlayers(2);

        int actual = 20;
        assertEquals(actual,playerController.getPlayerArray()[0].b.getBalance());
    }

    //spiller 2
    @Test
    public void startBalance2PlayerTest2(){
        PlayerController playerController = new PlayerController();
        playerController.createPlayers(2);

        int actual = 20;
        assertEquals(actual,playerController.getPlayerArray()[1].b.getBalance());
    }

    //Med 4 spillere
    @Test
    public void startBalance4PlayerTest(){
        PlayerController playerController = new PlayerController();
        playerController.createPlayers(4);

        int actual = 16;
        assertEquals(actual,playerController.getPlayerArray()[3].b.getBalance());
    }

}