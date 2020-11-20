package Test;

import Game.Fields.Property;
import Game.GameController;
import Game.Player;
import Game.PlayerController;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


class PlayerControllerTest {

    //test af getPlayer
    @Test
    public void getPlayerTest() {
        PlayerController playerController = new PlayerController();
        playerController.createPlayers(2);
        Player player = playerController.getPlayerByName("p1");

        String actual = "p1";
        assertEquals(actual, player.getPlayerName());
    }

    //test af move player fra start
    @Test
    public void movePlayerTest() {
        PlayerController playerController = new PlayerController();
        playerController.createPlayers(2);

        playerController.movePlayer(playerController.getPlayerByName("p0"), 5);
        int actual = 5;
        assertEquals(actual, playerController.getPlayerByName("p0").getFieldNumber());
    }

    //test af move player fra sidste matadorfelt
    @Test
    public void movePlayerFromLastFieldTest() {
        PlayerController playerController = new PlayerController();
        playerController.createPlayers(2);
        playerController.getPlayerByName("p0").setFieldNumber(23);
        playerController.movePlayer(playerController.getPlayerByName("p0"), 1);
        int actual = 0;
        assertEquals(actual, playerController.getPlayerByName("p0").getFieldNumber());
    }

    //test af move player fra sidste matadorfelt ændre balance
    @Test
    public void movePlayerFromLastFieldBalanceTest() {
        PlayerController playerController = new PlayerController();
        playerController.createPlayers(2);
        playerController.getPlayerByName("p0").setFieldNumber(23);
        playerController.getPlayerByName("p0").getBankAccount().setBalance(0);
        playerController.movePlayer(playerController.getPlayerByName("p0"), 1);
        int actual = 2;
        assertEquals(actual, playerController.getPlayerByName("p0").getBankAccount().getBalance());
    }

    /**
     * Test af startbalance bliver opdateret
     */

    //spiller 1
    @Test
    public void startBalance2PlayerTest() {
        PlayerController playerController = new PlayerController();
        playerController.createPlayers(2);

        int actual = 20;
        assertEquals(actual, playerController.getPlayerArray()[0].getBankAccount().getBalance());
    }

    //spiller 2
    @Test
    public void startBalance2PlayerTest2() {
        PlayerController playerController = new PlayerController();
        playerController.createPlayers(2);

        int actual = 20;
        assertEquals(actual, playerController.getPlayerArray()[1].getBankAccount().getBalance());
    }

    //Med 4 spillere
    @Test
    public void startBalance4PlayerTest() {
        PlayerController playerController = new PlayerController();
        playerController.createPlayers(4);

        int actual = 16;
        assertEquals(actual, playerController.getPlayerArray()[3].getBankAccount().getBalance());
    }

    /**
     * Test af remove property
     */

    //test af add property
    @Test
    public void addPropertyTest() {
        PlayerController playerController = new PlayerController();
        playerController.createPlayers(4);
        Property testProp = new Property("BURGERBAREN", 1, 1, "Du landede på burgerbaren", "brown");
        playerController.getPlayerByName("p0").addPropertyOwned(testProp);

        int actual = 1;
        assertEquals(actual, playerController.getPlayerByName("p0").getPropertiesOwned().size());
    }

    @Test
    public void playerCreateTimeTest(){
        long startTime = System.currentTimeMillis();
        PlayerController playerController = new PlayerController();
        playerController.createPlayers(2);
        long endTime = System.currentTimeMillis();
        boolean timeUnder10 = false;
        if (endTime - startTime < 10000)
            timeUnder10 = true;

        assertEquals(true,timeUnder10);
    }
}