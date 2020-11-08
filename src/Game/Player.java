package Game;

/**
 * Player
 * @author Gruppe11
 */

public class Player {

    private String playerName;
    private boolean playerWin = false;
    private boolean rollAgain = false;
    private int fieldNumber = 0;
    private int lastFieldNumber;
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

    public int getFieldNumber() {
        return fieldNumber;
    }

    public void setFieldNumber(int fieldNumber) {
        this.fieldNumber = fieldNumber;
    }

    public int getLastFieldNumber() { return lastFieldNumber; }

    public void setLastFieldNumber(int lastFieldNumber) {
        this.lastFieldNumber = lastFieldNumber;
    }
}
