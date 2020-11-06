package Test;

import Game.FieldController;
import Game.Fields.Property;
import Game.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldControllerTest {

    //test af om buyField opdaterer ownedByPlayer i Field
    @Test
    public void buyFieldTest1(){
        Player testPlayer = new Player("testPerson");

        Property testProperty = new Property("Horsensgade", 2,5);
        testProperty.setOwner(testPlayer.getPlayerName());
        testPlayer.b.updateBalance(testProperty.getFieldPrice());

        boolean actual =true;
        assertEquals(actual, testProperty.getOwnedByPlayer());
    }

    //test af om buyField opdaterer playerID i Field
    @Test
    public void buyFieldTest2(){
        Player testPlayer = new Player("testPerson");

        Property testProperty = new Property("Horsensgade", 2,5);
        testProperty.setOwner(testPlayer.getPlayerName());
        testPlayer.b.updateBalance(testProperty.getFieldPrice());

        int actual =3;
        assertEquals(actual, testProperty.getOwnerName());
    }


    /**Test af buyProperty*/

    //test af balance opdatering
    @Test
    public void buyPropertyBalanceTest(){
        Player testPlayer = new Player("testPerson");
        Property testProperty = new Property("Horsensgade", 2,5);
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
        Property testProperty = new Property("Horsensgade", 2,5);
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
        Property testProperty = new Property("Horsensgade", 2,5);
        FieldController testFieldController = new FieldController();

        testPlayer.b.setBalance(100);

        testFieldController.buyProperty(testPlayer,testProperty);

        boolean actual = true;
        assertEquals(actual,testProperty.getOwnedByPlayer());
    }

    /** Test af payRent*/



}