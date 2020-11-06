package Game.Fields;

import Game.Player;

abstract public class Field {
    protected String name;
    protected int fieldNumber;

    public Field(String name, int fieldNumber){
        this.name=name;
        this.fieldNumber=fieldNumber;
    }

}
