package Game.View;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GameControllerMessages extends Messages {

    private String[] totalReadFieldMessages = new String[14];

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
        readFromFile();
    }

    @Override
    public void readFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Textfiles/GameControllerMessages.txt"));

        String currentLine = reader.readLine();

        while (currentLine != null) {
            for (int line = 0; line < totalReadFieldMessages.length; line++){
                totalReadFieldMessages[line] = currentLine;
                currentLine = reader.readLine();
            }
        }
        reader.close();
    }

    @Override
    public String number(int n) {
        if (n <= totalReadFieldMessages.length && n >= 1){
            return totalReadFieldMessages[n-1];
        } else {
            return "findes ikke";
        }
    }
}
