
package Game.Model;

public class LanguageModel {

    private boolean english = false;
    private static LanguageModel languageModel = null;

    public static LanguageModel instanceOf(){
        if (languageModel == null){
            return languageModel = new LanguageModel();
        } else {
            return languageModel;
        }
    }

    private LanguageModel(){
    }

    public void setEnglish(){
        english = true;
    }

    public boolean getEnglish(){
        return english;
    }

}

