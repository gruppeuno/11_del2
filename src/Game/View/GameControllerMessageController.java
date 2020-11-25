package Game.View;

public class GameControllerMessageController extends MessageControllerModel {

    private String[] totalGameMessages = new String[14];

    public GameControllerMessageController() {

        if (LanguageModel.instanceOf().getEnglish() == true){
            readFromFile(totalGameMessages,"Textfiles/GameControllerMessagesENG.txt");
        } else {
            readFromFile(totalGameMessages,"Textfiles/GameControllerMessages.txt");
        }
        }

    @Override
    public String number(int n) {
        if (n <= totalGameMessages.length && n >= 1){
            return totalGameMessages[n-1];
        } else {
            return "findes ikke";
        }
    }


}
