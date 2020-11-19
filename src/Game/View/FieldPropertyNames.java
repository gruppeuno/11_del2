package Game.View;

public class FieldPropertyNames extends Messages {

    private String[] totalReadFieldNameMessages = new String[24];

    private static FieldPropertyNames fieldPropertyNames;

    public static FieldPropertyNames instanceOf() {

        if (fieldPropertyNames == null) {
            fieldPropertyNames = new FieldPropertyNames();
        }
        return fieldPropertyNames;
    }

    public FieldPropertyNames() {
        readFromFile(totalReadFieldNameMessages, "Textfiles/FieldPropertyNames.txt");
    }

    @Override
    public String number(int n) {
        if (n <= totalReadFieldNameMessages.length && n >= 0){
            return totalReadFieldNameMessages[n];
        } else {
            return "findes ikke";
        }
    }
}
