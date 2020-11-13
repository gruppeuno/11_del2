package Test;

import Game.GameController;
import Game.Player;
import Game.PlayerController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {

    /**Test af findWinner*/

    //test af 1 spiller vinder
  //  @Test
  //  public void findWinnerTest(){
//
  //      PlayerController playerController = new PlayerController();
  //      playerController.createPlayers(4);
  //      GameController gameControllerTest = new GameController();
//
  //      playerController.getPlayerArray()[0].b.setBalance(2);
  //      playerController.getPlayerArray()[1].b.setBalance(3);
  //      playerController.getPlayerArray()[2].b.setBalance(4);
  //      playerController.getPlayerArray()[3].b.setBalance(5);
//
  //      playerController.getPlayerArray()[0].b.setPropertyValue(50);
  //      playerController.getPlayerArray()[1].b.setPropertyValue(90);
  //      playerController.getPlayerArray()[2].b.setPropertyValue(30);
  //      playerController.getPlayerArray()[3].b.setPropertyValue(60);
//
  //      boolean actual = true;
  //      gameControllerTest.findWinner(playerController.getPlayerArray());
//
  //      assertEquals(actual,playerController.getPlayerByName("p3").getPlayerWin());
//
  //  }
//
  //  //test af hvis 2 spillere har ens balance samt propertyValue
  //  @Test
  //  public void findWinnerTieTest(){
//
  //      PlayerController playerController = new PlayerController();
  //      playerController.createPlayers(4);
  //      GameController gameControllerTest = new GameController();
//
  //      playerController.getPlayerArray()[0].b.setBalance(2);
  //      playerController.getPlayerArray()[1].b.setBalance(3);
  //      playerController.getPlayerArray()[2].b.setBalance(5);
  //      playerController.getPlayerArray()[3].b.setBalance(5);
//
  //      playerController.getPlayerArray()[0].b.setPropertyValue(50);
  //      playerController.getPlayerArray()[1].b.setPropertyValue(20);
  //      playerController.getPlayerArray()[2].b.setPropertyValue(90);
  //      playerController.getPlayerArray()[3].b.setPropertyValue(90);
//
  //      boolean actual = false;
  //      gameControllerTest.findWinner(playerController.getPlayerArray());
//
  //      assertEquals(actual,playerController.getPlayerByName("p1").getPlayerWin());
  //  }
//
  //  //tester om spillere med samme balance bliver afgjort efter propertyValue
  //  @Test
  //  public void findWinnerEqualBalanceTest(){
//
  //      PlayerController playerController = new PlayerController();
  //      playerController.createPlayers(4);
  //      GameController gameControllerTest = new GameController();
//
  //      playerController.getPlayerArray()[0].b.setBalance(5);
  //      playerController.getPlayerArray()[1].b.setBalance(3);
  //      playerController.getPlayerArray()[2].b.setBalance(4);
  //      playerController.getPlayerArray()[3].b.setBalance(5);
//
  //      playerController.getPlayerArray()[0].b.setPropertyValue(70);
  //      playerController.getPlayerArray()[1].b.setPropertyValue(90);
  //      playerController.getPlayerArray()[2].b.setPropertyValue(30);
  //      playerController.getPlayerArray()[3].b.setPropertyValue(60);
//
  //      boolean actual = true;
  //      gameControllerTest.findWinner(playerController.getPlayerArray());
//
  //      assertEquals(actual,playerController.getPlayerByName("p0").getPlayerWin());
//
  //  }

}