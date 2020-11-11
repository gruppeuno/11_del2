package Test;

import Game.FieldController;
import Game.Fields.Property;
import Game.Player;
import Game.PlayerController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertyTest {

    /** Test af field construktør*/
    @Test
    public void constructorTestName(){
        Property property = new Property("Horsensgade", 2,5, "test","test");
        String actual = "Horsensgade";
        assertEquals(actual, property.getName());
    }

    @Test
    public void constructorTestFieldNumber(){
        Property property = new Property("Horsensgade", 2,5, "test","test");
        int actual = 2;
        assertEquals(actual, property.getFieldNumber());
    }

    @Test
    public void constructorTestFieldPrice(){
        Property property = new Property("Horsensgade", 2,5, "test","test");
        int actual = 5;
        assertEquals(actual, property.getFieldPrice());
    }

    @Test
    public void constructorTestFieldRent(){
        Property property = new Property("Horsensgade", 2,5, "test","test");
        int actual = 5;
        assertEquals(actual, property.getFieldRent());
    }

    //Test om owner bliver sat til true
    @Test
    public void buyPropertyOwnerTest(){
        Player testPlayer = new Player("testPerson");
        Property testProperty = new Property("Horsensgade", 2,5,"test","test");
        FieldController testFieldController = new FieldController();

        testPlayer.b.setBalance(100);

        testProperty.buyProperty(testPlayer);

        boolean actual = true;
        assertEquals(actual,testProperty.getOwnedByPlayer());
    }

    //test af om buyProperty opdaterer ownedByPlayer i Field
    @Test
    public void buyPropertyTest1(){
        Player testPlayer = new Player("testPerson");

        Property testProperty = new Property("Horsensgade", 2,5,"test","test");
        testProperty.setOwner(testPlayer.getPlayerName());
        testPlayer.b.subBalance(testProperty.getFieldPrice());

        boolean actual = true;
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

        testPlayer.b.setBalance(100);

        testProperty.buyProperty(testPlayer);

        int actual = 95;
        assertEquals(actual,testPlayer.b.getBalance());
    }

    //test af om grundens ejer bliver opdateret
    @Test
    public void buyPropertyOwnerNameTest(){
        Player testPlayer = new Player("testPerson");
        Property testProperty = new Property("Horsensgade", 2,5,"test","test");

        testPlayer.b.setBalance(100);

        testProperty.buyProperty(testPlayer);

        String actual = "testPerson";
        assertEquals(actual,testProperty.getOwnerName());
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

        testProperty.payRent(testPlayer, testPlayerController);

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

        testProperty.payRent(testPlayer, testPlayerController);

        int actual = 105;
        assertEquals(actual,testPlayerController.getPlayerByName("p0").b.getBalance());
    }






}