package Test;

import Game.Field;
import Game.FieldController;
import Game.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldControllerTest {

    //test af om buyField opdaterer ownedByPlayer i Field
    @Test
    public void buyFieldTest1(){
        Player testPlayer = new Player("testPerson");
        testPlayer.setPlayerID(3);

        Field testField = new Field("Horsensgade", 2,5, true);
        testField.setPlayerID(testPlayer.getPlayerID());
        testPlayer.b.updateBalance(testField.getFieldPrice());

        boolean actual =true;
        assertEquals(actual,testField.getOwnedByPlayer());
    }

    //test af om buyField opdaterer playerID i Field
    @Test
    public void buyFieldTest2(){
        Player testPlayer = new Player("testPerson");
        testPlayer.setPlayerID(3);

        Field testField = new Field("Horsensgade", 2,5, true);
        testField.setPlayerID(testPlayer.getPlayerID());
        testPlayer.b.updateBalance(testField.getFieldPrice());

        int actual =3;
        assertEquals(actual,testField.getPlayerID());
    }





}