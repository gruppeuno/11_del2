package Test;

import Game.FieldController;
import Game.Fields.Property;
import Game.Player;
import Game.PlayerController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertyTest {

    /** Test af field construktør*/
    @Test
    public void constructorTestName(){
        Property property = new Property("Horsensgade", 2,5, "test","test");
        String actual = "Horsensgade";
        assertEquals(actual, property.getName());
    }

    @Test
    public void constructorTestFieldNumber(){
        Property property = new Property("Horsensgade", 2,5, "test","test");
        int actual = 2;
        assertEquals(actual, property.getFieldNumber());
    }

    @Test
    public void constructorTestFieldPrice(){
        Property property = new Property("Horsensgade", 2,5, "test","test");
        int actual = 5;
        assertEquals(actual, property.getFieldPrice());
    }

    @Test
    public void constructorTestFieldRent(){
        Property property = new Property("Horsensgade", 2,5, "test","test");
        int actual = 5;
        assertEquals(actual, property.getFieldRent());
    }


    /**Test af om setDoubleRent bliver kaldt når spiller køber 2. grund af samme farve*/

  //  //test af om rent bliver dobbelt
  //  @Test
  //  public void buyPropertySetDoubleRentTest(){
  //      PlayerController testPlayerController = new PlayerController();
  //      Property testProperty = new Property("testVej", 2,4,"test","blå");
  //      Property testProperty1 = new Property("testVej1", 2,4,"test","rød");
  //      Property testProperty2 = new Property("testVej2", 2,4,"test","gul");
  //      Property testProperty3 = new Property("testVej3", 2,4,"test","rød");
//
  //      //skaber 2 nye spillere i playerarray
  //      testPlayerController.createPlayers(2);
//
  //      testProperty.buyProperty(testPlayerController.getPlayerByName("p0"), testPlayerController);
  //      testProperty1.buyProperty(testPlayerController.getPlayerByName("p0"), testPlayerController);
  //      testProperty2.buyProperty(testPlayerController.getPlayerByName("p0"), testPlayerController);
  //      testProperty3.buyProperty(testPlayerController.getPlayerByName("p0"), testPlayerController);
//
  //      int actual = 8;
  //      assertEquals(actual,testProperty3.getFieldRent());
  //  }





}