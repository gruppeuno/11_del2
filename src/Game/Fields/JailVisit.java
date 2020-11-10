package Game.Fields;

import Game.Player;
import Game.PlayerController;

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

    @Override
    public void fieldAction(Player player, PlayerController playerController) {

        //put in jail
        if(playersInJailArray!=null) {
            String[] placeholder = new String[playersInJailArray.length + 1];
            for (int i = 0; i < playersInJailArray.length; i++) {
                placeholder[i] = playersInJailArray[i];
            }
            placeholder[placeholder.length - 1] = player.getPlayerName();
            setPlayersInJailArray(placeholder);
        }
        else if(playersInJailArray==null) {
            String[] placeholder = {player.getPlayerName()};
            setPlayersInJailArray(placeholder);
        }

        //get out of jail
        String[] nullArray;
        nullArray=null;
        playerController.getPlayerByName(playersInJailArray[playersInJailArray.length-1]).b.subBalance(1);

        String[] placeholder = new String[playersInJailArray.length - 1];
        if(playersInJailArray.length==1) {
            setPlayersInJailArray(nullArray);
        }
        else setPlayersInJailArray(placeholder);
    }
}
