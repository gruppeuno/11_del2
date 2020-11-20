
package Game.View;
import org.intellij.lang.annotations.Language;

import java.util.Scanner;

public class LanguageController {

    private boolean english = false;
    private String EN;
    private static LanguageController languageController = null;

    public static LanguageController instanceOf(){
        if (languageController == null){
            return languageController = new LanguageController();
        } else {
            return languageController;
        }
    }

    private LanguageController(){

        Scanner lc = new Scanner(System.in);
        EN = lc.nextLine();

        System.out.println("EN for english" );

        if (EN.toLowerCase().equals("EN")){
            setEnglish();
        }
    }

    public void setEnglish(){
        english = true;
    }

    public boolean loadLanguageChoice(){
        return english;
    }

}

