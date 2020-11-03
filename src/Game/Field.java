package Game;

/**
 * Field
 * @author Gruppe11
 */
public class Field {

    private String fieldName;
    private int fieldPrice;
    private int fieldRent;
    private int fieldNumber;
    private int playerID;
    private boolean ownedByPlayer;

    public Field(String name, int fieldNumber, int fieldPrice){
        this.fieldName=name;
        this.fieldNumber=fieldNumber;
        this.fieldPrice=fieldPrice;
        fieldRent=fieldPrice;
    }

    public int getFieldNumber() { return fieldNumber; }
    public int getPlayerID() { return playerID; }
    public String getName() { return fieldName; }
    public int getFieldPrice() { return fieldPrice; }
    public int getFieldRent() { return fieldRent; }
    public void setPlayerID(int playerID) { this.playerID = playerID; this.ownedByPlayer=true; }
    public boolean getOwnedByPlayer() { return ownedByPlayer; }
}
