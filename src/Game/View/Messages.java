package Game.View;

import java.io.BufferedReader;
import java.io.FileReader;

public abstract class Messages {

    public void readFromFile(String[] array, String filepath) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));

            String currentLine = reader.readLine();

            while (currentLine != null) {
                for (int line = 0; line < array.length; line++) {
                    array[line] = currentLine;
                    currentLine = reader.readLine();
                }
            }

            reader.close();
        } catch (Exception e) {

        }

    }

    public abstract String number(int n);

}

