package Game;

import Game.View.LanguageModel;

import java.util.Scanner;

public class LanguageChange {

    private String input;

    public LanguageChange(){
        checkLanguage();
    }

    public void checkLanguage(){
        System.out.println("(Tast EN og tryk ENTER for at ændre sprog til engelsk) \nTryk ENTER for at starte spil ");

        Scanner lc = new Scanner(System.in);
        input = lc.nextLine();

        if (input.toLowerCase().equals("en")){
            LanguageModel.instanceOf().setEnglish();
        } else {

        }
    }

}
