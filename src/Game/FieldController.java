package Game;

import Game.Fields.*;
import Game.Fields.ChanceCard;
import Game.View.FieldMessages;
import Game.View.FieldPropertyNames;

import java.text.FieldPosition;
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
    public void landOnField(Player player, PlayerController playerController, GUIView guiView){
    public void landOnField(Player player, PlayerController playerController, FieldController fieldController){
        isJustLeftJail(player);

        Field field = fields[player.getFieldNumber()];
        System.out.println(field.getMsg());

        if (field instanceof Property)
            landOnProperty(player,playerController,(Property) field, guiView);
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

    public void landOnProperty(Player player, PlayerController playerController, Property property, GUIView guiView) {
        if (property.getOwnedByPlayer() && !property.getOwnerName().equals(player.getPlayerName()))
            payRent(player, playerController, property, guiView);

            //feltet er ikke ejet, køb felt
        else if (!property.getOwnedByPlayer())
            buyProperty(player, playerController, property, guiView);
    }

    public void buyProperty(Player player, PlayerController playerController, Property property, GUIView guiView){
        if(player.b.getBalance()<property.getFieldPrice()){
            sellProperty(player,property.getFieldRent(),guiView, playerController, property);
        }

        //TODO slet if
        if(player.b.getBalance()>=property.getFieldPrice()){
            player.b.subBalance(property.getFieldPrice());
            property.setOwner(player.getPlayerName());
            player.addPropertyOwned(property);
            ownedBySamePlayer(playerController, property);
        }

        if(!player.bankAccount.getBankrupt()) {
            property.setOwner(player.getPlayerName());
            System.out.println("Du køber den for " + property.getFieldPrice() + "M");
        }
    }

    public void payRent(Player player , PlayerController playerController, Property property, GUIView guiView) {

        if(player.b.getBalance()<property.getFieldRent()){
            sellProperty(player,property.getFieldRent(),guiView, playerController, property);
        }
        //TODO slet if
        if(player.b.getBalance()>=property.getFieldRent()){
            player.b.subBalance(property.getFieldRent());
            playerController.getPlayerByName(property.getOwnerName()).b.addBalance(property.getFieldRent());
        }

        if(!player.b.getBankrupt()) {
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

    //TODO: metode til at fjerne property, spørg hjælpelærer, IKKE FÆRDIG
    public void sellProperty(Player player, int payment, GUIView guiView, PlayerController playerController, Property property){
        String[] propertiesAsStringArray = new String[player.getPropertiesOwned().size()];

        int missingPayment=payment-player.b.getBalance();

        if(player.getTotalPropertyValue()>missingPayment){

            do {
                for (int i = 0; i < player.getPropertiesOwned().size(); i++) {
                    propertiesAsStringArray[i]=((Property) player.getPropertiesOwned().toArray()[i]).toString();
                }

                String propertyToSell=guiView.getMyGUI().getUserSelection("Vælg grund du vil sælge, du skal sælge grunde for " + missingPayment + "M for at betale din afgift" , propertiesAsStringArray);
                for (int i = 0; i < player.getPropertiesOwned().size(); i++) {
                    if (propertyToSell.equals(propertiesAsStringArray[i])){

                        player.b.addBalance(player.getPropertiesOwned().get(i).getFieldPrice());
                        removePropertyOwner(player.getPropertiesOwned().get(i),player);

                        missingPayment=missingPayment-player.getPropertiesOwned().get(i).getFieldPrice();

                        player.getPropertiesOwned().remove(i);

                        String[] placeholder = new String[propertiesAsStringArray.length-1];

                        for (int j = 0; j < placeholder.length; j++) {
                            if(!propertyToSell.equals(player.getPropertiesOwned().get(j).toString())){
                                placeholder[j]=propertiesAsStringArray[j];
                            }
                            propertiesAsStringArray=placeholder;
                        }
                    }
                }
            } while (player.b.getBalance()<payment);
        }

        if(player.getPropertiesOwned().size()==0 && player.b.getBalance()==0)
            player.b.setBankrupt(true);
    }

    public void removePropertyOwner(Property property, Player player){
        ArrayList<Property> properties = player.getPropertiesOwned();

        for (Property tempProperty: properties) {
            if(tempProperty.getColour().equals(property.getColour()) && !tempProperty.getName().equals(property.getName())){
                tempProperty.removeDoubleRent();
                property.removeDoubleRent();
            }
        }
        property.removeOwner();

    }
}
