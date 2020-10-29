package Game;

import gui_fields.GUI_Car;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;

import java.awt.*;

public class GUIView {

    GUI_Player[] myPlayers;
    GUI gui = new GUI(MY_GUI_FIELDS);

    public GUI getMyGUI(){
        return gui;
    }

    //TODO: kun brug playerarray som parameter
    public void createGUIPlayers(int playerArrayLength, int numberOfPlayers, String[] playerNames){

        Color[] myColors = {Color.RED, Color.BLUE, Color.YELLOW, Color.PINK, Color.GREEN, Color.BLACK, Color.WHITE, Color.CYAN};

        myPlayers = new GUI_Player[playerArrayLength];
        GUI_Car[] myCars = new GUI_Car[playerArrayLength];
        //laver spillere for GUI

        for (int i = 0; i < numberOfPlayers; i++) {
            myCars[i] = new GUI_Car();
            myCars[i].setPrimaryColor(myColors[i]);
            myPlayers[i] = new GUI_Player(playerNames[i], 1000, myCars[i]);

            getMyGUI().addPlayer(myPlayers[i]);

        }

    }

    public GUI_Player getGUIPlayer(int currentPlayer){
        return myPlayers[currentPlayer];
    }

    public static final GUI_Street[] MY_GUI_FIELDS = {
            new GUI_Street("START", "GOOD LUCK", " ", " ", Color.RED, Color.BLACK),
            new GUI_Street("1", " ", " ", " ", Color.RED, Color.BLACK),
            new GUI_Street("2", "TOWER", "Et helligt tårn er gemt her.. \n(+250 kr)", "250 kr", Color.LIGHT_GRAY, Color.BLACK),
            new GUI_Street("3", "CRATER", "Pas på krateret!! \n(-100 kr)", "-100kr", Color.YELLOW, Color.BLUE),
            new GUI_Street("4", "PALACE GATES", "Hvad gemmer sig mon bag paladsets porte? \n(+100 kr)", "100 kr", Color.BLUE, Color.PINK),
            new GUI_Street("5", "COLD DESSERT", "Pak kufferten, for ellers .. \n(-20 kr)", "-20 kr", Color.ORANGE, Color.BLUE),
            new GUI_Street("6", "WALLED CITY", "Det siges man skal investere i mursten .. (+180 kr)", "180 kr", Color.PINK, Color.RED),
            new GUI_Street("7", "MONASTERY", "Hils på munke", "0 kr", Color.GREEN, Color.BLUE),
            new GUI_Street("8", "BLACK CAVE", "Sku' ha' gået til Louis Nielsen \n(-70 kr)", "-70 kr", Color.BLACK, Color.GREEN),
            new GUI_Street("9", "HUTS IN THE MOUNTAIN", "Kan du finde hytten? \n(+60 kr)", "60kr", Color.WHITE, Color.BLUE),
            new GUI_Street("10", "THE WEREWALL", "Vogt dig.. ikke for sarte sjæle \n(-80 kr)", "-80 kr", Color.BLUE, Color.YELLOW),
            new GUI_Street("11", "THE PIT", "Take Care, man skulle jo nødig, tabe noget \n(-50 kr)", "-50 kr", Color.PINK, Color.BLUE),
            new GUI_Street("12", "GOLDMINE", "$$$ KACHING $$$ \n(+650 kr)", "650 kr", Color.ORANGE, Color.YELLOW),
            new GUI_Street("13", "QUICKSAND", "No trespassing \n(-300 kr)", "-300kr", Color.YELLOW, Color.RED),
            new GUI_Street("14", "'RONA HOTBOX", "Kom og hyg", " ", Color.MAGENTA, Color.YELLOW),
            new GUI_Street("15", "BALLERUP PIZZA BURGER GRILL", "Vand til 5 kr", "200kr", Color.CYAN, Color.BLACK)};

}
