package Game;

/**
 * Field
 * @author Gruppe11
 */
public class Field {

    private String name;
    private int fieldPrice;
    private int fieldRent;
    private int fieldNumber;
    private int playerID;

    public void Field(String name, int fieldNumber, int fieldPrice, int fieldRent){
        this.name=name;
        this.fieldNumber=fieldNumber;
        this.fieldPrice=fieldPrice;
        this.fieldRent=fieldRent;

    }

    public int getFieldNumber() { return fieldNumber; }
    public int getPlayerID() { return playerID; }
    public void setPlayerID(int playerID) { this.playerID = playerID; }
}
