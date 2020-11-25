package Game.Model;

import Game.Model.Field;

/**
 * Field
 *
 * @author Gruppe11
 */
public class Property extends Field {

    private int fieldPrice;
    private int fieldRent;
    private String ownerName;
    private boolean ownedByPlayer = false;
    private String colour;

    public Property(String name, int fieldNumber, int fieldPrice, String msg, String colour) {
        super(name, fieldNumber, msg);
        this.fieldPrice = fieldPrice;
        fieldRent = fieldPrice;
        this.colour = colour;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getName() {return name;}

    public void setOwner(String playerName) {
        this.ownerName = playerName;
        this.ownedByPlayer = true;
    }

    public boolean getOwnedByPlayer() {
        return ownedByPlayer;
    }

    public int getFieldPrice() {
        return fieldPrice;
    } // til test

    public int getFieldRent() {
        return fieldRent;
    } // til test

    public String getColour() {
        return colour;
    }

    public void setDoubleRent() {
        fieldRent = fieldRent * 2;
    }

    public void removeDoubleRent() {
        fieldRent = fieldRent / 2;
    }

    public void removeOwner() {
        ownerName = null;
        ownedByPlayer = false;
    }

    @Override
    public String toString() {
        return "Felt " + super.fieldNumber + ":" + super.name + " : " + fieldPrice + "M";
    }
}
