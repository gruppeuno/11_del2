package Game.Fields;

import Game.Fields.Chance.Chance;
import Game.Fields.Field;
import Game.Player;
import Game.PlayerController;

public class Jail extends Field {

    public Jail(String name, int fieldNumber,String msg){
        super(name, fieldNumber, msg);
    }

    @Override
    public void fieldAction(Player player, PlayerController playerController) {
        player.putInJail();
        player.setFieldNumber(6);
        if (player.getJailCard() == true){
            player.JailCardFree();
            player.setJailCard(false);
            Chance.setJailCardUse(false);
        }

    }
}
