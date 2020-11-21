package Game.View;

public class GameControllerMessages extends Messages {

    private String[] totalGameMessages = new String[14];

    public GameControllerMessages() {

        if (LanguageController.instanceOf().loadLanguageChoice() == true){
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
