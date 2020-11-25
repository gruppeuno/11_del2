package Game.Controller;

import Game.Model.LanguageModel;
import Game.Model.MessageControllerModel;

public class PlayerControllerMessageController extends MessageControllerModel {

    private String[] totalReadPlayerController = new String[10];

    public PlayerControllerMessageController(){
        if (LanguageModel.instanceOf().getEnglish() == true) {
            readFromFile(totalReadPlayerController, "Textfiles/PlayerControllerENG.txt");
        } else {
            readFromFile(totalReadPlayerController, "Textfiles/PlayerController.txt");
        }
    }

    @Override
    public String number(int n){
        if (n <= totalReadPlayerController.length && n >= 1) {
            return totalReadPlayerController[n - 1];
        } else {
            return "findes ikke";
        }
    }

}
