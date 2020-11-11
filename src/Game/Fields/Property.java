package Game.Fields;

import Game.Player;
import Game.PlayerController;

/**
 * Field
 * @author Gruppe11
 */
public class Property extends Field {

    private int fieldPrice;
    private int fieldRent;
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

    @Override
    public void fieldAction(Player player, PlayerController playerController) {
        if (getOwnedByPlayer() && !getOwnerName().equals(player.getPlayerName()))
            payRent(player, playerController);

            //feltet er ikke ejet, køb felt
        else if (!getOwnedByPlayer())
            buyProperty(player);
    }

    public void buyProperty(Player player){
        if(!player.b.getBankrupt()) {
            //todo: kald check bankrupt
            player.b.subBalance(fieldPrice);
            setOwner(player.getPlayerName());
            System.out.println(player.getPlayerName() + " købte " + getName() + " for " + fieldPrice + "M");

        }
    }

    public void payRent(Player player , PlayerController playerController) {
        //todo: kald check bankrupt
        player.b.subBalance(fieldRent);
        if(!player.b.getBankrupt()) {
            Player propertyOwner = playerController.getPlayerByName(getOwnerName());
            propertyOwner.b.addBalance(fieldRent);
            System.out.println(player.getPlayerName() + " betalte " + fieldRent + "M i husleje til " + propertyOwner.getPlayerName()
                    + "\n" + propertyOwner.getPlayerName() + " har nu " + propertyOwner.b.getBalance() + "M");
        }
    }


}
