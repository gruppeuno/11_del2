package Test;

import Game.Controller.ChanceCardController;
import Game.Controller.FieldController;
import Game.Controller.PlayerController;
import Game.Model.Player;
import Game.View.GUIView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceCardControllerTest {

    @Test
    void moveField() {
        Player testplayer = new Player("Testperson");
        ChanceCardController chanceCardController = new ChanceCardController();
        testplayer.setFieldNumber(0);
        chanceCardController.moveField(testplayer,10);
        int actual = testplayer.getFieldNumber();
        int expected = 10;
        assertEquals(actual, expected);

    }

    //Test at spilleren rykker til start
    @Test
    void moveToStart() {
        Player testplayer = new Player("Testperson");
        ChanceCardController chanceCardController = new ChanceCardController();
        chanceCardController.moveToStart(testplayer);
        int actual =testplayer.getFieldNumber();
        int expected = 0;
        assertEquals(expected, actual);

    }

    @Test
    void takeFreeProperty() {
        Player testplayer = new Player("Testperson");
        ChanceCardController chanceCardController = new ChanceCardController();
        FieldController fieldController = new FieldController();
        PlayerController playerController = new PlayerController();
        GUIView guiView = new GUIView();

        testplayer.setFieldNumber(4);
        chanceCardController.takeFreeProperty(testplayer, playerController, fieldController, guiView);
        int actual = testplayer.getTotalPropertyValue();
        int expected = 1;
        assertEquals(actual, expected);
    }
}