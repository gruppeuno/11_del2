package Game.Fields;

import Game.Player;
import Game.PlayerController;

abstract public class Field {
    protected String name;
    protected int fieldNumber;
    protected String msg;

    public Field(String name, int fieldNumber, String msg){
        this.name=name;
        this.fieldNumber=fieldNumber;
        this.msg=msg;
    }

    public void fieldAction(Player player, PlayerController playerController) {}

    public String getMsg(){
        return msg;
    }
    public String getName(){return name;}
    public int getFieldNumber(){return fieldNumber;}

}
