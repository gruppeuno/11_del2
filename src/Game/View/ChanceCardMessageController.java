package Game.View;

public class ChanceCardMessageController extends MessageControllerModel {

    private String[] totalReadFieldMessages = new String[62];

    public ChanceCardMessageController() {

        if (LanguageModel.instanceOf().getEnglish() == true){
            readFromFile(totalReadFieldMessages,"Textfiles/ChanceCardMessagesENG.txt");
        } else {
            readFromFile(totalReadFieldMessages,"Textfiles/ChanceCardMessages.txt");
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
