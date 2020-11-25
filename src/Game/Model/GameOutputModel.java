package Game.Model;

import Game.Controller.GameControllerMessageController;

public class GameOutputModel {
    GameControllerMessageController gm = new GameControllerMessageController();

    //GameController Messages
    public void println(String string) {
        System.out.println(string);
    }

    public void print(String string) {
        System.out.print(string);
    }

    public String playerDieRollMsg(String currentPlayerName, int dieValue) {
        return ("\n"+ currentPlayerName + " " + gm.number(1) + " " + dieValue);
    }

    public String bankruptMsg(String currentPlayerName) {
        return (currentPlayerName + " " + gm.number(2));
    }

    public String currentBalanceMsg(int balance) {
        return gm.number(3) + " " + balance + gm.number(4);
    }

    public String lineMsg() {
        return gm.number(5) + "\n";
    }

    public String startMsg(String playerOne) {
        return gm.number(6) + "\n" + playerOne + "\n" + gm.number(7);
    }

    public String myTurnMsg(String playerName) {
        return gm.number(5) + "\n\n" + playerName + " " + gm.number(8);
    }

    public String tieMsg() {
        return gm.number(11);
    }

    public String winMsg(String leadingPlayerName, int balance, int propertyValue) {
        return leadingPlayerName + gm.number(12) + " " + balance + gm.number(13) + " "
                + propertyValue + gm.number(14);
    }

}
