package Game.Controller;


import Game.Model.MessageControllerModel;
import Game.Model.LanguageModel;

public class FieldPropertyNameController extends MessageControllerModel {

    private String[] totalReadFieldNameMessages = new String[25];

    private static FieldPropertyNameController fieldPropertyNames;

    public static FieldPropertyNameController instanceOf() {

        if (fieldPropertyNames == null) {
            fieldPropertyNames = new FieldPropertyNameController();
        }
        return fieldPropertyNames;
    }

    private FieldPropertyNameController(){
        if (LanguageModel.instanceOf().getEnglish() == true) {
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

    }

