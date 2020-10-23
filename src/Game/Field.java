package Game;

import java.util.Scanner;

public class Field {

    private String msg;
    private int myFieldValue = 0;

    public void setMyFieldValue(Player player) {

        Scanner scan = new Scanner(System.in);

        RaffleCup dice = new RaffleCup();

        dice.roll();
        int dieSum = dice.getDie();

        String roll;

        do {
            System.out.println(player + " kast terningen!");

            roll = scan.nextLine();
        }
        while (!roll.toLowerCase().equals("kast"));

        switch (dieSum) {
            case 2:
                msg = "Du har fundet tårnet, det sælger du for 250";
                myFieldValue = 250;
                break;

            case 3:
                msg = "Du er faldet ned i et krater. Du betaler en mand 100 for at komme op";
                myFieldValue = -100;
                break;

            case 4:
                msg = "Du står foran paladsets porte. Du får 100 for din fund";
                myFieldValue = 100;
                break;

            case 5:
                msg = "Du befinder dig i en kold ørken. Du køber en poncho for 20";
                myFieldValue = -20;
                break;

            case 6:
                msg = "Du finder en by med murer rundt om. Du får 180 for at sælge nogle mursten";
                myFieldValue = 180;
                break;

            case 7:
                msg = "Du finder et kloster, da de er munke har de ingen penge, og du må gå videre";
                break;

            case 8:
                msg = "Du finder en mørk, sort hule, du betaler 70 for en fakkel";
                myFieldValue = -70;
                break;

            case 9:
                msg = "Du finder en hytte i bjergene. Du får 60 for at finde det.";
                myFieldValue = 60;
                break;

            case 10:
                msg = "Du finder en mur lavet af døde varulve. Du løber og taber derfor 80";
                myFieldValue = -80;

                break;

            case 11:
                msg = "Du finder en grube, hvor du taber 50";
                myFieldValue = -50;
                break;

            case 12:
                msg = "Du finder en guldmine, og blive belønet med 650 guldmønter";
                myFieldValue = 650;
                break;
        }
        System.out.println("Terningsummen er: " + dieSum);

        System.out.println(msg);

        if (dieSum == 10) {
            System.out.println("\nDu ramte varulve muren. Du får en tur til");
            Field value = new Field();
            //balance = value.myFieldValue(balance, player);
        }

            /*
            if (balance >= 3000) {
                System.out.println(player + " har vundet spillet!");
                balance = -1;
            }
                     */


    }

    public int getMyFieldValue(){
        return myFieldValue;
    }
}
