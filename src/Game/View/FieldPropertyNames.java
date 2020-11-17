package Game.View;

public class FieldPropertyNames extends Messages {

    private String[] totalReadFieldNameMessages = new String[24];

    public FieldPropertyNames() {
        readFromFile(totalReadFieldNameMessages,"Textfiles/FieldPropertyNames.txt");
    }

    @Override
    public String number(int n) {
        if (n <= totalReadFieldNameMessages.length && n >= 1){
            return totalReadFieldNameMessages[n-1];
        } else {
            return "findes ikke";
        }
    }
}
