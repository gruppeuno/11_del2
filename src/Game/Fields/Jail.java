package Game.Fields;

import Game.Fields.Field;
import Game.Player;
import Game.PlayerController;

public class Jail extends Field {

    public Jail(String name, int fieldNumber,String msg){
        super(name, fieldNumber, msg);
    }

    @Override
    public void fieldAction(Player player, PlayerController playerController) {
        player.setFieldNumber(6);
        putInJail(player,playerController);

    }

    private void putInJail(Player player, PlayerController playerController){
        //put in jail
        JailVisit jv = new JailVisit(name,fieldNumber,msg);
        if(jv.getPlayersInJailArray()!=null) {
            String[] placeholder = new String[jv.getPlayersInJailArray().length + 1];
            for (int i = 0; i < jv.getPlayersInJailArray().length; i++) {
                placeholder[i] = jv.getPlayersInJailArray()[i];
            }
            placeholder[placeholder.length - 1] = player.getPlayerName();
            jv.setPlayersInJailArray(placeholder);
        }
        else if(jv.getPlayersInJailArray()==null) {
            String[] placeholder = {player.getPlayerName()};
            jv.setPlayersInJailArray(placeholder);
        }
    }


}
