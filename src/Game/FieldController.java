package Game;

import Game.Fields.*;
import Game.Fields.Chance.Chance;
import Game.View.FieldMessages;

public class FieldController {

    FieldMessages fm = new FieldMessages();

    private Field[] fields = {
            new Start("START",0, fm.number(1)),
            new Property("BURGERBAREN", 1,1, fm.number(2),"brown"),
            new Property("PIZZARIAET", 2,1, fm.number(3),"brown"),
            new Chance("CHANCE", 3, fm.number(4)),
            new Property("SLIKBUTIKKEN", 4,1, fm.number(5), "lightBlue"),
            new Property("ISKIOSKEN", 5,1,fm.number(6), "lightBlue"),
            new JailVisit("PÅ FÆNGSELSBESØG", 6, fm.number(7)),
            new Property("MUSEET", 7,2, fm.number(8),"pink"),
            new Property("BIBLIOTEKET", 8,2,fm.number(9),"pink"),
            new Chance("CHANCE", 9, fm.number(10)),
            new Property("SKATERPARKEN", 10,2,fm.number(11),"gold"),
            new Property("SWIMMINGPOOLEN", 11,2,fm.number(12),"gold"),
            new Parking("Parkering", 12, fm.number(13)),
            new Property("SPILLEHALLEN", 13,3,fm.number(14),"red"),
            new Property("BIOGRAFEN", 14,3,fm.number(15),"red"),
            new Chance("CHANCE", 15,fm.number(16)),
            new Property("LEGETØJSBUTIKKEN", 16,3,fm.number(17),"yellow"),
            new Property("DYREHANDLEN", 17,3,fm.number(18),"yellow"),
            new Jail("GÅ I FÆNGSEL", 18,fm.number(19)),
            new Property("BOWLINGHALLEN", 19,4,fm.number(20),"green"),
            new Property("ZOO", 20,4, fm.number(21),"green"),
            new Chance("CHANCE", 21,fm.number(22)),
            new Property("VANDLANDET", 22,5,fm.number(23),"blue"),
            new Property("STRANDPROMENADEN", 23,5,fm.number(24),"blue")
    };

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
