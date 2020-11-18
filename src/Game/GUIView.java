package Game;

import Game.View.FieldPropertyNames;
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
            //TODO: startfeltet bør vel være felt 1, eftersom vi har 24 felter?
            new GUI_Start(FieldPropertyNames.instanceOf().number(1), "KLIK HER", "Tryk på felterne for at se deres navne \n\n KØB pris og LEJE er den samme \n\nDu får 1M for at passere start\n\nGOD FORNØJELSE", Color.white, Color.BLACK),
            new GUI_Street("1", "1M", FieldPropertyNames.instanceOf().number(2), "1M", new Color(156, 73, 18), Color.BLACK),
            new GUI_Street("2", "1M",FieldPropertyNames.instanceOf().number(3), "1M", new Color(156, 73, 18), Color.BLACK),
            new GUI_Chance(),
            new GUI_Street("4", "1M", FieldPropertyNames.instanceOf().number(5), "1M", new Color(35, 184, 208), Color.BLACK),
            new GUI_Street("5", "1M", FieldPropertyNames.instanceOf().number(6), "1M", new Color(35, 184, 208), Color.BLACK),
            new GUI_Jail("","6",FieldPropertyNames.instanceOf().number(7),FieldPropertyNames.instanceOf().number(7), Color.gray,Color.black),
            new GUI_Street("7", "2M", FieldPropertyNames.instanceOf().number(8), "2M", new Color(232, 12, 228, 255), Color.black),
            new GUI_Street("8", "2M", FieldPropertyNames.instanceOf().number(9), "2M", new Color(232, 12, 228), Color.black),
            new GUI_Chance(),
            new GUI_Street("10", "2M", FieldPropertyNames.instanceOf().number(11), "2M", new Color(255, 162, 0), Color.black),
            new GUI_Street("11", "2M", FieldPropertyNames.instanceOf().number(12), "2M", new Color(255, 162, 0), Color.black),
            new GUI_Refuge(),
            new GUI_Street("13", "3M",FieldPropertyNames.instanceOf().number(14), "3M", Color.red, Color.black),
            new GUI_Street("14", "3M", FieldPropertyNames.instanceOf().number(15), "3M", Color.red, Color.black),
            new GUI_Chance(),
            new GUI_Street("16", "3M", FieldPropertyNames.instanceOf().number(17), "3M", Color.yellow, Color.black),
            new GUI_Street("17", "3M", FieldPropertyNames.instanceOf().number(18), "3M", Color.yellow, Color.black),
            new GUI_Jail("","18",FieldPropertyNames.instanceOf().number(19),FieldPropertyNames.instanceOf().number(19), Color.gray,Color.black),
            new GUI_Street("19", "4M", FieldPropertyNames.instanceOf().number(20), "4M", new Color(11, 132, 55), Color.black),
            new GUI_Street("20", "4M", FieldPropertyNames.instanceOf().number(21), "4M", new Color(11, 132, 55), Color.black),
            new GUI_Chance(),
            new GUI_Street("22", "5M", FieldPropertyNames.instanceOf().number(23), "5M", Color.blue, Color.black),
            new GUI_Street("23", "5M", FieldPropertyNames.instanceOf().number(24), "5M", Color.blue, Color.black),
    };


    public void removeAllCarsFromChanceFields(int currentPlayer){
        MY_GUI_FIELDS[3].setCar(myPlayers[currentPlayer],false);
        MY_GUI_FIELDS[9].setCar(myPlayers[currentPlayer],false);
        MY_GUI_FIELDS[15].setCar(myPlayers[currentPlayer],false);
        MY_GUI_FIELDS[21].setCar(myPlayers[currentPlayer],false);
    }

    public void removeCarFromJailField(int currentPlayer){
        MY_GUI_FIELDS[18].setCar(myPlayers[currentPlayer],false);
    }

}

