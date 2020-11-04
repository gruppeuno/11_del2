package Game;

public class FieldController {
    private Field[] fields= {
            new Field("START", 0,0,false),
            new Field("BURGERBAREN", 1,1,true),
            new Field("PIZZARIAET", 2,1,true),
            new Field("SLIKBUTIKKEN", 3,1,true),
            new Field("CHANCE", 4,0,false),
            new Field("ISKIOSKEN", 5,1,true),
            new Field("PÅ FÆNGSELSBESØG", 6,0,false),
            new Field("MUSEET", 7,2,true),
            new Field("BIBLIOTEKET", 8,2,true),
            new Field("CHANCE", 9,0,false),
            new Field("SKATERPARKEN", 10,2,true),
            new Field("SWIMMINGPOOLEN", 11,2,true),
            new Field("GRATIS PARKERING", 12,0,false),
            new Field("SPILLEHALLEN", 13,3,true),
            new Field("BIOGRAFEN", 14,3,true),
            new Field("CHANCE", 15,0,false),
            new Field("LEGETØJSBUTIKKEN", 16,3,true),
            new Field("DYREHANDLEN", 17,3,true),
            new Field("GÅ I FÆNGSEL", 18,0,false),
            new Field("BOWLINGHALLEN", 19,4,true),
            new Field("ZOO", 20,4,true),
            new Field("CHANCE", 21,0,false),
            new Field("VANDLANDET", 22,5,true),
            new Field("STRANDPROMENADEN", 23,5,true),
    };

    //Når en spiller lander på et felt
    public void landOnField(int playerID, int fieldNumber){
        Field field = fields[fieldNumber];

        //TODO; playerID skal føre til player og i if statement(hvor der står 100) skal være en reference
        //TODO til spillers balance

        //er feltet en egendom?
        if (field.getIsProperty()){

            //er feltet ejet?
            //hvis ja, betal rent
            if (field.getOwnedByPlayer())
            payRent(playerID,field);

            //feltet er ikke ejet, køb felt
            else if (!field.getOwnedByPlayer())
            buyField(playerID,field);
        }
        //gå i fængsel
        else if (field.getName()=="GÅ I FÆNGSEL")
            moveToPrison(playerID,field);
    }

    /** mangler referrance fra playerID */
    private void buyField(int playerID, Field field){
        field.setPlayerID(playerID);
        //TODO: p.b.updateBalance(field.getFieldPrice());
    }

    private void payRent(int playerID, Field field) {
        //TODO: field.getPlayerID().b.subtractBalance(field.getFieldRent());
        //TODO: p.b.addBalance(field.getFieldRent());
    }

    private void moveToPrison(int playerID, Field field){
        //TODO: move playerID til fængsel
    }
}
