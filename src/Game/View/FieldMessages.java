package Game.View;

import java.io.*;
import java.util.ArrayList;

public class FieldMessages {

    ArrayList<String> totalReadLines = new ArrayList<String>();

    public static void main(String[] args) {
        FieldMessages o = new FieldMessages();
        try {
            o.readFromFile();
            o.printThisLine(3);
            o.printThisLine(5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromFile() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("Textfiles/FieldMessages.txt"));

        String currentLine = reader.readLine();

        while (currentLine != null) {
            totalReadLines.add(currentLine);
            currentLine = reader.readLine();
        }

        reader.close();
    }

    public void printThisLine(int n){
        if (totalReadLines.size() >= n){
            println(totalReadLines.get(n - 1));
        } else {
            println("denne linje findes ikke");
        }

    }

    public void print(String string){
        System.out.print(string);
    }

    public void println(String string){
        System.out.println(string);
    }



    }

