package Test;

import Game.Fields.Property;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertyTest {

    /** Test af field construktør*/
    @Test
    public void constructorTestName(){
        Property property = new Property("Horsensgade", 2,5, true);
        String actual = "Horsensgade";
        assertEquals(actual, property.getName());
    }

    @Test
    public void constructorTestFieldNumber(){
        Property property = new Property("Horsensgade", 2,5, true);
        int actual = 2;
        assertEquals(actual, property.getFieldNumber());
    }

    @Test
    public void constructorTestFielPrice(){
        Property property = new Property("Horsensgade", 2,5, true);
        int actual = 5;
        assertEquals(actual, property.getFieldPrice());
    }

    @Test
    public void constructorTestFielRent(){
        Property property = new Property("Horsensgade", 2,5, true);
        int actual = 5;
        assertEquals(actual, property.getFieldRent());
    }

    /** Test af setter og getter af fieldName*/
    @Test
    public void fieldNameTest(){
        Property property = new Property("Horsensgade", 2,5, true);
        property.setOwner(2);
        int actual = 2;
        assertEquals(actual, property.getPlayerID());
    }

    /** Tester om setter af playerID også setter ownedByPlayer*/
    @Test
    public void fieldOwnerTest(){
        Property property = new Property("Horsensgade", 2,5, true);
        property.setOwner(2);
        boolean actual = true;
        assertEquals(actual, property.getOwnedByPlayer());
    }

}