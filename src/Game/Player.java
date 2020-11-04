package Game;

/**
 * Player
 * @author Gruppe11
 */

public class Player  {

    private String playerName;
    private boolean playerWin = false;
    private boolean rollAgain = false;
    private int playerID;
    private int fieldNumber;
    public BankAccount b = new BankAccount(this);


    public Player(String playerName) {
        this.playerName = playerName;
    }

    public void setPlayerWin() {
        this.playerWin = true;
    }
    public boolean getPlayerWin() {
        return playerWin;
    }
    //Skal måske bruges til CDIO3
    public void setRollAgain(boolean rollAgain) {
        this.rollAgain = rollAgain;
    }
    public boolean getRollAgain() {
        return rollAgain;
    }
    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public int getFieldNumber() {
        return fieldNumber;
    }

    public void setFieldNumber(int fieldNumber) {
        this.fieldNumber = fieldNumber;
    }
}
