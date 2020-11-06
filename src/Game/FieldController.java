package Game;

import Game.Fields.*;

public class FieldController {
    private Field[] fields = {
            new Start("START",0),
            new Property("BURGERBAREN", 1,1),
            new Property("PIZZARIAET", 2,1),
            new Property("SLIKBUTIKKEN", 3,1),
            new Parking("CHANCE", 4),
            new Property("ISKIOSKEN", 5,1),
            new JailVisit("PÅ FÆNGSELSBESØG", 6),
            new Property("MUSEET", 7,2),
            new Property("BIBLIOTEKET", 8,2),
            new Parking("CHANCE", 9),
            new Property("SKATERPARKEN", 10,2),
            new Property("SWIMMINGPOOLEN", 11,2),
            new Parking("Parkering", 12),
            new Property("SPILLEHALLEN", 13,3),
            new Property("BIOGRAFEN", 14,3),
            new Parking("CHANCE", 15),
            new Property("LEGETØJSBUTIKKEN", 16,3),
            new Property("DYREHANDLEN", 17,3),
            new Jail("GÅ I FÆNGSEL", 18),
            new Property("BOWLINGHALLEN", 19,4),
            new Property("ZOO", 20,4),
            new Parking("CHANCE", 21),
            new Property("VANDLANDET", 22,5),
            new Property("STRANDPROMENADEN", 23,5),
    };

    //Når en spiller lander på et felt
    public void landOnField(Player player, int fieldNumber, PlayerController playerController){
        Field field = fields[fieldNumber];
        if(field instanceof Property)
            landOnProperty(player, (Property) field, playerController);


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
        Player propertyOwner = playerController.getPlayer(property.getOwnerName());
        propertyOwner.b.addBalance(property.getFieldRent());
    }

    private void moveToPrison(Player player, Jail jail){
        //TODO: move playerID til fængsel
    }


}
