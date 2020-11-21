package Game.View;

public class ChanceCardMessages extends Messages{

    private String[] totalReadFieldMessages = new String[59];
    private boolean english = false;

    public ChanceCardMessages() {

        if (english == true){
            readFromFile(totalReadFieldMessages,"Textfiles/ChanceCardMessages.txt");
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
