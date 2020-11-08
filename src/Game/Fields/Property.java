package Game.Fields;

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
    public int getFieldPrice() { return fieldPrice; }
    public int getFieldRent() { return fieldRent; }
    public void setOwner(String playerName) { this.ownerName =playerName; this.ownedByPlayer=true; }
    public boolean getOwnedByPlayer() { return ownedByPlayer; }

}
