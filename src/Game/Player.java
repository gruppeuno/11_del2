package Game;

import Game.Fields.Property;

import java.util.ArrayList;
import java.util.Properties;

/**
 * Player
 * @author Gruppe11
 */

public class Player {

    private String playerName;
    private boolean playerWin = false;
    private boolean isInPrison = false;
    private int fieldNumber = 0;
    private ArrayList<Property> propertiesOwned = new ArrayList<Property>();
    public BankAccount b = new BankAccount();

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public void setPlayerWin() {
        this.playerWin = true;
    }
    public boolean getPlayerWin() {
        return playerWin;
    }

    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getFieldNumber() {
        return fieldNumber;
    }

    public void setFieldNumber(int fieldNumber) {
        this.fieldNumber = fieldNumber;
    }

    public void putInJail(){
        isInPrison = true;
    }

    public void freeOfJail(){
        isInPrison = false;
        b.subBalance(1);
    }

    public boolean getIsInPrison(){
        return isInPrison;
    }

    public ArrayList<Property> getPropertiesOwned() {
        return propertiesOwned;
    }

    public void addPropertyOwned(Property property) {
        propertiesOwned.add(property);
    }

    //TODO: dårlig praktis?? think maybe not mayby is
    public int getTotalPropertyValue(){
        int totalValue=0;
        if(propertiesOwned.size()>0)
            for (Property property:propertiesOwned) {
                totalValue += property.getFieldRent();
            }
        return totalValue;
    }


}
