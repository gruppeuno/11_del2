package Game.Fields;

import Game.Player;
import Game.PlayerController;

public class JailVisit extends Field {

    public JailVisit(String name, int fieldNumber, String msg){
        super(name, fieldNumber, msg);
    }

    @Override
    public void fieldAction(Player player, PlayerController playerController) {
        if (player.getIsInPrison() == true) {
            getOutOfJail(player);
        }
    }

    private void getOutOfJail(Player player){
        //get out of jail
        player.freeOfJail();

    }
}
