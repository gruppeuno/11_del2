package Game.Fields;

/**
 * Field
 * @author Gruppe11
 */
public class Property extends Field {

    private int fieldPrice;
    private int fieldRent;
    private String ownerName;
    private boolean ownedByPlayer;

    public Property(String name, int fieldNumber, int fieldPrice){
        super(name,fieldNumber);
        this.fieldPrice=fieldPrice;
        fieldRent=fieldPrice;
    }


    public int getFieldNumber() { return fieldNumber; }
    public String getOwnerName() { return ownerName; }
    public String getName() { return name; }
    public int getFieldPrice() { return fieldPrice; }
    public int getFieldRent() { return fieldRent; }
    public void setOwner(String playerName) { this.ownerName =playerName; this.ownedByPlayer=true; }
    public boolean getOwnedByPlayer() { return ownedByPlayer; }

}
