package Test;

import Game.FieldController;
import Game.Fields.JailVisit;
import Game.Fields.Property;
import Game.Player;
import Game.PlayerController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldControllerTest {

    //test af om buyProperty opdaterer ownedByPlayer i Field
    @Test
    public void buyPropertyTest1(){
        Player testPlayer = new Player("testPerson");

        Property testProperty = new Property("Horsensgade", 2,5,"test","test");
        testProperty.setOwner(testPlayer.getPlayerName());
        testPlayer.b.subBalance(testProperty.getFieldPrice());

        boolean actual =true;
        assertEquals(actual, testProperty.getOwnedByPlayer());
    }

    //test af om buyProperty opdaterer playerID i Field
    @Test
    public void buyPropertyTest2(){
        Player testPlayer = new Player("testPerson");

        Property testProperty = new Property("Horsensgade", 2,5,"test","test");
        testProperty.setOwner(testPlayer.getPlayerName());
        testPlayer.b.subBalance(testProperty.getFieldPrice());

        String actual ="testPerson";
        assertEquals(actual, testProperty.getOwnerName());
    }


    /**Test af buyProperty*/

    //test af balance opdatering
    @Test
    public void buyPropertyBalanceTest(){
        Player testPlayer = new Player("testPerson");
        Property testProperty = new Property("Horsensgade", 2,5,"test","test");
        FieldController testFieldController = new FieldController();

        testPlayer.b.setBalance(100);

        testFieldController.buyProperty(testPlayer,testProperty);

        int actual = 95;
        assertEquals(actual,testPlayer.b.getBalance());
    }

    //test af om grundens ejer bliver opdateret
    @Test
    public void buyPropertyOwnerNameTest(){
        Player testPlayer = new Player("testPerson");
        Property testProperty = new Property("Horsensgade", 2,5,"test","test");
        FieldController testFieldController = new FieldController();

        testPlayer.b.setBalance(100);

        testFieldController.buyProperty(testPlayer,testProperty);

        String actual = "testPerson";
        assertEquals(actual,testProperty.getOwnerName());
    }

    //Test om owner bliver sat til true
    @Test
    public void buyPropertyOwnerTest(){
        Player testPlayer = new Player("testPerson");
        Property testProperty = new Property("Horsensgade", 2,5,"test","test");
        FieldController testFieldController = new FieldController();

        testPlayer.b.setBalance(100);

        testFieldController.buyProperty(testPlayer,testProperty);

        boolean actual = true;
        assertEquals(actual,testProperty.getOwnedByPlayer());
    }

    /** Test af payRent*/

    //Test af om payrent betaling bliver trukket fra spilleren der lander på et ejet felt
    @Test
    public void payRentTest(){
        PlayerController testPlayerController = new PlayerController();
        Player testPlayer = new Player("testPerson");
        Property testProperty = new Property("Horsensgade", 2,5,"test","test");
        FieldController testFieldController = new FieldController();

        //skaber 2 nye spillere i playerarray
        testPlayerController.createPlayers(2);

        //sætter owner til p0, det samme som spilleren hedder efter kald på createPlayers ovenfor.
        testProperty.setOwner("p0");
        //setter begge spillers balance til 100
        testPlayer.b.setBalance(100);
        testPlayerController.getPlayerByName("p0").b.setBalance(100);

        testFieldController.payRent(testPlayer,testProperty,testPlayerController);

        int actual = 95;
        assertEquals(actual,testPlayer.b.getBalance());
    }

    //Test af om payRent betaling går igennem til den modtagende spiller
    @Test
    public void recieveRentTest(){
        PlayerController testPlayerController = new PlayerController();
        Player testPlayer = new Player("testPerson");
        Property testProperty = new Property("Horsensgade", 2,5,"test","test");
        FieldController testFieldController = new FieldController();

        //skaber 2 nye spillere i playerarray
        testPlayerController.createPlayers(2);

        //sætter owner til p0, det samme som spilleren hedder efter kald på createPlayers ovenfor.
        testProperty.setOwner("p0");
        //setter begge spillers balance til 100
        testPlayer.b.setBalance(100);
        testPlayerController.getPlayerByName("p0").b.setBalance(100);

        testFieldController.payRent(testPlayer,testProperty,testPlayerController);

        int actual = 105;
        assertEquals(actual,testPlayerController.getPlayerByName("p0").b.getBalance());
    }

    /** test af putInJail() */

    //test af om spiller bliver sat i array i JailVisit

    @Test
    public void putInJailTest(){
        FieldController fieldController = new FieldController();
        Player testPlayer = new Player("testPerson");

        fieldController.putInJail("testPerson");

        String actual = "testPerson";
        JailVisit jailVisit = (JailVisit) fieldController.getFields()[6];
        assertEquals(actual, jailVisit.getPlayersInJailArray()[0]);
    }

    @Test
    public void putInJailMangeSpillereTest(){
        FieldController fieldController = new FieldController();
        Player testPlayer = new Player("testPerson");
        Player testPlayer1 = new Player("testPerson1");
        Player testPlayer2 = new Player("testPerson2");
        Player testPlayer3 = new Player("testPerson3");
        Player testPlayer4 = new Player("testPerson4");
        Player testPlayer5 = new Player("testPerson5");

        fieldController.putInJail("testPerson1");
        fieldController.putInJail("testPerson2");
        fieldController.putInJail("testPerson");
        fieldController.putInJail("testPerson3");
        fieldController.putInJail("testPerson4");
        fieldController.putInJail("testPerson5");

        String actual = "testPerson3";
        JailVisit jailVisit = (JailVisit) fieldController.getFields()[6];
        assertEquals(actual, jailVisit.getPlayersInJailArray()[3]);
    }

    //Test af putOutJail fjerner spillernavnet fra playersInJail arrayet
    @Test
    public void putOutJailTest() {
        PlayerController playerController = new PlayerController();
        FieldController fieldController = new FieldController();
        playerController.createPlayers(4);

        fieldController.putInJail("p0");
        fieldController.putInJail("p1");
        fieldController.putInJail("p2");
        fieldController.putInJail("p3");

        fieldController.putOutJail(playerController);

        int actual = 3;
        JailVisit jailVisit = (JailVisit) fieldController.getFields()[6];
        assertEquals(actual, jailVisit.getPlayersInJailArray().length);
    }

    //Test af putOutJail sætter playersInJail arrayet til null efter sidste spiller er fjernet
    @Test
    public void putOutJailNullTest() {
        PlayerController playerController = new PlayerController();
        FieldController fieldController = new FieldController();
        playerController.createPlayers(4);

        fieldController.putInJail("p0");

        fieldController.putOutJail(playerController);

        JailVisit jailVisit = (JailVisit) fieldController.getFields()[6];

        String[] actual = null;
        assertEquals(actual, jailVisit.getPlayersInJailArray());
    }

    //Test af om spiller balance bliver mindre med 1
    @Test
    public void putOutJailSubBalanceTest() {
        PlayerController playerController = new PlayerController();
        FieldController fieldController = new FieldController();
        playerController.createPlayers(4);

        fieldController.putInJail("p0");

        fieldController.putOutJail(playerController);

        JailVisit jailVisit = (JailVisit) fieldController.getFields()[6];

        int actual = 15;
        assertEquals(actual, playerController.getPlayerByName("p0").b.getBalance());
    }


    /**Test af ownedBySamePlayer*/

    //positiv test
  // @Test
  // public void ownedBySamePlayerTest(){
  //     PlayerController playerController = new PlayerController();
  //     FieldController fieldController = new FieldController();
  //     playerController.createPlayers(2);
  //     Property prop1 = (Property) fieldController.getFields()[1];
  //     Property prop2 = (Property) fieldController.getFields()[2];
  //     prop1.setOwner("p1");
  //     prop2.setOwner("p1");
  //     playerController.getPlayerArray()[0].setFieldNumber(1);

  //     boolean actual = true;

  //     assertEquals(actual,fieldController.ownedBySamePlayer(playerController.getPlayerByName("p0"),prop1));
  // }

}