package Game;

import Game.Fields.*;

public class FieldController {

    private Field[] fields = {
            new Start("START",0, "Du landede på Start"),
            new Property("BURGERBAREN", 1,1, "Du landede på burgerbaren","brown"),
            new Property("PIZZARIAET", 2,1, "Du landede på pizzariaet","brown"),
            new Parking("CHANCE", 3, "Du landede på chancen"),
            new Property("SLIKBUTIKKEN", 4,1, "Du landede på slikbutikken", "lightBlue"),
            new Property("ISKIOSKEN", 5,1, "Du landede på iskiosken", "lightBlue"),
            new JailVisit("PÅ FÆNGSELSBESØG", 6, "Du landede på fængsels besøg"),
            new Property("MUSEET", 7,2, "Du landede på museet","pink"),
            new Property("BIBLIOTEKET", 8,2, "Du landede på bibioteket","pink"),
            new Parking("CHANCE", 9, "Du landede på chancen"),
            new Property("SKATERPARKEN", 10,2, "Du landede på skaterparken","gold"),
            new Property("SWIMMINGPOOLEN", 11,2, "Du landede på swimmingpoolen","gold"),
            new Parking("Parkering", 12, "Du landede på parkering"),
            new Property("SPILLEHALLEN", 13,3, "Du landede på spillehallen","red"),
            new Property("BIOGRAFEN", 14,3, "Du landede på biografen","red"),
            new Parking("CHANCE", 15, "Du landede på chancen"),
            new Property("LEGETØJSBUTIKKEN", 16,3, "Du landede på legetøjsbutikken","yellow"),
            new Property("DYREHANDLEN", 17,3, "Du landede på dyrehandlen","yellow"),
            new Jail("GÅ I FÆNGSEL", 18, "Du landede på gå i fængsel"),
            new Property("BOWLINGHALLEN", 19,4, "Du landede på bowlingehallen","green"),
            new Property("ZOO", 20,4, "Du landede på zoo","green"),
            new Parking("CHANCE", 21, "Du landede på chancen"),
            new Property("VANDLANDET", 22,5, "Du landede på vandlandet","blue"),
            new Property("STRANDPROMENADEN", 23,5, "Du landede på strandpromenaden","blue")
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
        if (property.getOwnedByPlayer() && !property.getOwnerName().equals(player.getPlayerName()))
            payRent(player,property, playerController);

            //feltet er ikke ejet, køb felt
        else if (!property.getOwnedByPlayer())
            buyProperty(player, property);
    }

    /** mangler referrance fra playerID */
    public void buyProperty(Player player, Property property){
        player.b.subBalance(property.getFieldPrice());
        property.setOwner(player.getPlayerName());
        player.b.addPropertyValue(property.getFieldPrice());
        System.out.println(player.getPlayerName() + " købte " + property.getName() + " for " + property.getFieldPrice() + "M");
    }

    public void payRent(Player player ,Property property, PlayerController playerController) {
        player.b.subBalance(property.getFieldRent());
        Player propertyOwner = playerController.getPlayerByName(property.getOwnerName());
        propertyOwner.b.addBalance(property.getFieldRent());
        System.out.println(player.getPlayerName() + " betalte " + property.getFieldRent() + "M i husleje til " + propertyOwner.getPlayerName()
                + "\n" + propertyOwner.getPlayerName() + " har nu " + propertyOwner.b.getBalance() + "M");
    }

    private void moveToPrison(Player player, PlayerController playerController){
        player.setFieldNumber(6);
        player.b.subBalance(1);
    }

    //TODO: ikke færdigt, spørg hjælpelærer
    public boolean ownedBySamePlayer(Player player, Property property){
        String owner1 = property.getOwnerName();
        for (Field field:fields) {
            if (fields[player.getFieldNumber()] instanceof Property)
                if(((Property) fields[player.getFieldNumber()]).getOwnerName().equals(owner1))
                    return true;
        }
        return false;
        }

    public Field[] getFields() {
        return fields;
    }


}
