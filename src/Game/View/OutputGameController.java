package Game.View;

import java.io.*;
import java.util.ArrayList;

public class OutputGameController {

    ArrayList<String> totalReadLines = new ArrayList<String>();

    public static void main(String[] args) {
        OutputGameController o = new OutputGameController();
        try {
            o.readFromFile();
            o.printLineN(3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromFile() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("Textfiles/OutputGame.txt"));

        String currentLine = reader.readLine();

        while (currentLine != null) {
            totalReadLines.add(currentLine);
            currentLine = reader.readLine();
        }

        reader.close();
        //TODO: slettes efter
        System.out.println(totalReadLines.toString());

    }

    public void printLineN(int n){
        if (totalReadLines.size() >= n){
            print(totalReadLines.get(n));
        } else {
            print("denne linje findes ikke");
        }

    }

    public void print(String string){
        System.out.print(string);
    }

    public void println(String string){
        System.out.println(string);
    }

    }

