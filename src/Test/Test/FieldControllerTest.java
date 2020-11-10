package Test;

import Game.FieldController;
import Game.Fields.JailVisit;
import Game.Fields.Property;
import Game.Player;
import Game.PlayerController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//class FieldControllerTest {
//
//    //test af om buyProperty opdaterer ownedByPlayer i Field
//    @Test
//    public void buyPropertyTest1(){
//        Player testPlayer = new Player("testPerson");
//
//        Property testProperty = new Property("Horsensgade", 2,5,"test","test");
//        testProperty.setOwner(testPlayer.getPlayerName());
//        testPlayer.b.subBalance(testProperty.getFieldPrice());
//
//        boolean actual =true;
//        assertEquals(actual, testProperty.getOwnedByPlayer());
//    }
//
//    //test af om buyProperty opdaterer playerID i Field
//    @Test
//    public void buyPropertyTest2(){
//        Player testPlayer = new Player("testPerson");
//
//        Property testProperty = new Property("Horsensgade", 2,5,"test","test");
//        testProperty.setOwner(testPlayer.getPlayerName());
//        testPlayer.b.subBalance(testProperty.getFieldPrice());
//
//        String actual ="testPerson";
//        assertEquals(actual, testProperty.getOwnerName());
//    }
//
//
//    /**Test af buyProperty*/
//
//    //test af balance opdatering
//    @Test
//    public void buyPropertyBalanceTest(){
//        Player testPlayer = new Player("testPerson");
//        Property testProperty = new Property("Horsensgade", 2,5,"test","test");
//        FieldController testFieldController = new FieldController();
//
//        testPlayer.b.setBalance(100);
//
//        testFieldController.buyProperty(testPlayer,testProperty);
//
//        int actual = 95;
//        assertEquals(actual,testPlayer.b.getBalance());
//    }
//
//    //test af om grundens ejer bliver opdateret
//    @Test
//    public void buyPropertyOwnerNameTest(){
//        Player testPlayer = new Player("testPerson");
//        Property testProperty = new Property("Horsensgade", 2,5,"test","test");
//        FieldController testFieldController = new FieldController();
//
//        testPlayer.b.setBalance(100);
//
//        testFieldController.buyProperty(testPlayer,testProperty);
//
//        String actual = "testPerson";
//        assertEquals(actual,testProperty.getOwnerName());
//    }
//
//    //Test om owner bliver sat til true
//    @Test
//    public void buyPropertyOwnerTest(){
//        Player testPlayer = new Player("testPerson");
//        Property testProperty = new Property("Horsensgade", 2,5,"test","test");
//        FieldController testFieldController = new FieldController();
//
//        testPlayer.b.setBalance(100);
//
//        testFieldController.buyProperty(testPlayer,testProperty);
//
//        boolean actual = true;
//        assertEquals(actual,testProperty.getOwnedByPlayer());
//    }
//
//    /** Test af payRent*/
//
//    //Test af om payrent betaling bliver trukket fra spilleren der lander på et ejet felt
//    @Test
//    public void payRentTest(){
//        PlayerController testPlayerController = new PlayerController();
//        Player testPlayer = new Player("testPerson");
//        Property testProperty = new Property("Horsensgade", 2,5,"test","test");
//        FieldController testFieldController = new FieldController();
//
//        //skaber 2 nye spillere i playerarray
//        testPlayerController.createPlayers(2);
//
//        //sætter owner til p0, det samme som spilleren hedder efter kald på createPlayers ovenfor.
//        testProperty.setOwner("p0");
//        //setter begge spillers balance til 100
//        testPlayer.b.setBalance(100);
//        testPlayerController.getPlayerByName("p0").b.setBalance(100);
//
//        testFieldController.payRent(testPlayer,testProperty,testPlayerController);
//
//        int actual = 95;
//        assertEquals(actual,testPlayer.b.getBalance());
//    }
//
//    //Test af om payRent betaling går igennem til den modtagende spiller
//    @Test
//    public void recieveRentTest(){
//        PlayerController testPlayerController = new PlayerController();
//        Player testPlayer = new Player("testPerson");
//        Property testProperty = new Property("Horsensgade", 2,5,"test","test");
//        FieldController testFieldController = new FieldController();
//
//        //skaber 2 nye spillere i playerarray
//        testPlayerController.createPlayers(2);
//
//        //sætter owner til p0, det samme som spilleren hedder efter kald på createPlayers ovenfor.
//        testProperty.setOwner("p0");
//        //setter begge spillers balance til 100
//        testPlayer.b.setBalance(100);
//        testPlayerController.getPlayerByName("p0").b.setBalance(100);
//
//        testFieldController.payRent(testPlayer,testProperty,testPlayerController);
//
//        int actual = 105;
//        assertEquals(actual,testPlayerController.getPlayerByName("p0").b.getBalance());
//    }
//
//    /** test af putInJail() */
//
//    //test af om spiller bliver sat i array i JailVisit
//
//
//
//
//
//
//    /**Test af ownedBySamePlayer*/
//
//    //positiv test
//  // @Test
//  // public void ownedBySamePlayerTest(){
//  //     PlayerController playerController = new PlayerController();
//  //     FieldController fieldController = new FieldController();
//  //     playerController.createPlayers(2);
//  //     Property prop1 = (Property) fieldController.getFields()[1];
//  //     Property prop2 = (Property) fieldController.getFields()[2];
//  //     prop1.setOwner("p1");
//  //     prop2.setOwner("p1");
//  //     playerController.getPlayerArray()[0].setFieldNumber(1);
//
//  //     boolean actual = true;
//
//  //     assertEquals(actual,fieldController.ownedBySamePlayer(playerController.getPlayerByName("p0"),prop1));
//  // }
//
//}