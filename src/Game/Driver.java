package Game;

import Game.View.LanguageController;

import java.util.Scanner;

/**
 *  Game
 *  @author Gruppe11
 */
public class Driver {
    //game controller skal være static for at fungere i static main
    static GameController ny = new GameController();

    /**
     * Main metoden
     * @param args
     */
    public static void main(String[] args) {
     ny.gameController();

    }

}
