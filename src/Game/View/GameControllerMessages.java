package Game.View;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GameControllerMessages extends Messages {

    private String[] totalGameMessages = new String[14];

    private static GameControllerMessages gameControllerMessages = null;

    public static GameControllerMessages instanceOf() {

        try {
            if (gameControllerMessages == null){
                gameControllerMessages = new GameControllerMessages();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return gameControllerMessages;
    }

    private GameControllerMessages() throws IOException {
        readFromFile(totalGameMessages,"Textfiles/GameControllerMessages.txt");
    }

    @Override
    public String number(int n) {
        if (n <= totalGameMessages.length && n >= 1){
            return totalGameMessages[n-1];
        } else {
            return "findes ikke";
        }
    }
}
