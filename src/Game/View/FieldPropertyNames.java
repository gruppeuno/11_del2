package Game.View;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FieldPropertyNames extends Messages {

    private String[] totalReadFieldNameMessages = new String[24];

    private static FieldPropertyNames fieldPropertyNames = null;

    public static FieldPropertyNames instanceOf() {

        try {
            if (fieldPropertyNames == null){
                fieldPropertyNames = new FieldPropertyNames();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return fieldPropertyNames;
    }

    private FieldPropertyNames() throws IOException {
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
