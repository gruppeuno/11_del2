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

        if (playersInJailArray != null){
            for (String playerName : playersInJailArray) {
                if (playerName == player.getPlayerName()) {
                    getOutOfJail(playerController.getPlayerByName(playerName), playerController);
                }
            }
        }

        }

    private void getOutOfJail(Player player, PlayerController playerController){
        //get out of jail
        String[] nullArray;
        nullArray=null;
        playerController.getPlayerByName(playersInJailArray[0]).b.subBalance(1);

        String[] placeholder = new String[playersInJailArray.length - 1];
        if(playersInJailArray.length==1) {
            setPlayersInJailArray(nullArray);
        }
        else setPlayersInJailArray(placeholder);
    }

}
