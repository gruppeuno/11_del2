import Game.Field;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    /** Test af field construktør*/
    @Test
    public void constructorTestName(){
        Field field = new Field("Horsensgade", 2,5,1);
        String actual = "Horsensgade";
        assertEquals(actual,field.getName());
    }

    @Test
    public void constructorTestFieldNumber(){
        Field field = new Field("Horsensgade", 2,5,1);
        int actual = 2;
        assertEquals(actual,field.getFieldNumber());
    }

    @Test
    public void constructorTestFielPrice(){
        Field field = new Field("Horsensgade", 2,5,1);
        int actual = 5;
        assertEquals(actual,field.getFieldPrice());
    }

    @Test
    public void constructorTestFielRent(){
        Field field = new Field("Horsensgade", 2,5,1);
        int actual = 1;
        assertEquals(actual,field.getFieldRent());
    }




}