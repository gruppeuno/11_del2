package Game;

public class Player  {

    private String playerName;
    private boolean playerWin = false;
    private boolean rollAgain = false;
    BankAccount b = new BankAccount(this);

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

    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                '}';
    }
}
