package Game.View;
import java.io.*;

public abstract class Messages {

    public void readFromFile(String[] array,String filepath) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(filepath));

        String currentLine = reader.readLine();

        while (currentLine != null) {
            for (int line = 0; line < array.length; line++){
                array[line] = currentLine;
                currentLine = reader.readLine();
            }
        }

        reader.close();
    }

    public abstract String number(int n);

}

