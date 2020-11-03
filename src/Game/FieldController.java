package Game;

public class FieldController {
    private Field[] fields= {
            new Field("START", 0,0),
            new Field("BURGERBAREN", 1,1),
            new Field("PIZZARIAET", 2,1),
            new Field("SLIKBUTIKKEN", 3,1),
            new Field("CHANCE", 4,0),
            new Field("ISKIOSKEN", 5,1),
            new Field("PÅ FÆNGSELSBESØG", 6,0),
            new Field("MUSEET", 7,2),
            new Field("BIBLIOTEKET", 8,2),
            new Field("CHANCE", 9,0),
            new Field("SKATERPARKEN", 10,2),
            new Field("SWIMMINGPOOLEN", 11,2)
    };


    //checker om field er eget
    public boolean checkFieldOwner(int fieldNumber){
        if (fields[fieldNumber].getOwnedByPlayer())
            return true;
        else return false;
    }

    public void landOnField(int playerID, int fieldNumber){

        movePlayer(playerID,fieldNumber);
        //TODO; playerID skal føre til player og i if statement(hvor der står 100) skal være en reference
        //TODO til spillers balance
        int price = fields[fieldNumber].getFieldPrice();

        if (fields[fieldNumber].getOwnedByPlayer())
            payRent(playerID,fields[fieldNumber].getFieldRent());
        else if (100>=price)
            buyField(playerID, price);
    }

    public void buyField(int playerID, int price){
        }

    public void payRent(int playerID, int rent) {
        }

    public void movePlayer(int playerID, int fieldNumber) {
        }
    }
