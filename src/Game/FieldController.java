package Game;

import Game.Fields.*;
import Game.Fields.Chance.Chance;
import Game.View.FieldMessages;
import Game.View.FieldPropertyNames;

import java.io.IOException;

public class FieldController {

    private Field[] fields = {
            new Start(FieldPropertyNames.instanceOf().number(1),0, FieldMessages.instanceOf().number(1)),
            new Property(FieldPropertyNames.instanceOf().number(2), 1,1, FieldMessages.instanceOf().number(2),"brown"),
            new Property(FieldPropertyNames.instanceOf().number(3), 2,1, FieldMessages.instanceOf().number(3),"brown"),
            new Chance(FieldPropertyNames.instanceOf().number(4), 3, FieldMessages.instanceOf().number(4)),
            new Property(FieldPropertyNames.instanceOf().number(5), 4,1, FieldMessages.instanceOf().number(5), "lightBlue"),
            new Property(FieldPropertyNames.instanceOf().number(6), 5,1,FieldMessages.instanceOf().number(6), "lightBlue"),
            new JailVisit(FieldPropertyNames.instanceOf().number(7), 6, FieldMessages.instanceOf().number(7)),
            new Property(FieldPropertyNames.instanceOf().number(8), 7,2, FieldMessages.instanceOf().number(8),"pink"),
            new Property(FieldPropertyNames.instanceOf().number(9), 8,2,FieldMessages.instanceOf().number(9),"pink"),
            new Chance(FieldPropertyNames.instanceOf().number(10), 9, FieldMessages.instanceOf().number(10)),
            new Property(FieldPropertyNames.instanceOf().number(11), 10,2,FieldMessages.instanceOf().number(11),"gold"),
            new Property(FieldPropertyNames.instanceOf().number(12), 11,2,FieldMessages.instanceOf().number(12),"gold"),
            new Parking(FieldPropertyNames.instanceOf().number(13), 12, FieldMessages.instanceOf().number(13)),
            new Property(FieldPropertyNames.instanceOf().number(14), 13,3,FieldMessages.instanceOf().number(14),"red"),
            new Property(FieldPropertyNames.instanceOf().number(15), 14,3,FieldMessages.instanceOf().number(15),"red"),
            new Chance(FieldPropertyNames.instanceOf().number(16), 15,FieldMessages.instanceOf().number(16)),
            new Property(FieldPropertyNames.instanceOf().number(17), 16,3,FieldMessages.instanceOf().number(17),"yellow"),
            new Property(FieldPropertyNames.instanceOf().number(18), 17,3,FieldMessages.instanceOf().number(18),"yellow"),
            new Jail(FieldPropertyNames.instanceOf().number(19), 18,FieldMessages.instanceOf().number(19)),
            new Property(FieldPropertyNames.instanceOf().number(20), 19,4,FieldMessages.instanceOf().number(20),"green"),
            new Property(FieldPropertyNames.instanceOf().number(21), 20,4, FieldMessages.instanceOf().number(21),"green"),
            new Chance(FieldPropertyNames.instanceOf().number(22), 21,FieldMessages.instanceOf().number(22)),
            new Property(FieldPropertyNames.instanceOf().number(23), 22,5,FieldMessages.instanceOf().number(23),"blue"),
            new Property(FieldPropertyNames.instanceOf().number(24), 23,5,FieldMessages.instanceOf().number(24),"blue")
    };

    public FieldController() {
    }

    public void StartSequence() {
        Field field = fields[1];
        field.randomizeChance();
    }


    //Når en spiller lander på et felt
    public void landOnField(Player player, PlayerController playerController){
        isJustLeftJail(player);

        Field field = fields[player.getFieldNumber()];
        System.out.println(field.getMsg());

       field.fieldAction(player, playerController);
    }



    public Field[] getFields() {
        return fields;
    }

    public void isJustLeftJail(Player player){
        if(player.getIsInPrison() == true){
            player.freeOfJail();
        }
    }

}
