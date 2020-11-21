
package Game.View;

import java.util.Scanner;

public class LanguageController {

    private boolean english = false;
    private static LanguageController languageController = null;

    public static LanguageController instanceOf(){
        if (languageController == null){
            return languageController = new LanguageController();
        } else {
            return languageController;
        }
    }

    private LanguageController(){

    }

    public void setEnglish(){
        english = true;
    }

    public boolean getEnglish(){
        return english;
    }

}

