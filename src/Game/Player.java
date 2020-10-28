package Game;

/**
 * Player
 * @author Gruppe11
 */

public class Player  {

    private String playerName;
    private boolean playerWin = false;
    private boolean rollAgain = false;
    BankAccount b = new BankAccount(this);

    /**
     * Sætter spillerens navn
     * @param playerName
     */
    public Player(String playerName) {
        this.playerName = playerName;
    }

    /**
     * sætter PlayerWin til true
     */
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

    /**
     * Returnerer spillernavn i stedet for hvor spilleren er gemt i hukommelsen
     * @return
     */
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                '}';
    }
}
