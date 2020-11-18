package Game.View;

public class FieldPropertyNames extends Messages {

    private String[] totalReadFieldNameMessages = new String[24];

    private static FieldPropertyNames fieldPropertyNames;

    public static FieldPropertyNames instanceOf(){

        if (fieldPropertyNames == null){
            fieldPropertyNames = new FieldPropertyNames();
        }
        return fieldPropertyNames;
    }

    private FieldPropertyNames() {
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
