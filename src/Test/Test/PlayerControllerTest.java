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
        Player player =playerController.getPlayer("p1");

        String actual = "p1";
        assertEquals(actual,player.getPlayerName());
    }

    //test af move player fra start
    @Test
    public void movePlayerTest(){
        PlayerController playerController = new PlayerController();
        playerController.createPlayers(2);

        playerController.movePlayer(playerController.getPlayer("p0"),5);
        int actual = 5;
        assertEquals(actual,playerController.getPlayer("p0").getFieldNumber());
    }

    //test af move player fra sidste matadorfelt
    @Test
    public void movePlayerFromLastFieldTest(){
        PlayerController playerController = new PlayerController();
        playerController.createPlayers(2);
        playerController.getPlayer("p0").setFieldNumber(23);
        playerController.movePlayer(playerController.getPlayer("p0"),1);
        int actual = 0;
        assertEquals(actual,playerController.getPlayer("p0").getFieldNumber());
    }

}