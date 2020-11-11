package Test;

import Game.FieldController;
import Game.Fields.Jail;
import Game.Fields.JailVisit;
import Game.Player;
import Game.PlayerController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JailTest {

    @Test
    public void isPlayerInJail(){
        Player testPlayer1 = new Player("testPerson1");
        testPlayer1.putInJail();

        boolean expected = true;
        boolean actual = testPlayer1.getIsInPrison();

        assertEquals(expected,actual);
    }

  @Test
  public void isJailedPlayerMovedToJailVisitField(){
      Player testPlayer = new Player("testPerson");
      PlayerController playerController = new PlayerController();

      Jail jail = new Jail("testjail", 18, "test");
      JailVisit jailVisit = new JailVisit("testvisit", 6, "test");

      jail.fieldAction(testPlayer,playerController);

      int expected = jailVisit.getFieldNumber();
      int actual = testPlayer.getFieldNumber();

      assertEquals(expected,actual);

  }

  @Test
  public void isJailCostMillion(){

      FieldController fieldController = new FieldController();
      PlayerController playerController = new PlayerController();
      Player testPlayer = new Player("testPerson");
      Jail jail = new Jail("testjail", 18, "test");

      testPlayer.b.setBalance(20);
      //testspiller lander på fængsel
      jail.fieldAction(testPlayer,playerController);
      //spiller lander på nyt felt
      fieldController.landOnField(testPlayer,playerController);

      int expected = 19;
      int actual = testPlayer.b.getBalance();

      assertEquals(expected,actual);

  }

  @Test
    public void isJailCardWorks(){

      FieldController fieldController = new FieldController();
      PlayerController playerController = new PlayerController();
      Player testPlayer = new Player("testPerson");
      Jail jail = new Jail("testjail", 18, "test");

      testPlayer.b.setBalance(20);
      testPlayer.setJailCard(true);
      //testspiller lander på fængsel
      jail.fieldAction(testPlayer,playerController);
      //spiller lander på nyt felt
      fieldController.landOnField(testPlayer,playerController);

      int expected = 20;
      int actual = testPlayer.b.getBalance();
      
      assertEquals(actual,expected);


  }



}
