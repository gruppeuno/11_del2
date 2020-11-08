package Test;

import Game.Fields.Property;
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
    public void constructorTestFielPrice(){
        Property property = new Property("Horsensgade", 2,5, "test","test");
        int actual = 5;
        assertEquals(actual, property.getFieldPrice());
    }

    @Test
    public void constructorTestFielRent(){
        Property property = new Property("Horsensgade", 2,5, "test","test");
        int actual = 5;
        assertEquals(actual, property.getFieldRent());
    }


}