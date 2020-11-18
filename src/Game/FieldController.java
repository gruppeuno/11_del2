package Game;

import Game.Fields.*;
import Game.Fields.ChanceCard;
import Game.View.FieldMessages;
import Game.View.FieldPropertyNames;

import java.text.FieldPosition;
import java.util.ArrayList;

public class FieldController {

    FieldMessages fm = new FieldMessages();
    FieldPropertyNames fp = new FieldPropertyNames();

    final Field[] fields = {
            new Start(fp.number(1),0, fm.number(1)),
            new Property(fp.number(2), 1,1, fm.number(2),"brown"),
            new Property(fp.number(3), 2,1, fm.number(3),"brown"),
            new ChanceCard(fp.number(4), 3, fm.number(4)),
            new Property(fp.number(5), 4,1, fm.number(5), "lightBlue"),
            new Property(fp.number(6), 5,1,fm.number(6), "lightBlue"),
            new JailVisit(fp.number(7), 6, fm.number(7)),
            new Property(fp.number(8), 7,2, fm.number(8),"pink"),
            new Property(fp.number(9), 8,2,fm.number(9),"pink"),
            new ChanceCard(fp.number(10), 9, fm.number(10)),
            new Property(fp.number(11), 10,2, fm.number(11),"gold"),
            new Property(fp.number(12), 11,2,fm.number(12),"gold"),
            new Parking(fp.number(13), 12, fm.number(13)),
            new Property(fp.number(14), 13,3,fm.number(14),"red"),
            new Property(fp.number(15), 14,3,fm.number(15),"red"),
            new ChanceCard(fp.number(16), 15,fm.number(16)),
            new Property(fp.number(17), 16,3,fm.number(17),"yellow"),
            new Property(fp.number(18), 17,3,fm.number(18),"yellow"),
            new Jail(fp.number(19), 18,fm.number(19)),
            new Property(fp.number(20), 19,4,fm.number(20),"green"),
            new Property(fp.number(21), 20,4, fm.number(21),"green"),
            new ChanceCard(fp.number(22), 21,fm.number(22)),
            new Property(fp.number(23), 22,5,fm.number(23),"blue"),
            new Property(fp.number(24), 23,5,fm.number(24),"blue")
    };

    private final ChanceCardController chanceCardController = new ChanceCardController();

    //Når en spiller lander på et felt
    public void landOnField(Player player, PlayerController playerController, FieldController fieldController){
        isJustLeftJail(player);

        Field field = fields[player.getFieldNumber()];
        System.out.println(field.getMsg());

        if (field instanceof Property)
            landOnProperty(player,playerController,(Property) field);
        else if(field instanceof Jail)
            landOnJail(player);
        else if(field instanceof ChanceCard) {
            chanceCardController.chanceCard(player, playerController, fieldController);
        }
    }
//Todo: lav om så der ikke laves 2 metoder til at randomize chancekort. evt. bland kortene i chancecomtroller constructor
    //Af low coupling grunde..
    public void doRandomize() {
        System.out.println("Kortenes rækkefølge var: " + chanceCardController);
        chanceCardController.randomizeChance();
        System.out.println("Kortenes rækkefølge er nu: " + chanceCardController);
    }

    public void landOnProperty(Player player, PlayerController playerController, Property property) {
        if (property.getOwnedByPlayer() && !property.getOwnerName().equals(player.getPlayerName()))
            payRent(player, playerController, property);

            //feltet er ikke ejet, køb felt
        else if (!property.getOwnedByPlayer())
            buyProperty(player, playerController, property);
    }

    public void buyProperty(Player player, PlayerController playerController, Property property){
        if(player.bankAccount.getBalance()>=property.getFieldPrice()){
            player.bankAccount.subBalance(property.getFieldPrice());
            property.setOwner(player.getPlayerName());
            player.addPropertyOwned(property);
            ownedBySamePlayer(playerController, property);
        }
        else if(player.bankAccount.getBalance()<=property.getFieldPrice()){
            player.bankAccount.setBankrupt(true);
        }

        if(!player.bankAccount.getBankrupt()) {
            property.setOwner(player.getPlayerName());
            System.out.println("Du køber den for " + property.getFieldPrice() + "M");
        }
    }

    public void payRent(Player player , PlayerController playerController, Property property) {
        if(player.bankAccount.getBalance()>=property.getFieldRent()){
            player.bankAccount.subBalance(property.getFieldRent());
            playerController.getPlayerByName(property.getOwnerName()).bankAccount.addBalance(property.getFieldRent());
        }
        else if(player.bankAccount.getBalance()<=property.getFieldRent()){
            player.bankAccount.setBankrupt(true);
        }
        if(!player.bankAccount.getBankrupt()) {
            Player propertyOwner = playerController.getPlayerByName(property.getOwnerName());
            System.out.println(player.getPlayerName() + " betalte " + property.getFieldRent() + "M i husleje til " + propertyOwner.getPlayerName()
                    + "\n" + propertyOwner.getPlayerName() + " har nu " + propertyOwner.bankAccount.getBalance() + "M");
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
    //TODO: PlayerController og Jail bliver ikke brugt her
    public void landOnJail(Player player) {
        player.putInJail();
        player.setFieldNumber(6);
        if (player.getJailCard() == true){
            player.jailCardFree();
            player.setJailCard(false);
            ChanceCardController.setJailCardUse(false);
        }
    }

     public void freeProperty(Player player, PlayerController playerController){
         int i = player.getFieldNumber();
         Property property = (Property) fields[i];
         if (property.getOwnedByPlayer() && !property.getOwnerName().equals(player.getPlayerName())) {
             payRent(player, playerController, property);}
         else if (!property.getOwnedByPlayer()) {
             if (!player.bankAccount.getBankrupt()) {
                 property.setOwner(player.getPlayerName());
                 player.addPropertyOwned(property);
                 System.out.println(player.getPlayerName() + " fik " + property.getName() + " helt gratis");
             }
         }
     }
     public void chanceCardBuyProperty(Player player, PlayerController playerController) {
         Property property = getProperty(player);

         ArrayList<Property> properties = playerController.getPlayerByName(property.getOwnerName()).getPropertiesOwned();
         int propertyOccupation = 0;
         for (Property tempProperty: properties) {
             if (tempProperty.getOwnedByPlayer()) {
                 propertyOccupation++;
             }
         }
         if (propertyOccupation == 16) {
             if (!property.getOwnerName().equals(player.getPlayerName())) {

                 for (Player tempPlayer : playerController.getPlayerArray()) {

                     if (tempPlayer.equals(property.getOwnerName())) {
                         tempPlayer.bankAccount.addBalance(property.getFieldPrice());
                     }
                 }
                 property.setOwner(player.getPlayerName());
                 player.bankAccount.subBalance(property.getFieldPrice());
             }
         }
         else {
             buyProperty(player, playerController, property);
         }
     }

     public Property getProperty(Player player) {
         int i = player.getFieldNumber();
         Property property = (Property) fields[i];

         return property;
     }
}
