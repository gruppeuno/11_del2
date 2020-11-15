package Game;

import gui_fields.*;
import gui_main.GUI;

import java.awt.*;

public class GUIView {

    private GUI_Player[] myPlayers;
    private GUI gui = new GUI(MY_GUI_FIELDS);

    public GUI getMyGUI() {
        return gui;
    }

    //TODO: kun brug playerarray som parameter
    public void createGUIPlayers(Player[] players, int startBalance) {

        Color[] myColors = {Color.RED, Color.BLUE, Color.YELLOW, Color.PINK, Color.GREEN, Color.BLACK, Color.WHITE, Color.CYAN};

        myPlayers = new GUI_Player[players.length];
        GUI_Car[] myCars = new GUI_Car[players.length];
        //laver spillere for GUI

        for (int i = 0; i < players.length; i++) {
            myCars[i] = new GUI_Car();
            myCars[i].setPrimaryColor(myColors[i]);
            myPlayers[i] = new GUI_Player(players[i].getPlayerName(), startBalance, myCars[i]);
            gui.addPlayer(myPlayers[i]);

        }
    }

    public GUI_Player getGUIPlayer(int currentPlayer) {
        return myPlayers[currentPlayer];
    }

    public static final GUI_Field[] MY_GUI_FIELDS = {
            new GUI_Start("START", " ", " ", Color.white, Color.BLACK),
            new GUI_Street("1", "BURGERBAREN", "", "1M", Color.yellow, Color.BLACK),
            new GUI_Street("2", "PIZZARIAET", "", "1M", Color.yellow, Color.BLACK),
            new GUI_Chance(),
            new GUI_Street("4", "SLIKBUTIKKEN", "", "1M", Color.blue, Color.black),
            new GUI_Street("5", "ISKIOSKEN", "", "1M", Color.blue, Color.black),
            //TODO; indsæt billede
            new GUI_Jail("","6","PÅ FÆNGSELSBESØG","", Color.gray,Color.black),
            new GUI_Street("7", "MUSEET", "", "2M", Color.MAGENTA, Color.black),
            new GUI_Street("8", "BIBLIOTEKET", "", "2M", Color.MAGENTA, Color.black),
            new GUI_Chance(),
            new GUI_Street("10", "SKATERPARKEN", "", "2M", Color.ORANGE, Color.black),
            new GUI_Street("11", "SWIMMINGPOOLEN", "", "2M", Color.ORANGE, Color.black),
            new GUI_Refuge(),
            new GUI_Street("13", "SPILLEHALLEN", "", "3M", Color.red, Color.black),
            new GUI_Street("14", "BIOGRAFEN", "", "3M", Color.red, Color.black),
            new GUI_Chance(),
            new GUI_Street("16", "LEGETØJSBUTIKKEN", "", "3M", Color.gray, Color.black),
            new GUI_Street("17", "DYREHANDLEN", "", "3M", Color.gray, Color.black),
            new GUI_Jail(),
            new GUI_Street("18", "BOWLINGHALLEN", "", "4M", Color.green, Color.black),
            new GUI_Street("19", "ZOO", "", "4M", Color.green, Color.black),
            new GUI_Chance(),
            new GUI_Street("21", "VANDLANDET", "", "5M", Color.blue, Color.black),
            new GUI_Street("22", "STRANDPROMENADEN", "", "5M", Color.blue, Color.black),
    };}
