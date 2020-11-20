package Game.View;

public class PlayerControllerMessages extends Messages {
    private boolean english = false;

    private String[] totalReadPlayerController = new String[10];

    public PlayerControllerMessages(){
        if (english == true) {
            readFromFile(totalReadPlayerController, "Textfiles/FieldPropertyNamesENG.txt");
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

    public void setEnglish() {
        english = true;
    }
}
