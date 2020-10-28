package Game;

import gui_fields.GUI_Car;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.awt.*;

public class GUIInterface {

    GUI myGUI;
    GUI_Player[] myPlayers;

    public GUIInterface(GUI gui){
        myGUI = gui;
    }

    public void createGUIPlayers(int playerArrayLength, int numberOfPlayers, String[] playerNames){

        Color[] myColors = {Color.RED, Color.BLUE, Color.YELLOW, Color.PINK, Color.GREEN, Color.BLACK, Color.WHITE, Color.CYAN};

        myPlayers = new GUI_Player[playerArrayLength];
        GUI_Car[] myCars = new GUI_Car[playerArrayLength];
        //laver spillere for GUI

        for (int i = 0; i < numberOfPlayers; i++) {
            myCars[i] = new GUI_Car();
            myCars[i].setPrimaryColor(myColors[i]);
            myPlayers[i] = new GUI_Player(playerNames[i], 1000, myCars[i]);
            myGUI.addPlayer(myPlayers[i]);

        }

    }

    public GUI_Player getGUIPlayer(int currentPlayer){
        return myPlayers[currentPlayer];
    }


}
