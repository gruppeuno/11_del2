package Game;

import Game.Fields.*;
import Game.Fields.ChanceCard;
import Game.View.FieldMessages;
import Game.View.FieldPropertyNames;
import Game.View.FieldControllerMessages;

import java.util.ArrayList;

public class FieldController {
    FieldControllerMessages fieldcontrollerMessages = new FieldControllerMessages();

    FieldMessages fm = new FieldMessages();

    private int propertyTakenCounter = 0;

    public final Field[] fields = {
            new Start(FieldPropertyNames.instanceOf().number(1),0, fm.number(1)),
            new Property(FieldPropertyNames.instanceOf().number(2), 1, 1, fm.number(2), "brown"),
            new Property(FieldPropertyNames.instanceOf().number(3), 2, 1, fm.number(3), "brown"),
            new ChanceCard(FieldPropertyNames.instanceOf().number(4), 3, fm.number(4)),
            new Property(FieldPropertyNames.instanceOf().number(5), 4, 1, fm.number(5), "lightBlue"),
            new Property(FieldPropertyNames.instanceOf().number(6), 5, 1, fm.number(6), "lightBlue"),
            new JailVisit(FieldPropertyNames.instanceOf().number(7), 6, fm.number(7)),
            new Property(FieldPropertyNames.instanceOf().number(8), 7, 2, fm.number(8), "pink"),
            new Property(FieldPropertyNames.instanceOf().number(9), 8, 2, fm.number(9), "pink"),
            new ChanceCard(FieldPropertyNames.instanceOf().number(10), 9, fm.number(10)),
            new Property(FieldPropertyNames.instanceOf().number(11), 10, 2, fm.number(11), "gold"),
            new Property(FieldPropertyNames.instanceOf().number(12), 11, 2, fm.number(12), "gold"),
            new Parking(FieldPropertyNames.instanceOf().number(13), 12, fm.number(13)),
            new Property(FieldPropertyNames.instanceOf().number(14), 13, 3, fm.number(14), "red"),
            new Property(FieldPropertyNames.instanceOf().number(15), 14, 3, fm.number(15), "red"),
            new ChanceCard(FieldPropertyNames.instanceOf().number(16), 15, fm.number(16)),
            new Property(FieldPropertyNames.instanceOf().number(17), 16, 3, fm.number(17), "yellow"),
            new Property(FieldPropertyNames.instanceOf().number(18), 17, 3, fm.number(18), "yellow"),
            new Jail(FieldPropertyNames.instanceOf().number(19), 18, fm.number(19)),
            new Property(FieldPropertyNames.instanceOf().number(20), 19, 4, fm.number(20), "green"),
            new Property(FieldPropertyNames.instanceOf().number(21), 20, 4, fm.number(21), "green"),
            new ChanceCard(FieldPropertyNames.instanceOf().number(22), 21, fm.number(22)),
            new Property(FieldPropertyNames.instanceOf().number(23), 22, 5, fm.number(23), "blue"),
            new Property(FieldPropertyNames.instanceOf().number(24), 23, 5, fm.number(24), "blue")
    };

    private final ChanceCardController chanceCardController = new ChanceCardController();

    //Når en spiller lander på et felt

    public void landOnField(Player player, PlayerController playerController, FieldController fieldController, GUIView guiView) {
        isJustLeftJail(player);

        chanceCardController.selectMoveProperty(player, playerController, fieldController, guiView);

        Field field = fields[player.getFieldNumber()];
        System.out.println(field.getMsg());

        if (field instanceof Property)
            landOnProperty(player, playerController, (Property) field, guiView);
        else if (field instanceof Jail)
            landOnJail(player);
        else if (field instanceof ChanceCard) {
            chanceCardController.chanceCard(player, playerController, this, guiView);
        }
    }

    //Todo: lav om så der ikke laves 2 metoder til at randomize chancekort. evt. bland kortene i chancecomtroller constructor
    //Af low coupling grunde..
    public void doRandomize() {
        System.out.println(fieldcontrollerMessages.number(1) + chanceCardController);
        chanceCardController.randomizeChance();
        System.out.println(fieldcontrollerMessages.number(2) + chanceCardController);
    }

    public void landOnProperty(Player player, PlayerController playerController, Property property, GUIView guiView) {
        if (property.getOwnedByPlayer() && !property.getOwnerName().equals(player.getPlayerName()))
            payRent(player, playerController, property, guiView);

            //feltet er ikke ejet, køb felt
        else if (!property.getOwnedByPlayer())
            buyProperty(player, playerController, guiView);
    }

    public void buyProperty(Player player, PlayerController playerController, GUIView guiView) {
        Property property = getPropertyInstance(player);

        int playerBalance = player.getBankAccount().getBalance();
        int fieldPrice = property.getFieldPrice();

        if (playerBalance < fieldPrice) {
            sellProperty(player, fieldPrice, guiView, playerController, property);
        }

            player.getBankAccount().subBalance(fieldPrice);
            property.setOwner(player.getPlayerName());
            player.addPropertyOwned(property);
            propertyTakenCounter++;
            ownedBySamePlayer(playerController, property);

        if (!player.getBankAccount().getBankrupt()) {
            property.setOwner(player.getPlayerName());
            System.out.println(fieldcontrollerMessages.number(3) + " " + fieldPrice + fieldcontrollerMessages.number(4));
        }
    }

    public void payRent(Player player, PlayerController playerController, Property property, GUIView guiView) {
        int playerBalance = player.getBankAccount().getBalance();
        int fieldRent = property.getFieldRent();
        Player propertyOwner = playerController.getPlayerByName(property.getOwnerName());

        if (playerBalance < fieldRent) {
            sellProperty(player, fieldRent, guiView, playerController, property);
        }

            player.getBankAccount().subBalance(fieldRent);
            propertyOwner.getBankAccount().addBalance(fieldRent);

        if (!player.getBankAccount().getBankrupt()) {
            System.out.println(player.getPlayerName() + " " + fieldcontrollerMessages.number(5) + " " + fieldRent + fieldcontrollerMessages.number(6) + " " + propertyOwner.getPlayerName()
                    + "\n" + propertyOwner.getPlayerName() + " " + fieldcontrollerMessages.number(7) + " " + propertyOwner.getBankAccount().getBalance());
        }
    }

    public void ownedBySamePlayer(PlayerController playerController, Property property) {
        ArrayList<Property> properties = playerController.getPlayerByName(property.getOwnerName()).getPropertiesOwned();
        for (Property property1 : properties) {
            if (property1.getColour().equals(property.getColour()) && !property1.getName().equals(property.getName())) {
                property1.setDoubleRent();
                property.setDoubleRent();
            }
        }
    }
    public boolean getCheckIfProperty (Player player) {
        Field field = fields[player.getFieldNumber()];
        if (field instanceof Property) {
            return true;
        }
        return false;
    }

    public Field[] getFields() {
        return fields;
    }

    public void isJustLeftJail(Player player) {
        if (player.getIsInPrison() == true) {
            player.freeOfJail();

        }
    }
    //TODO: PlayerController og Jail bliver ikke brugt her
    public void landOnJail(Player player) {
        player.putInJail();
        player.setFieldNumber(6);
        if (player.getJailCard() == true) {
            player.jailCardFree();
            player.setJailCard(false);
            ChanceCardController.setJailCardUse(false);
        }
    }

     public void freeProperty(Player player, PlayerController playerController, GUIView guiView){
         Property property = getPropertyInstance(player);
         if (property.getOwnedByPlayer() && !property.getOwnerName().equals(player.getPlayerName())) {
             payRent(player, playerController, property, guiView);}
         else if (!(property.getOwnerName() == null) && property.getOwnerName().equals(player.getPlayerName())) {
             System.out.println(fieldcontrollerMessages.number(8) +" "+ fieldcontrollerMessages.number(9));
         }
         else if (!property.getOwnedByPlayer()) {
             if (!player.getBankAccount().getBankrupt()) {
                 property.setOwner(player.getPlayerName());
                 player.addPropertyOwned(property);
                 propertyTakenCounter++;
                 System.out.println(player.getPlayerName() + " " + fieldcontrollerMessages.number(10) + " " + property.getName() + " " + fieldcontrollerMessages.number(11));
             }
         }
     }

     public int getPropertyTaken() {
        return propertyTakenCounter;
     }

     public void chanceCardBuyProperty(Player player, PlayerController playerController, GUIView guiView) {
         Property property = getPropertyInstance(player);

         if (getPropertyTaken() >= 16) {

                 for (Player tempPlayer : playerController.getPlayerArray()) {

                     if (tempPlayer.getPlayerName().equals(property.getOwnerName())) {
                         tempPlayer.getBankAccount().addBalance(property.getFieldPrice());
                     }
                 }
                 System.out.println(fieldcontrollerMessages.number(12) + property.getName() + fieldcontrollerMessages.number(13) + property.getOwnerName() +fieldcontrollerMessages.number(14)  + property.getFieldPrice() + fieldcontrollerMessages.number(15));
                 property.setOwner(player.getPlayerName());
                 player.getBankAccount().subBalance(property.getFieldPrice());

         }
         else if (!property.getOwnedByPlayer()) {
             buyProperty(player, playerController, guiView);
         }
     }

    public void checkOwnership (Player player, PlayerController playerController, FieldController fieldController, GUIView guiView) {

        Property property = getPropertyInstance(player);

        if (property.getOwnerName() == null) {chanceCardController.chooseProperty(player, playerController, fieldController, guiView);}
        else if (property.getOwnerName().equals(player.getPlayerName())) {
            System.out.println("Du skal vælge en grund du ikke selv ejer");
            player.setFieldNumber(chanceCardController.getTempMove());
            chanceCardController.selectMoveProperty(player, playerController, fieldController, guiView);
        }
        else {chanceCardController.chooseProperty(player, playerController, fieldController, guiView);}
    }

     public Property getPropertyInstance(Player player) {
         int i = player.getFieldNumber();
         Property property = (Property) fields[i];

         return property;
     }
    //TODO: metode til at fjerne property, spørg hjælpelærer, IKKE FÆRDIG
    public void sellProperty(Player player, int payment, GUIView guiView, PlayerController playerController, Property property) {
        String[] propertiesAsStringArray = new String[player.getPropertiesOwned().size()];

        int missingPayment = payment - player.getBankAccount().getBalance();

        if (player.getTotalPropertyValue() > missingPayment) {
            do {
                for (int i = 0; i < player.getPropertiesOwned().size(); i++) {
                    propertiesAsStringArray[i] = ((Property) player.getPropertiesOwned().toArray()[i]).toString();
                }

                String propertyToSell = guiView.getMyGUI().getUserSelection(fieldcontrollerMessages.number(16) + missingPayment + fieldcontrollerMessages.number(17), propertiesAsStringArray);
                for (int i = 0; i < player.getPropertiesOwned().size(); i++) {

                    if (propertyToSell.equals(propertiesAsStringArray[i])) {
                        player.getBankAccount().addBalance(player.getPropertiesOwned().get(i).getFieldPrice());
                        removePropertyOwner(player.getPropertiesOwned().get(i), player);
                        missingPayment = missingPayment - player.getPropertiesOwned().get(i).getFieldPrice();
                        player.getPropertiesOwned().remove(i);
                        String[] placeholder = new String[propertiesAsStringArray.length - 1];

                        for (int j = 0; j < placeholder.length; j++) {
                            if (!propertyToSell.equals(player.getPropertiesOwned().get(j).toString())) {
                                placeholder[j] = propertiesAsStringArray[j];
                            }
                            propertiesAsStringArray = placeholder;
                        }
                    }
                }
            } while (player.getBankAccount().getBalance() < payment);
        }
        if (player.getPropertiesOwned().size() == 0 && player.getBankAccount().getBalance() == 0)
            player.getBankAccount().setBankrupt(true);
    }

    public void removePropertyOwner(Property property, Player player) {
        ArrayList<Property> properties = player.getPropertiesOwned();

        for (Property tempProperty : properties) {
            if (tempProperty.getColour().equals(property.getColour()) && !tempProperty.getName().equals(property.getName())) {
                tempProperty.removeDoubleRent();
                property.removeDoubleRent();
            }
        }
        property.removeOwner();

    }
}
