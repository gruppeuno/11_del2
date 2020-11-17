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
        readFromFile(totalReadFieldMessages,"Textfiles/FieldMessages.txt");
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

