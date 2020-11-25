package Game.View;

public class FieldControllerMessageController extends MessageControllerModel {

    private String[] totalReadFieldControllerMessages = new String[17];
    private boolean english = false;

    public FieldControllerMessageController() {

        if (LanguageModel.instanceOf().getEnglish() == true){
            readFromFile(totalReadFieldControllerMessages,"Textfiles/FieldcontrollerMessagesENG.txt");
        } else {
            readFromFile(totalReadFieldControllerMessages, "Textfiles/FieldControllerMessages.txt");
        }
    }

    @Override
    public String number(int n){
        if (n <= totalReadFieldControllerMessages.length && n >= 1){
            return totalReadFieldControllerMessages[n-1];
        } else {
            return "findes ikke";
        }
    }
}


