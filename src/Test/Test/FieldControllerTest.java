package Test;

import Game.FieldController;
import Game.Fields.Jail;
import Game.Fields.JailVisit;
import Game.Fields.Property;
import Game.Player;
import Game.PlayerController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldControllerTest {


    /** test af putInJail() */

    //test af om spiller bliver sat i array i JailVisit






    /**Test af landOnJail*/

    @Test
    public void isPlayerInJail(){
        Player testPlayer1 = new Player("testPerson1");
        testPlayer1.putInJail();

        boolean expected = true;
        boolean actual = testPlayer1.getIsInPrison();

        assertEquals(expected,actual);
    }


    //test af om spiller bliver rykket fra Jail til JailVisit
 @Test
 public void isJailedPlayerMovedToJailVisitField(){
     Player testPlayer = new Player("testPerson");
     PlayerController playerController = new PlayerController();
     FieldController fieldController = new FieldController();

     fieldController.landOnJail(testPlayer,playerController,(Jail) fieldController.getFields()[18]);
     int actual = 6;

     assertEquals(actual,testPlayer.getFieldNumber());
 }

 @Test
 public void playerIsInPrison(){
    Player testPlayer = new Player("testPerson");
    PlayerController playerController = new PlayerController();
    FieldController fieldController = new FieldController();

    fieldController.landOnJail(testPlayer,playerController,(Jail) fieldController.getFields()[18]);
    boolean actual = true;

    assertEquals(actual,testPlayer.getIsInPrison());
 }

 @Test
   public void isJailCardWorks(){

     FieldController fieldController = new FieldController();
     PlayerController playerController = new PlayerController();
     playerController.createPlayers(2);
     Player testPlayer = playerController.getPlayerByName("p0");

     Jail jail = new Jail("testjail", 18, "test");

     testPlayer.b.setBalance(20);
     testPlayer.setJailCard(true);

     //testspiller lander på fængsel
     fieldController.landOnJail(testPlayer,playerController, jail);

     //spiller lander på nyt felt
     fieldController.landOnProperty(testPlayer,playerController, (Property)fieldController.getFields()[10]);

     //Spiller lander på skatepark og køber for 2M
     int expected = 18;
     int actual = testPlayer.b.getBalance();
     assertEquals(actual,expected);
 }

 //test af om spiller betaler for at komme ud af fængsel
    @Test
    public void playerPayToGetOut(){

        FieldController fieldController = new FieldController();
        PlayerController playerController = new PlayerController();
        playerController.createPlayers(2);
        Player testPlayer = playerController.getPlayerByName("p0");

        Jail jail = new Jail("testjail", 18, "test");

        testPlayer.b.setBalance(20);

        //testspiller lander på fængsel
        fieldController.landOnJail(testPlayer,playerController, jail);


        //spiller lander på nyt felt
        testPlayer.setFieldNumber(10);
        fieldController.landOnField(testPlayer,playerController);

        //Spiller lander på skatepark og køber for 2M
        int expected = 17;
        int actual = testPlayer.b.getBalance();
        assertEquals(actual,expected);
    }


}