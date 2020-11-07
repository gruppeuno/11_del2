package Game.Fields;

public class Chance extends Field {

    private int chanceField;

    public Chance(String name, int fieldNumber, String msg, int chanceField) {
        super(name, fieldNumber, msg);
        this.chanceField = chanceField;
    }




}
