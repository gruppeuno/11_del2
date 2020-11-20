package Test;

import Game.Fields.Property;
import Game.GameController;
import Game.PlayerController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {

    /**Test af findWinner*/

    //test af 1 spiller vinder
  @Test
  public void findWinnerTest(){

      PlayerController playerController = new PlayerController();
      playerController.createPlayers(4);
      GameController gameControllerTest = new GameController();

      playerController.getPlayerArray()[0].getBankAccount().setBalance(2);
      playerController.getPlayerArray()[1].getBankAccount().setBalance(3);
      playerController.getPlayerArray()[2].getBankAccount().setBalance(4);
      playerController.getPlayerArray()[3].getBankAccount().setBalance(5);

      Property p1 = new Property("Test", 1,2,"test","test");
      Property p2 = new Property("Test", 1,5,"test","test");
      Property p3 = new Property("Test", 1,3,"test","test");
      Property p4 = new Property("Test", 1,4,"test","test");
      Property p5 = new Property("Test", 1,1,"test","test");

      playerController.getPlayerArray()[0].addPropertyOwned(p1);
      playerController.getPlayerArray()[0].addPropertyOwned(p4);
      playerController.getPlayerArray()[1].addPropertyOwned(p2);
      playerController.getPlayerArray()[2].addPropertyOwned(p3);
      playerController.getPlayerArray()[3].addPropertyOwned(p5);

      boolean actual = true;
      gameControllerTest.findWinner(playerController.getPlayerArray());

      assertEquals(actual,playerController.getPlayerByName("p3").getPlayerWin());

  }

  //test af hvis 2 spillere har ens balance samt propertyValue
  @Test
  public void findWinnerTieTest(){
          PlayerController playerController = new PlayerController();
          playerController.createPlayers(4);
          GameController gameControllerTest = new GameController();

          playerController.getPlayerArray()[0].getBankAccount().setBalance(5);
          playerController.getPlayerArray()[1].getBankAccount().setBalance(5);
          playerController.getPlayerArray()[2].getBankAccount().setBalance(4);
          playerController.getPlayerArray()[3].getBankAccount().setBalance(5);

          Property p1 = new Property("Test", 1,2,"test","test");
          Property p2 = new Property("Test", 1,5,"test","test");
          Property p3 = new Property("Test", 1,3,"test","test");
          Property p4 = new Property("Test", 1,3,"test","test");
          Property p5 = new Property("Test", 1,4,"test","test");

          playerController.getPlayerArray()[0].addPropertyOwned(p1);
          playerController.getPlayerArray()[0].addPropertyOwned(p4);
          playerController.getPlayerArray()[1].addPropertyOwned(p2);
          playerController.getPlayerArray()[2].addPropertyOwned(p3);
          playerController.getPlayerArray()[3].addPropertyOwned(p5);

          gameControllerTest.findWinner(playerController.getPlayerArray());
  }

  //tester om spillere med samme balance bliver afgjort efter propertyValue
  @Test
  public void findWinnerEqualBalanceTest(){
      PlayerController playerController = new PlayerController();
      playerController.createPlayers(4);
      GameController gameControllerTest = new GameController();

      playerController.getPlayerArray()[0].getBankAccount().setBalance(5);
      playerController.getPlayerArray()[1].getBankAccount().setBalance(5);
      playerController.getPlayerArray()[2].getBankAccount().setBalance(4);
      playerController.getPlayerArray()[3].getBankAccount().setBalance(5);

      Property p1 = new Property("Test", 1,2,"test","test");
      Property p2 = new Property("Test", 1,5,"test","test");
      Property p3 = new Property("Test", 1,3,"test","test");
      Property p4 = new Property("Test", 1,4,"test","test");
      Property p5 = new Property("Test", 1,1,"test","test");

      playerController.getPlayerArray()[0].addPropertyOwned(p1);
      playerController.getPlayerArray()[0].addPropertyOwned(p4);
      playerController.getPlayerArray()[1].addPropertyOwned(p2);
      playerController.getPlayerArray()[2].addPropertyOwned(p3);
      playerController.getPlayerArray()[3].addPropertyOwned(p5);

      boolean actual = true;
      gameControllerTest.findWinner(playerController.getPlayerArray());

      assertEquals(actual,playerController.getPlayerByName("p0").getPlayerWin());
  }
}