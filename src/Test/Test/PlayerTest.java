package Test;

import Game.Fields.Property;
import Game.PlayerController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    /**Test af getTotalPropertyValue*/
    //Tester for om en property bliver registeret som "ejet" af spilleren
    @Test
    public void getTotalPropertyValueTest(){
        PlayerController playerController = new PlayerController();
        playerController.createPlayers(2);
        Property testProp = new Property("BURGERBAREN", 1,1, "Du landede på burgerbaren","brown");
        playerController.getPlayerByName("p0").addPropertyOwned(testProp);
        playerController.getPlayerByName("p0").b.setBalance(0);

        int actual = 1;
        assertEquals(1,playerController.getPlayerByName("p0").getTotalPropertyValue());

    }

    //Tester for om flere properties bliver registeret som "ejet" af spilleren
    @Test
    public void getTotalPropertyValueTest2(){
        PlayerController playerController = new PlayerController();
        playerController.createPlayers(2);
        Property testProp1 = new Property("BURGERBAREN", 1,1, "Du landede på burgerbaren","brown");
        Property testProp2 = new Property("BURGERBAREN", 1,2, "Du landede på burgerbaren","brown");
        Property testProp3 = new Property("BURGERBAREN", 1,1, "Du landede på burgerbaren","brown");
        Property testProp4 = new Property("BURGERBAREN", 1,5, "Du landede på burgerbaren","brown");
        Property testProp5 = new Property("BURGERBAREN", 1,1, "Du landede på burgerbaren","brown");
        playerController.getPlayerByName("p0").addPropertyOwned(testProp1);
        playerController.getPlayerByName("p0").addPropertyOwned(testProp2);
        playerController.getPlayerByName("p0").addPropertyOwned(testProp3);
        playerController.getPlayerByName("p0").addPropertyOwned(testProp4);
        playerController.getPlayerByName("p0").addPropertyOwned(testProp5);
        playerController.getPlayerByName("p0").b.setBalance(0);

        int actual = 10;
        assertEquals(10,playerController.getPlayerByName("p0").getTotalPropertyValue());

    }
}