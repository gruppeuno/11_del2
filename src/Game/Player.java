package Game;

public class Player{

    //værdier der skal gemmes og de er private så deres scope er klassen
    private String playerName;
    private int points = 0;
    private boolean playerWin = false;
    private boolean playerPendingWin = false;
    private boolean rollAgain = false;
    //til at tælle om man slog 2x6 sidste tur
    private int sixes = 0;

    //set og get Points
    public void setPoints(int totalValue) {
        this.points=totalValue;
    }
    public int getPoints(){
        return points;
    }

    //set og get PlayerWin
    public void setPlayerWin(boolean playerWin){
        this.playerWin=true;
    }
    public boolean getPlayerWin(){
        return playerWin;
    }

    //set og get PlayerNavn
    public void setPlayerName(String name){
        this.playerName = name;
    }

    public String getPlayerName(){
        return playerName;
    }

    //set og get  PlayerPlendingWin
    public void setPlayerPendingWin(boolean playerPendingWin){
        this.playerPendingWin=playerPendingWin;
    }
    public boolean getPlayerPendingWin(){
        return playerPendingWin;
    }

    //set og get rollAgain
    public void setRollAgain(boolean rollAgain) {
        this.rollAgain = rollAgain;
    }

    public boolean getRollAgain() {
        return rollAgain;
    }

    //set og get Sixes
    public void setSixes(int sixes) {
        this.sixes = sixes;
    }

    public int getSixes() {
        return sixes;
    }




}
