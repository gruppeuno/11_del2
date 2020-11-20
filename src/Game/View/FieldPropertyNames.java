package Game.View;

import Game.Fields.Field;

public class FieldPropertyNames extends Messages {
    private boolean english = false;

    private String[] totalReadFieldNameMessages = new String[24];

    private static FieldPropertyNames fieldPropertyNames;

    public static FieldPropertyNames instanceOf() {

        if (fieldPropertyNames == null) {
            fieldPropertyNames = new FieldPropertyNames();
        }
        return fieldPropertyNames;
    }

    private FieldPropertyNames(){
        if (english == true) {
            readFromFile(totalReadFieldNameMessages, "Textfiles/FieldPropertyNamesENG.txt");
        } else {
            readFromFile(totalReadFieldNameMessages, "Textfiles/FieldPropertyNames.txt");
        }
    }

        @Override
        public String number(int n){
            if (n <= totalReadFieldNameMessages.length && n >= 1) {
                return totalReadFieldNameMessages[n - 1];
            } else {
                return "findes ikke";
            }
        }

        public void setEnglish() {
            english = true;
        }
    }

