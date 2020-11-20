package Game.View;

public class FieldcontrollerMessages extends Messages {

    private String[] totalReadFieldcontrollerMessages = new String[17];
    private boolean english = false;

    public FieldcontrollerMessages() {

        if (english == true){
            readFromFile(totalReadFieldcontrollerMessages,"Textfiles/FieldcontrollerMessagesENG.txt");
        } else {
            readFromFile(totalReadFieldcontrollerMessages,"Textfiles/FieldcontrollerMessages.txt");
        }
    }

    @Override
    public String number(int n){
        if (n <= totalReadFieldcontrollerMessages.length && n >= 1){
            return totalReadFieldcontrollerMessages[n-1];
        } else {
            return "findes ikke";
        }
    }

    public void setEnglish(){
    }

}


