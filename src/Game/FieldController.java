package Game;

import Game.Fields.*;
import Game.Fields.ChanceCard;
import Game.View.FieldMessages;
import Game.View.FieldPropertyNames;
import java.util.ArrayList;

public class FieldController {

    final Field[] fields = {
            new Start(FieldPropertyNames.instanceOf().number(1),0, FieldMessages.instanceOf().number(1)),
            new Property(FieldPropertyNames.instanceOf().number(2), 1,1, FieldMessages.instanceOf().number(2),"brown"),
            new Property(FieldPropertyNames.instanceOf().number(3), 2,1, FieldMessages.instanceOf().number(3),"brown"),
            new ChanceCard(FieldPropertyNames.instanceOf().number(4), 3, FieldMessages.instanceOf().number(4)),
            new Property(FieldPropertyNames.instanceOf().number(5), 4,1, FieldMessages.instanceOf().number(5), "lightBlue"),
            new Property(FieldPropertyNames.instanceOf().number(6), 5,1,FieldMessages.instanceOf().number(6), "lightBlue"),
            new JailVisit(FieldPropertyNames.instanceOf().number(7), 6, FieldMessages.instanceOf().number(7)),
            new Property(FieldPropertyNames.instanceOf().number(8), 7,2, FieldMessages.instanceOf().number(8),"pink"),
            new Property(FieldPropertyNames.instanceOf().number(9), 8,2,FieldMessages.instanceOf().number(9),"pink"),
            new ChanceCard(FieldPropertyNames.instanceOf().number(10), 9, FieldMessages.instanceOf().number(10)),
            new Property(FieldPropertyNames.instanceOf().number(11), 10,2,FieldMessages.instanceOf().number(11),"gold"),
            new Property(FieldPropertyNames.instanceOf().number(12), 11,2,FieldMessages.instanceOf().number(12),"gold"),
            new Parking(FieldPropertyNames.instanceOf().number(13), 12, FieldMessages.instanceOf().number(13)),
            new Property(FieldPropertyNames.instanceOf().number(14), 13,3,FieldMessages.instanceOf().number(14),"red"),
            new Property(FieldPropertyNames.instanceOf().number(15), 14,3,FieldMessages.instanceOf().number(15),"red"),
            new ChanceCard(FieldPropertyNames.instanceOf().number(16), 15,FieldMessages.instanceOf().number(16)),
            new Property(FieldPropertyNames.instanceOf().number(17), 16,3,FieldMessages.instanceOf().number(17),"yellow"),
            new Property(FieldPropertyNames.instanceOf().number(18), 17,3,FieldMessages.instanceOf().number(18),"yellow"),
            new Jail(FieldPropertyNames.instanceOf().number(19), 18,FieldMessages.instanceOf().number(19)),
            new Property(FieldPropertyNames.instanceOf().number(20), 19,4,FieldMessages.instanceOf().number(20),"green"),
            new Property(FieldPropertyNames.instanceOf().number(21), 20,4, FieldMessages.instanceOf().number(21),"green"),
            new ChanceCard(FieldPropertyNames.instanceOf().number(22), 21,FieldMessages.instanceOf().number(22)),
            new Property(FieldPropertyNames.instanceOf().number(23), 22,5,FieldMessages.instanceOf().number(23),"blue"),
            new Property(FieldPropertyNames.instanceOf().number(24), 23,5,FieldMessages.instanceOf().number(24),"blue")
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
            player.jailCardFree();
            player.setJailCard(false);
            ChanceCardController.setJailCardUse(false);
        }

    }

     public void FreeProperty(Player player, PlayerController playerController){
        //TODO: Det her skal laves om, så den tager den rigtige instans af property.
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
