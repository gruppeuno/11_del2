package Game.Fields;

public class JailVisit extends Field {

    private String[] playersInJailArray;

    public JailVisit(String name, int fieldNumber, String msg){
        super(name, fieldNumber, msg);
    }


    public String[] getPlayersInJailArray() {
        return playersInJailArray;
    }

    public void setPlayersInJailArray(String[] playersInJail) {
        this.playersInJailArray = playersInJail;
    }
}
