package Game.View;

public class PlayerControllerMessages extends MessageControllerModel {

    private String[] totalReadPlayerController = new String[10];

    public PlayerControllerMessages(){
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
