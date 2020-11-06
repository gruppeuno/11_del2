package Game.Fields;

import Game.Fields.Field;

public class Jail extends Field {
    final private int bailPrice = 1;
    public Jail(String name, int fieldNumber){
        super(name, fieldNumber);
    }

    public int getBailPrice() {
        return bailPrice;
    }
}
