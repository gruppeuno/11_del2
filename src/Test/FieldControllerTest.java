import Game.Field;
import Game.FieldController;
import Game.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldControllerTest {

    /** test af om fields variable ownedByPlayer bliver true når felt købes*/
    @Test
    public void buyFieldTest(){
        Player testPlayer = new Player("testPerson");
        testPlayer.setPlayerID(3);

        Field testField = new Field("Horsensgade", 2,5);
        testField.setPlayerID(testPlayer.getPlayerID());
        testPlayer.b.updateBalance(testField.getFieldPrice());

        boolean actual =true;
        assertEquals(actual,testField.getOwnedByPlayer());

    }


}