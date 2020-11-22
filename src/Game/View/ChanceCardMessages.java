package Game.View;

public class ChanceCardMessages extends Messages{

    private String[] totalReadFieldMessages = new String[62];

    public ChanceCardMessages() {

        if (LanguageController.instanceOf().getEnglish() == true){
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
