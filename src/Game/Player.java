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

}
