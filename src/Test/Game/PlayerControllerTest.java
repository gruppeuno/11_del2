package Game;

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
        assertEquals(actual,playerController.getPlayer("p1").getPlayerName());
    }

}