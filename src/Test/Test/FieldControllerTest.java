package Test;

import Game.Fields.Property;
import Game.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldControllerTest {

    //test af om buyField opdaterer ownedByPlayer i Field
    @Test
    public void buyFieldTest1(){
        Player testPlayer = new Player("testPerson");
        testPlayer.setPlayerID(3);

        Property testProperty = new Property("Horsensgade", 2,5, true);
        testProperty.setOwner(testPlayer.getPlayerID());
        testPlayer.b.updateBalance(testProperty.getFieldPrice());

        boolean actual =true;
        assertEquals(actual, testProperty.getOwnedByPlayer());
    }

    //test af om buyField opdaterer playerID i Field
    @Test
    public void buyFieldTest2(){
        Player testPlayer = new Player("testPerson");
        testPlayer.setPlayerID(3);

        Property testProperty = new Property("Horsensgade", 2,5, true);
        testProperty.setOwner(testPlayer.getPlayerID());
        testPlayer.b.updateBalance(testProperty.getFieldPrice());

        int actual =3;
        assertEquals(actual, testProperty.getPlayerID());
    }





}