package Game;

import Game.Fields.Property;

import java.util.ArrayList;

/**
 * Player
 *
 * @author Gruppe11
 */

public class Player {

    private String playerName;
    private boolean playerWin = false;
    private boolean isInPrison = false;
    private int fieldNumber = 0;
    private ArrayList<Property> propertiesOwned = new ArrayList<Property>();


    private BankAccount bankAccount = new BankAccount();
    private boolean jailCard = false;

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

    public void setJailCard(boolean JailCard) {
        this.jailCard = JailCard;
    }

    public boolean getJailCard() {
        return jailCard;
    }

    public int getFieldNumber() {
        return fieldNumber;
    }

    public void setFieldNumber(int fieldNumber) {
        this.fieldNumber = fieldNumber;
    }

    public void putInJail() {
        isInPrison = true;
    }

    public void jailCardFree() {
        isInPrison = false;
    }

    public boolean getIsInPrison() {
        return isInPrison;
    }

    public ArrayList<Property> getPropertiesOwned() {
        return propertiesOwned;
    }

    public void addPropertyOwned(Property property) {
        propertiesOwned.add(property);
    }

    public void freeOfJail() {
        isInPrison = false;
        bankAccount.subBalance(1);
    }

    public int getTotalPropertyValue() {
        int totalValue = 0;
        if (propertiesOwned.size() > 0)
            for (Property property : propertiesOwned) {
                totalValue += property.getFieldPrice();
            }
        return totalValue;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }


}
