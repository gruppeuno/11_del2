package Game.Model;

import java.io.BufferedReader;
import java.io.FileReader;

public abstract class MessageControllerModel {

    public void readFromFile(String[] array, String filepath) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));

            String currentLine = reader.readLine();
            int line = 0;

            while (currentLine != null) {
                    array[line] = currentLine;
                    currentLine = reader.readLine();
                    line++;
            }

            reader.close();
        } catch (Exception e) {

        }

    }

    public abstract String number(int n);

}

