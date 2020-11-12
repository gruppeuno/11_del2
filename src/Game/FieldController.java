package Game;

import Game.Fields.*;
import Game.Fields.Chance.Chance;

import java.util.ArrayList;
import java.util.Collections;

public class FieldController {

    private Field[] fields = {
            new Start("START",0, "Du landede på Start"),
            new Property("BURGERBAREN", 1,1, "Du landede på burgerbaren","brown"),
            new Property("PIZZARIAET", 2,1, "Du landede på pizzariaet","brown"),
            new Chance("CHANCE", 3, "Du landede på chancen"),
            new Property("SLIKBUTIKKEN", 4,1, "Du landede på slikbutikken", "lightBlue"),
            new Property("ISKIOSKEN", 5,1, "Du landede på iskiosken", "lightBlue"),
            new JailVisit("PÅ FÆNGSELSBESØG", 6, "Du landede på fængsels besøg"),
            new Property("MUSEET", 7,2, "Du landede på museet","pink"),
            new Property("BIBLIOTEKET", 8,2, "Du landede på biblioteket","pink"),
            new Chance("CHANCE", 9, "Du landede på chancen"),
            new Property("SKATERPARKEN", 10,2, "Du landede på skaterparken","gold"),
            new Property("SWIMMINGPOOLEN", 11,2, "Du landede på swimmingpoolen","gold"),
            new Parking("Parkering", 12, "Du landede på parkering"),
            new Property("SPILLEHALLEN", 13,3, "Du landede på spillehallen","red"),
            new Property("BIOGRAFEN", 14,3, "Du landede på biografen","red"),
            new Chance("CHANCE", 15, "Du landede på chancen"),
            new Property("LEGETØJSBUTIKKEN", 16,3, "Du landede på legetøjsbutikken","yellow"),
            new Property("DYREHANDLEN", 17,3, "Du landede på dyrehandlen","yellow"),
            new Jail("GÅ I FÆNGSEL", 18, "Du landede på gå i fængsel"),
            new Property("BOWLINGHALLEN", 19,4, "Du landede på bowlingehallen","green"),
            new Property("ZOO", 20,4, "Du landede på zoo","green"),
            new Chance("CHANCE", 21, "Du landede på chancen"),
            new Property("VANDLANDET", 22,5, "Du landede på vandlandet","blue"),
            new Property("STRANDPROMENADEN", 23,5, "Du landede på strandpromenaden","blue")
    };

    public void StartSequence(Player player) {
        Field field = fields[player.getFieldNumber()];
        field.RandomizeChance();
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
