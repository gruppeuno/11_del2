
package Game.View;
import org.intellij.lang.annotations.Language;

import java.util.Scanner;

public class LanguageController {

    private boolean english = false;
    private String input;
    private static LanguageController languageController = null;

    public static LanguageController instanceOf(){
        if (languageController == null){
            return languageController = new LanguageController();
        } else {
            return languageController;
        }
    }

    private LanguageController(){

        System.out.println("Type EN for english" );

        Scanner lc = new Scanner(System.in);
        input = lc.nextLine();

        if (input.toLowerCase().equals("EN")){
            loadLanguageChoice();
        }
    }

    public boolean loadLanguageChoice(){
        return english = true;
    }

}

