package Game;

import Game.View.GameControllerMessages;

public class MessageController {

    //GameController Messages
    public void print(String string){
        System.out.println(string);
    }

    public String playerDieRollMsg(String currentPlayerName, int dieValue){
        return (currentPlayerName + " " + GameControllerMessages.instanceOf().number(1) + " " + dieValue);
    }

    public String bankruptMsg(String currentPlayerName){
        return (currentPlayerName + " " + GameControllerMessages.instanceOf().number(2));
    }

    public String currentBalanceMsg(String currentPlayerName, int balance){
        return currentPlayerName + " " + GameControllerMessages.instanceOf().number(3) + " " + balance + GameControllerMessages.instanceOf().number(4);
    }

    public String lineMsg(){
        return GameControllerMessages.instanceOf().number(5);
    }

    public String startMsg(){
        return GameControllerMessages.instanceOf().number(6);
    }

    public String startInputMsg(){
        return GameControllerMessages.instanceOf().number(7);
    }

    public String rollInputMsg(){
        return GameControllerMessages.instanceOf().number(10);
    }

    public String myTurnMsg(String playerName){
        return GameControllerMessages.instanceOf().number(8) + playerName + GameControllerMessages.instanceOf().number(9);
    }

    public String tieMsg(){
        return GameControllerMessages.instanceOf().number(11);
    }

    public String winMsg(String leadingPlayerName, int balance, int propertyValue){
        return leadingPlayerName + GameControllerMessages.instanceOf().number(12) + " " + balance + GameControllerMessages.instanceOf().number(13) + " "
                + propertyValue + GameControllerMessages.instanceOf().number(14);
    }

}
