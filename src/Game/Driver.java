package Game;

/**
 *  Game
 *  @author Gruppe11
 */
public class Driver {
    //game controller skal være static for at fungere i static main
    static GameController newGameController = new GameController();

    /**
     * Main metoden
     * @param args
     */
    public static void main(String[] args) {
     newGameController.gameController();

    }

}
