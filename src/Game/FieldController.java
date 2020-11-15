package Game;

import Game.Fields.*;

import java.util.ArrayList;

public class FieldController {

    private final Field[] fields = {
            new Start("START",0, "landede på Start"),
            new Property("BURGERBAREN", 1,1, "landede på burgerbaren","brown"),
            new Property("PIZZARIAET", 2,1, "landede på pizzariaet","brown"),
            new ChanceCard("CHANCE", 3, "landede på chancen"),
            new Property("SLIKBUTIKKEN", 4,1, "landede på slikbutikken", "lightBlue"),
            new Property("ISKIOSKEN", 5,1, "landede på iskiosken", "lightBlue"),
            new JailVisit("PÅ FÆNGSELSBESØG", 6, "landede på fængsels besøg"),
            new Property("MUSEET", 7,2, "landede på museet","pink"),
            new Property("BIBLIOTEKET", 8,2, "landede på biblioteket","pink"),
            new ChanceCard("CHANCE", 9, "landede på chancen"),
            new Property("SKATERPARKEN", 10,2, "landede på skaterparken","gold"),
            new Property("SWIMMINGPOOLEN", 11,2, "landede på swimmingpoolen","gold"),
            new Parking("Parkering", 12, "landede på parkering"),
            new Property("SPILLEHALLEN", 13,3, "landede på spillehallen","red"),
            new Property("BIOGRAFEN", 14,3, "landede på biografen","red"),
            new ChanceCard("CHANCE", 15, "landede på chancen"),
            new Property("LEGETØJSBUTIKKEN", 16,3, "landede på legetøjsbutikken","yellow"),
            new Property("DYREHANDLEN", 17,3, "landede på dyrehandlen","yellow"),
            new Jail("GÅ I FÆNGSEL", 18, "landede på gå i fængsel"),
            new Property("BOWLINGHALLEN", 19,4, "landede på bowlingehallen","green"),
            new Property("ZOO", 20,4, "landede på zoo","green"),
            new ChanceCard("CHANCE", 21, "landede på chancen"),
            new Property("VANDLANDET", 22,5, "landede på vandlandet","blue"),
            new Property("STRANDPROMENADEN", 23,5, "landede på strandpromenaden","blue")
    };

    private final ChanceCardController chanceCardController = new ChanceCardController();

    //Når en spiller lander på et felt
    public void landOnField(Player player, PlayerController playerController){
        isJustLeftJail(player);

        Field field = fields[player.getFieldNumber()];
        System.out.println(field.getMsg());

        if (field instanceof Property)
            landOnProperty(player,playerController,(Property) field);
        else if(field instanceof Jail)
            landOnJail(player,playerController,(Jail) field);
        else if(field instanceof ChanceCard) {
            chanceCardController.chanceCard(player, playerController);
        }
    }

    //Af low coupling grunde..
    public void doRandomize() {chanceCardController.randomizeChance();}

    public void landOnProperty(Player player, PlayerController playerController, Property property) {
        if (property.getOwnedByPlayer() && !property.getOwnerName().equals(player.getPlayerName()))
            payRent(player, playerController, property);

            //feltet er ikke ejet, køb felt
        else if (!property.getOwnedByPlayer())
            buyProperty(player, playerController, property);
    }

    public void buyProperty(Player player, PlayerController playerController, Property property){
        if(player.b.getBalance()>=property.getFieldPrice()){
            player.b.subBalance(property.getFieldPrice());
            property.setOwner(player.getPlayerName());
            player.addPropertyOwned(property);
            ownedBySamePlayer(playerController, property);
        }
        else if(player.b.getBalance()<=property.getFieldPrice()){
            player.b.setBankrupt(true);
        }

        if(!player.b.getBankrupt()) {
            property.setOwner(player.getPlayerName());
            System.out.println(player.getPlayerName() + " købte " + property.getName() + " for " + property.getFieldPrice() + "M");
        }
    }

    public void payRent(Player player , PlayerController playerController, Property property) {
        if(player.b.getBalance()>=property.getFieldRent()){
            player.b.subBalance(property.getFieldRent());
            playerController.getPlayerByName(property.getOwnerName()).b.addBalance(property.getFieldRent());
        }
        else if(player.b.getBalance()<=property.getFieldRent()){
            player.b.setBankrupt(true);
        }
        if(!player.b.getBankrupt()) {
            Player propertyOwner = playerController.getPlayerByName(property.getOwnerName());
            System.out.println(player.getPlayerName() + " betalte " + property.getFieldRent() + "M i husleje til " + propertyOwner.getPlayerName()
                    + "\n" + propertyOwner.getPlayerName() + " har nu " + propertyOwner.b.getBalance() + "M");
        }
    }

    public void ownedBySamePlayer(PlayerController playerController, Property property){
        ArrayList<Property> properties = playerController.getPlayerByName(property.getOwnerName()).getPropertiesOwned();
        for (Property property1: properties) {
            if(property1.getColour().equals(property.getColour()) && !property1.getName().equals(property.getName())){
                property1.setDoubleRent();
                property.setDoubleRent();
            }
        }
    }

    public Field[] getFields() {
        return fields;
    }

    public void isJustLeftJail(Player player){
        if(player.getIsInPrison() == true){
            player.freeOfJail();
        }
    }

    public void landOnJail(Player player, PlayerController playerController, Jail jail) {
        player.putInJail();
        player.setFieldNumber(6);
        if (player.getJailCard() == true){
            player.JailCardFree();
            player.setJailCard(false);
            ChanceCardController.setJailCardUse(false);
        }

    }

     public void FreeProperty(Player player, PlayerController playerController){
         int i = player.getFieldNumber();
         Property property = (Property) fields[i];
         if (property.getOwnedByPlayer()) {payRent(player, playerController, property);}
         else {
             if (!player.b.getBankrupt()) {
                 property.setOwner(player.getPlayerName());
                 player.addPropertyOwned(property);
                 System.out.println(player.getPlayerName() + " fik " + property.getName() + " for free"); }}
     }
}
