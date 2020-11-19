package Game.View;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GameControllerMessages extends Messages {

    private String[] totalGameMessages = new String[14];

    public GameControllerMessages() {
        readFromFile(totalGameMessages, "Textfiles/GameControllerMessages.txt");
    }

    @Override
    public String number(int n) {
        if (n <= totalGameMessages.length && n >= 1) {
            return totalGameMessages[n - 1];
        } else {
            return "findes ikke";
        }
    }
}
