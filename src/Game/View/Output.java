package Game.View;

import java.io.*;

public class Output {

    public static void main(String[] args) {
        Output o = new Output();
        try {
            o.readFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*public void print(String string){
        System.out.print(string);
    }

    public void println(String string){
        System.out.println(string);
    }*/


    public void readFromFile() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("Textfiles/Udskrivninger.txt"));

        String currentLine = reader.readLine();

        while (currentLine != null){
            System.out.println(currentLine);
            currentLine = reader.readLine();
        }

        reader.close();

    }

    }

