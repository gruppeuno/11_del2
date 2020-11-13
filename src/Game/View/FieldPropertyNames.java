package Game.View;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FieldPropertyNames extends Messages {

    private String[] totalReadFieldMessages = new String[24];

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
        readFromFile();
    }

    @Override
    public void readFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Textfiles/FieldPropertyNames.txt"));

        String currentLine = reader.readLine();

        while (currentLine != null) {
            for (int line = 0; line < totalReadFieldMessages.length; line++){
                totalReadFieldMessages[line] = currentLine;
                currentLine = reader.readLine();
            }
        }
        reader.close();
    }

    @Override
    public String number(int n) {
        if (n < 24 && n > 0){
            return totalReadFieldMessages[n-1];
        } else {
            return "findes ikke";
        }
    }
}
