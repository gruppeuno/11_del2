package Game.View;

import java.io.*;
import java.util.ArrayList;

public class Messages {

    ArrayList<String> totalReadLines = new ArrayList<String>();

    public static void main(String[] args) {
        FieldMessages o = new FieldMessages();
        try {
            o.readFromFile();
            System.out.println(o.number(4));

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

    public String number(int n){
        if (totalReadLines.size() >= n){
            return totalReadLines.get(n-1);
        } else {
            return "findes ikke";
        }

    }

    public void print(String string){
        System.out.print(string);
    }

    public void println(String string){
        System.out.println(string);
    }



}

