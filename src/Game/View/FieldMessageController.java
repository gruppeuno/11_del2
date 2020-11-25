package Game.View;

public class FieldMessageController extends MessageControllerModel {

    private String[] totalReadFieldMessages = new String[24];

    public FieldMessageController() {

        if (LanguageModel.instanceOf().getEnglish() == true){
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

