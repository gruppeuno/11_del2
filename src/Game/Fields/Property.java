package Game.Fields;

import Game.Player;
import Game.PlayerController;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Field
 * @author Gruppe11
 */
public class Property extends Field {

    private int fieldPrice;
    private int  fieldRent;
    private String ownerName;
    private boolean ownedByPlayer = false;
    private String colour;

    public Property(String name, int fieldNumber, int fieldPrice, String msg, String colour){
        super(name,fieldNumber, msg);
        this.fieldPrice=fieldPrice;
        fieldRent=fieldPrice;
        this.colour=colour;
    }

    public String getOwnerName() { return ownerName; }
    public void setOwner(String playerName) { this.ownerName =playerName; this.ownedByPlayer=true; }
    public boolean getOwnedByPlayer() { return ownedByPlayer; }
    public int getFieldPrice(){ return fieldPrice;} // til test
    public int getFieldRent(){ return fieldRent;} // til test
    public String getColour() { return colour; }
    public void setDoubleRent(){ fieldRent = fieldRent*2;}
    public void removeDoubleRent(){ fieldRent = fieldRent/2;}

    @Override
    public void fieldAction(Player player, PlayerController playerController) {
        if (getOwnedByPlayer() && !getOwnerName().equals(player.getPlayerName()))
            payRent(player, playerController);

            //feltet er ikke ejet, køb felt
        else if (!getOwnedByPlayer())
            buyProperty(player, playerController);
    }

    public void buyProperty(Player player, PlayerController playerController){
        if(player.b.getBalance()>=fieldPrice){
            player.b.subBalance(fieldPrice);
            setOwner(player.getPlayerName());
            player.addPropertyOwned(this);
            ownedBySamePlayer(playerController);
        }
        else if(player.b.getBalance()<=fieldPrice){
            player.b.setBankrupt(true);
        }

        if(!player.b.getBankrupt()) {
            setOwner(player.getPlayerName());
            System.out.println(player.getPlayerName() + " købte " + getName() + " for " + fieldPrice + "M");
        }
    }

    public void payRent(Player player , PlayerController playerController) {
        if(player.b.getBalance()>=fieldRent){
            player.b.subBalance(fieldRent);
            playerController.getPlayerByName(ownerName).b.addBalance(fieldRent);
        }
        else if(player.b.getBalance()<=fieldRent){
            player.b.setBankrupt(true);
        }
        if(!player.b.getBankrupt()) {
            Player propertyOwner = playerController.getPlayerByName(getOwnerName());
            System.out.println(player.getPlayerName() + " betalte " + fieldRent + "M i husleje til " + propertyOwner.getPlayerName()
                    + "\n" + propertyOwner.getPlayerName() + " har nu " + propertyOwner.b.getBalance() + "M");
        }
    }

    public void ownedBySamePlayer(PlayerController playerController){
        ArrayList<Property> properties = playerController.getPlayerByName(getOwnerName()).getPropertiesOwned();
        for (Property property: properties) {
            if(property.getColour().equals(colour) && !property.getName().equals(name)){
                property.setDoubleRent();
                setDoubleRent();
            }
        }

    }

    private void FreeProperty(Player player, PlayerController playerController){
        if (getOwnedByPlayer()) {payRent(player, playerController);}
        else {
            if (!player.b.getBankrupt()) {
                setOwner(player.getPlayerName());
                System.out.println(player.getPlayerName() + " fik " + getName() + " for " + getFieldPrice() + "M"); }}
    }


}
