package Game.View;

public class FieldMessages extends Messages {

    private String[] totalReadFieldMessages = new String[24];


    public FieldMessages() {
        readFromFile(totalReadFieldMessages,"Textfiles/FieldMessages.txt");
    }

    @Override
    public String number(int n){
        if (n <= totalReadFieldMessages.length && n >= 0){
            return totalReadFieldMessages[n];
        } else {
            return "findes ikke";
        }

    }
    }

