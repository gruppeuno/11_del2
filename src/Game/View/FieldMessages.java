package Game.View;

public class FieldMessages extends Messages {

    private String[] totalReadFieldMessages = new String[24];

    public FieldMessages() {

        if (LanguageController.instanceOf().getEnglish() == true){
            readFromFile(totalReadFieldMessages,"Textfiles/FieldMessagesENG.txt");
        } else {
            readFromFile(totalReadFieldMessages,"Textfiles/FieldMessages.txt");
        }
    }

    @Override
    public String number(int n){
        if (n <= totalReadFieldMessages.length && n >= 1){
            return totalReadFieldMessages[n-1];
        } else {
            return "findes ikke";
        }
    }
    }

