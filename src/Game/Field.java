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

    public Field(String name, int fieldNumber, int fieldPrice, int fieldRent){
        this.fieldName=name;
        this.fieldNumber=fieldNumber;
        this.fieldPrice=fieldPrice;
        this.fieldRent=fieldRent;
    }

    public int getFieldNumber() { return fieldNumber; }
    public int getPlayerID() { return playerID; }

    public String getName() {
        return fieldName;
    }

    public int getFieldPrice() {
        return fieldPrice;
    }

    public void setFieldPrice(int fieldPrice) {
        this.fieldPrice = fieldPrice;
    }

    public int getFieldRent() {
        return fieldRent;
    }
}
