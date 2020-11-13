package Game.View;

import java.io.*;
import java.util.ArrayList;

public class Output {

    ArrayList<String> linesInFile = new ArrayList<String>();

    public static void main(String[] args) {
        Output o = new Output();
        try {
            o.readFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromFile() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("Textfiles/Udskrivninger.txt"));

        String currentLine = reader.readLine();

        while (currentLine != null) {
            linesInFile.add(currentLine);
            currentLine = reader.readLine();
        }

        reader.close();
        System.out.println(linesInFile.toString());

    }

    }

