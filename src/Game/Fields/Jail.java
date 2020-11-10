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
        putInJail(player.getPlayerName());
    }

    public void putInJail(String playername){
        //put in jail

        //TODO: find en måde at løse dette vvvvv
        JailVisit jailVisit = new JailVisit(name,fieldNumber,msg);
        //TODO: ^^^^^^^^

        if(jailVisit.getPlayersInJailArray()!=null) {
            String[] placeholder = new String[jailVisit.getPlayersInJailArray().length + 1];
            for (int i = 0; i < jailVisit.getPlayersInJailArray().length; i++) {
                placeholder[i] = jailVisit.getPlayersInJailArray()[i];
            }
            placeholder[placeholder.length - 1] = playername;
            jailVisit.setPlayersInJailArray(placeholder);
        }
        else if(jailVisit.getPlayersInJailArray()==null) {
            String[] placeholder = {playername};
            jailVisit.setPlayersInJailArray(placeholder);
        }
    }
}
