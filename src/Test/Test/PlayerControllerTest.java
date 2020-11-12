package Test;

import Game.Fields.Property;
import Game.Player;
import Game.PlayerController;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


class PlayerControllerTest {

    //test af getPlayer
    @Test
    public void getPlayerTest(){
        PlayerController playerController = new PlayerController();
        playerController.createPlayers(2);
        Player player =playerController.getPlayerByName("p1");

        String actual = "p1";
        assertEquals(actual,player.getPlayerName());
    }

    //test af move player fra start
    @Test
    public void movePlayerTest(){
        PlayerController playerController = new PlayerController();
        playerController.createPlayers(2);

        playerController.movePlayer(playerController.getPlayerByName("p0"),5);
        int actual = 5;
        assertEquals(actual,playerController.getPlayerByName("p0").getFieldNumber());
    }

    //test af move player fra sidste matadorfelt
    @Test
    public void movePlayerFromLastFieldTest(){
        PlayerController playerController = new PlayerController();
        playerController.createPlayers(2);
        playerController.getPlayerByName("p0").setFieldNumber(23);
        playerController.movePlayer(playerController.getPlayerByName("p0"),1);
        int actual = 0;
        assertEquals(actual,playerController.getPlayerByName("p0").getFieldNumber());
    }

    //test af move player fra sidste matadorfelt ændre balance
    @Test
    public void movePlayerFromLastFieldBalanceTest(){
        PlayerController playerController = new PlayerController();
        playerController.createPlayers(2);
        playerController.getPlayerByName("p0").setFieldNumber(23);
        playerController.getPlayerByName("p0").b.setBalance(0);
        playerController.movePlayer(playerController.getPlayerByName("p0"),1);
        int actual = 2;
        assertEquals(actual,playerController.getPlayerByName("p0").b.getBalance());
    }
    /**Test af startbalance bliver opdateret*/

    //spiller 1
    @Test
    public void startBalance2PlayerTest(){
        PlayerController playerController = new PlayerController();
        playerController.createPlayers(2);

        int actual = 20;
        assertEquals(actual,playerController.getPlayerArray()[0].b.getBalance());
    }

    //spiller 2
    @Test
    public void startBalance2PlayerTest2(){
        PlayerController playerController = new PlayerController();
        playerController.createPlayers(2);

        int actual = 20;
        assertEquals(actual,playerController.getPlayerArray()[1].b.getBalance());
    }

    //Med 4 spillere
    @Test
    public void startBalance4PlayerTest(){
        PlayerController playerController = new PlayerController();
        playerController.createPlayers(4);

        int actual = 16;
        assertEquals(actual,playerController.getPlayerArray()[3].b.getBalance());
    }

    /** Test af remove property */

    //test af add property
    @Test
    public void addPropertyTest(){
        PlayerController playerController = new PlayerController();
        playerController.createPlayers(4);
        Property testProp = new Property("BURGERBAREN", 1,1, "Du landede på burgerbaren","brown");
        playerController.getPlayerByName("p0").addPropertyOwned(testProp);

        int actual = 1;
        assertEquals(actual,playerController.getPlayerByName("p0").getPropertiesOwned().size());
    }

    //test af remove property
  // @Test
  // public void removePropertyTest(){
  //     PlayerController playerController = new PlayerController();
  //     playerController.createPlayers(4);
  //     Property testProp = new Property("BURGERBAREN", 1,1, "Du landede på burgerbaren","brown");
  //     playerController.getPlayerByName("p0").addPropertyOwned(testProp);
  //     playerController.sellProperty(playerController.getPlayerArray()[0],1);

  //     int actual = 0;
  //     assertEquals(actual ,playerController.getPlayerByName("p0").getPropertiesOwned().size());
  // }

    //test af remove property sætter spiller til bankrupt true hvis spiller ikke har flere ejendomme
  //  @Test
  //  public void removePropertyBankruptTest(){
  //      PlayerController playerController = new PlayerController();
  //      playerController.createPlayers(4);
  //      Property testProp = new Property("BURGERBAREN", 1,1, "Du landede på burgerbaren","brown");
  //      playerController.getPlayerByName("p0").addPropertyOwned(testProp);
  //      playerController.getPlayerByName("p0").b.setBalance(0);
  //      playerController.sellProperty(playerController.getPlayerArray()[0],1);
//
  //      boolean actual = true;
  //      assertEquals(actual ,playerController.getPlayerByName("p0").b.getBankrupt());
  //  }
//
  //  //test af bankrupt med større payment end hvad spillerens grunde kan betale
  //  @Test
  //  public void removePropertyBankruptBigTest(){
  //      PlayerController playerController = new PlayerController();
  //      playerController.createPlayers(4);
  //      Property testProp = new Property("BURGERBAREN", 1,1, "Du landede på burgerbaren","brown");
  //      playerController.getPlayerByName("p0").addPropertyOwned(testProp);
  //      playerController.getPlayerByName("p0").b.setBalance(0);
  //      playerController.sellProperty(playerController.getPlayerArray()[0],2);
//
  //      boolean actual = true;
  //      assertEquals(actual ,playerController.getPlayerByName("p0").b.getBankrupt());
  //  }
//
  //  /** Test af handlePayment*/
  //  //Tester om handlePayment gennemfører betaling
  //  @Test
  //  public void handlePaymentTest(){
  //      PlayerController playerController = new PlayerController();
  //      playerController.createPlayers(4);
  //      playerController.getPlayerByName("p0").b.setBalance(5);
  //      playerController.handlePayment(playerController.getPlayerByName("p0"),4);
//
  //      int actual = 1;
  //      assertEquals(1,playerController.getPlayerByName("p0").b.getBalance());
  //  }
//
    //Tester om handlePayment sætter Bankrupt til true hvis betalingen er større end balancen
 //   @Test
 //   public void handlePaymentBankruptTest(){
 //       PlayerController playerController = new PlayerController();
 //       playerController.createPlayers(4);
 //       playerController.getPlayerByName("p0").b.setBalance(4);
 //       playerController.handlePayment(playerController.getPlayerByName("p0"),5);
//
 //       boolean actual = true;
 //       assertEquals(true,playerController.getPlayerByName("p0").b.getBankrupt());
 //   }

    //TODO skal testes om spilleren kan betale med properties

}