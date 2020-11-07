package Test;

import Game.GameController;
import Game.Player;
import Game.PlayerController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {

    /**Test af findWinner*/

    @Test
    public void findWinnerTest(){
        PlayerController playerController = new PlayerController();
        playerController.createPlayers(4);
        GameController gameControllerTest = new GameController();

        playerController.getPlayerArray()[0].b.setBalance(6);
        playerController.getPlayerArray()[1].b.setBalance(3);
        playerController.getPlayerArray()[2].b.setBalance(4);
        playerController.getPlayerArray()[3].b.setBalance(6);

        playerController.getPlayerArray()[0].b.setPropertyValue(50);
        playerController.getPlayerArray()[1].b.setPropertyValue(90);
        playerController.getPlayerArray()[2].b.setPropertyValue(60);
        playerController.getPlayerArray()[3].b.setPropertyValue(60);

        gameControllerTest.findWinner(playerController.getPlayerArray());

        boolean actual = true;

        assertEquals(actual,playerController.getPlayerArray()[3].getPlayerWin());




    }

}