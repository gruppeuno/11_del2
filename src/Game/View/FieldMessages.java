package Game.View;

import java.io.*;

public class FieldMessages extends Messages {

    private String[] totalReadFieldMessages = new String[24];

    private static FieldMessages fieldMessages = null;

    public static FieldMessages instanceOf() {

        try {
            if (fieldMessages == null){
                fieldMessages = new FieldMessages();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return fieldMessages;
    }

    private FieldMessages() throws IOException {
        readFromFile();
    }

    @Override
    public void readFromFile() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("Textfiles/FieldMessages.txt"));

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
    public String number(int n){
        if (n <= totalReadFieldMessages.length && n >= 1){
            return totalReadFieldMessages[n-1];
        } else {
            return "findes ikke";
        }

    }
    }

