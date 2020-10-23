package Game;

public class GameTurn {

    //max points
    final static int MAX = 40;

    public void gameTurn(int die1, int die2, Player p) {
        System.out.println(p.toString() + " slog " + die1 +" og " + die2);

        //set PlayerPendingWin til true, hvis spilleren har +40 points, samt sæt værdien til MAX
        //læg ternings siderne til points
        if (p.getPoints()>= MAX) {
            p.setPlayerPendingWin(true);
            p.setPoints(MAX);
        }
        //hvis terningerne giver over 40, da man ikke kan have over 40 points
        else p.setPoints(Math.min((p.getPoints() + die1 + die2), MAX));

        //hvis 2 ens
        if (die1 == die2) {

            //ekstra tur hvis 2 ens
            p.setRollAgain(true);

            //snake eyeees, 2x1 = mister alle points, samt mister pending win hvis man nu var på 40 points
            if (die1 == 1) {
                p.setPoints(0);
                p.setPlayerPendingWin(false);
                System.out.println("SNAKE EYES!!! Du slog to 1'ere og mistede alle dine points... Du må slå igen");
            }

            //vinder hvis man slår 2 seksere i streg, uanset om det var samme eller forrige tur
            if (die1 == 6) {

                //hvis man slog 2x6 sidste tur
                if (p.getSixes() == 1) {
                    p.setPlayerWin();
                    System.out.println("du slog to 6'ere igen!");
                }

                //sætter antal 2x6 til 1
                else {
                    p.setSixes(1);
                }
            }

            //slå 2 ens for at vinde, hvis altså du er på 40 points
            if (p.getPlayerPendingWin()) {
                p.setPlayerWin();
                System.out.println("Du vandt!");
                p.setRollAgain(false);
            }

            //set seksere til 0, da spiller ikke slog 6
            else if (die1!=6){
                p.setSixes(0);
                System.out.println(p.toString() + " har nu " + p.getPoints() + " points");
            }
            else {
                System.out.println(p.toString() + " har nu " + p.getPoints() + " points");
            }
        }

        //hvis die1 != die2
        else {
            p.setRollAgain(false);
            p.setSixes(0);
            System.out.println(p.toString() + " har nu " + p.getPoints() + " points");
        }
    }
}