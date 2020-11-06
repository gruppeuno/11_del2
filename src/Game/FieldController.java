package Game;

import Game.Fields.*;

public class FieldController {
    private Field[] fields = {
            new Start("START",0, "Du landede på Start"),
            new Property("BURGERBAREN", 1,1, "Du landede på burgerbaren"),
            new Property("PIZZARIAET", 2,1, "Du landede på pizzariaet"),
            new Property("SLIKBUTIKKEN", 3,1, "Du landede på slikbutikken"),
            new Parking("CHANCE", 4, "Du landede på chancen"),
            new Property("ISKIOSKEN", 5,1, "Du landede på iskiosken"),
            new JailVisit("PÅ FÆNGSELSBESØG", 6, "Du landede på fængsels besøg"),
            new Property("MUSEET", 7,2, "Du landede på museet"),
            new Property("BIBLIOTEKET", 8,2, "Du landede på bibioteket"),
            new Parking("CHANCE", 9, "Du landede på chancen"),
            new Property("SKATERPARKEN", 10,2, "Du landede på skaterparken"),
            new Property("SWIMMINGPOOLEN", 11,2, "Du landede på swimmingpoolen"),
            new Parking("Parkering", 12, "Du landede på parkering"),
            new Property("SPILLEHALLEN", 13,3, "Du landede på spillehallen"),
            new Property("BIOGRAFEN", 14,3, "Du landede på biografen"),
            new Parking("CHANCE", 15, "Du landede på chancen"),
            new Property("LEGETØJSBUTIKKEN", 16,3, "Du landede på legetøjsbutikken"),
            new Property("DYREHANDLEN", 17,3, "Du landede på dyrehandlen"),
            new Jail("GÅ I FÆNGSEL", 18, "Du landede på gå i fængsel"),
            new Property("BOWLINGHALLEN", 19,4, "Du landede på bowlingehallen"),
            new Property("ZOO", 20,4, "Du landede på zoo"),
            new Parking("CHANCE", 21, "Du landede på chancen"),
            new Property("VANDLANDET", 22,5, "Du landede på vandlandet"),
            new Property("STRANDPROMENADEN", 23,5, "Du landede på strandpromenaden")
    };


    //Når en spiller lander på et felt
    public void landOnField(Player player, PlayerController playerController){
        Field field = fields[player.getFieldNumber()];

        System.out.println(field.getMsg());

        if(field instanceof Property)
            landOnProperty(player, (Property) field, playerController);
        else if(field instanceof Jail)
            moveToPrison(player, playerController);
        }


    private void landOnProperty(Player player, Property property, PlayerController playerController) {
        if (property.getOwnedByPlayer())
            payRent(player,property, playerController);

            //feltet er ikke ejet, køb felt
        else if (!property.getOwnedByPlayer())
            buyProperty(player, property);
    }

    /** mangler referrance fra playerID */
    public void buyProperty(Player player, Property property){
        player.b.subBalance(property.getFieldPrice());
        property.setOwner(player.getPlayerName());
    }

    public void payRent(Player player ,Property property, PlayerController playerController) {
        player.b.subBalance(property.getFieldRent());
        Player propertyOwner = playerController.getPlayerByName(property.getOwnerName());
        propertyOwner.b.addBalance(property.getFieldRent());
    }

    private void moveToPrison(Player player, PlayerController playerController){
        player.setFieldNumber(6);
        player.b.subBalance(1);
    }

    public void passedStart(Player player){

    }


}
