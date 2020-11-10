package Test;

import Game.FieldController;
import Game.Fields.Jail;
import Game.Fields.JailVisit;
import Game.Player;
import Game.PlayerController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JailVisitTest {

    //Test af putOutJail fjerner spillernavnet fra playersInJail arrayet

    //TODO: TEST VIRKER IKKE
    @Test
    public void putOutJailTest() {

        PlayerController playerController = new PlayerController();
        Jail jail = new Jail("testjail", 18, "test");
        JailVisit jailVisit = new JailVisit("testvisit", 6, "test");
        playerController.createPlayers(4);

        jail.putInJail("p0");
        jail.putInJail("p1");
        jail.putInJail("p2");
        jail.putInJail("p3");

        jailVisit.fieldAction(playerController.getPlayerByName("p0"), playerController);

        int actual = 3;
        assertEquals(actual, jailVisit.getPlayersInJailArray().length);
    }

  // //Test af putOutJail sætter playersInJail arrayet til null efter sidste spiller er fjernet
  // @Test
  // public void putOutJailNullTest() {
  //     PlayerController playerController = new PlayerController();
  //     FieldController fieldController = new FieldController();
  //     playerController.createPlayers(4);

  //     fieldController.putInJail("p0");

  //     fieldController.putOutJail(playerController);

  //     JailVisit jailVisit = (JailVisit) fieldController.getFields()[6];

  //     String[] actual = null;
  //     assertEquals(actual, jailVisit.getPlayersInJailArray());
  // }

  // //Test af om spiller balance bliver mindre med 1
  // @Test
  // public void putOutJailSubBalanceTest() {
  //     PlayerController playerController = new PlayerController();
  //     FieldController fieldController = new FieldController();
  //     playerController.createPlayers(4);

  //     fieldController.putInJail("p0");

  //     fieldController.putOutJail(playerController);

  //     JailVisit jailVisit = (JailVisit) fieldController.getFields()[6];

  //     int actual = 15;
  //     assertEquals(actual, playerController.getPlayerByName("p0").b.getBalance());
  // }

}