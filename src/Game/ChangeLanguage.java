package Game;

import Game.View.LanguageController;

import java.util.Scanner;

public class ChangeLanguage {

    public ChangeLanguage(){
        checkLanguage();
    }

    public void checkLanguage(){
        System.out.println("(Tast EN og tryk ENTER for at ændre sprog til engelsk) \nTryk ENTER for at starte spil ");

        Scanner lc = new Scanner(System.in);
        String input = lc.nextLine();

        if (input.toLowerCase().equals("en")){
            LanguageController.instanceOf().setEnglish();
        } else {

        }
    }

}
