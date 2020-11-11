package Game;

import java.util.Scanner;

/**
 * PlayerController
 * @author Gruppe11
 */

public class PlayerController {


    private int numberOfPlayers;
    private Scanner scan = new Scanner(System.in);
    private Player[] playerArray;

    /**
     * kører for-loop og scanner hver spillers
     * spørger nyt navn hvis checkPlayerNam() er true
     */
    public void playerCreator(){
        numberOfPlayers();
        createPlayers();
        setStartBalance();
        System.out.println("Indtast spillernavn lad den yngste spiller starte");
        for (int i = 0; i < playerArray.length; i++){
            int nr = i+1;
            System.out.println("spiller " + nr + " Indtast et navn der er mellem 3-12 tegn, spillere må ikke have samme navn:");
            String currentName = scan.next();

           while (checkPlayerName(currentName,playerArray)) {
               System.out.print("Navnet du ønsker er ugyldigt. Vælg nyt navn: ");
               currentName = scan.next();
           }
            playerArray[i].setPlayerName(currentName);
        }
        System.out.println("========================================\n");
    }

    /**
     * Loop der indlæser antal spillere melle 2-6 og sørger for indtastningen er gyldig
     */

    public void numberOfPlayers(){
        final int MAX = 4;
        final int MIN = 2;
        //While loop til at sikre at der er indtastet mellem 2-4 spillere
        System.out.println("Indtast et antal spillere mellem 2-4");
        do{
            while (!scan.hasNextInt()) {
                System.out.println("Ugyldigt input. Indtast et antal spillere mellem 2-4");
                scan.next();
            }
            numberOfPlayers = scan.nextInt();

            if (numberOfPlayers< MIN || numberOfPlayers> MAX)
                System.out.println("Ugyldigt antal spillere. Indtast et antal spillere mellem 2-4");
        }while (numberOfPlayers< MIN || numberOfPlayers> MAX);
        System.out.println("numberOfPlayers " + numberOfPlayers + "\n");
    }

    /**
     * opretter spillere i playerArray
     */

    public void createPlayers(){
        this.playerArray = new Player[numberOfPlayers];
        for (int i = 0; i < playerArray.length; i++) {
            playerArray[i] = new Player("p" + i);
        }
    }

    /**
     * Tjekker i for loop om spillerene har samme navn. Hvis de har samme navn returneres true
     * if-statement benyttes til at tjekke om det indtastede navn er mellem 3-12 bogstaver
     * returnerer true hvis navnet er over 12 bogstaver eller udner 3 bogstaver
     * @param name
     * @param array
     * @return
     */

    public boolean checkPlayerName(String name, Player[] array)
    {
        //Kontrollerer om navnet allerede er brugt
        for (int i = 0; i < playerArray.length; i++) {
            if (playerArray[i].getPlayerName().toLowerCase().equals(name.toLowerCase()))
                return true;
        }
        if (name.length() > 12 || name.length() < 3)
            return true;
        return false;
    }

    public Player[] getPlayerArray(){ return playerArray; }

    public void movePlayer(Player player, int dieValue){
        int newSpot = player.getFieldNumber()+dieValue;
        if ( newSpot > 23 ) {
            newSpot = newSpot - 24;
            player.b.addBalance(2);
        }
        player.setFieldNumber(newSpot);
    }

    public Player getPlayerByName(String name){
        for (Player player: playerArray) {
            if (player.getPlayerName().equals(name))
                return player;
        }
        return null;
    }

    //TODO: testmetode, må ikke slettes, ellers stopper integrationstest og unittest med at virke
    public void createPlayers(int numberOfPlayers){
        this.playerArray = new Player[numberOfPlayers];
        for (int i = 0; i < playerArray.length; i++) {
            playerArray[i] = new Player("p" + i);
        }
        setStartBalance();
    }

    public void setStartBalance(){
        if(playerArray.length==2)
            for (int i = 0; i < 2; i++)
                playerArray[i].b.setBalance(20);

        else if(playerArray.length==3)
            for (int i = 0; i < 3; i++)
                playerArray[i].b.setBalance(18);

        else if(playerArray.length==4)
            for (int i = 0; i < 4; i++)
                playerArray[i].b.setBalance(16);

    }

    //TODO: metode til at fjerne property
    public void sellProperty(Player player, int payment){
        int minPayment = payment;
        int arraylistSizeBefore = player.getPropertiesOwned().size();

        if(player.getPropertiesOwned().size()>0)
            for (int j = minPayment; j >= payment; j++) {
                for (int i = 0; i < player.getPropertiesOwned().size(); i++) {
                    if(player.getPropertiesOwned().get(i).getFieldPrice()>=payment){
                        player.getPropertiesOwned().remove(i);
                        break;
                    }
                }
            }

        if(player.getPropertiesOwned().size()==0 && player.b.getBalance()==0)
            player.b.setBankrupt(true);
        else if (arraylistSizeBefore==player.getPropertiesOwned().size())
            player.b.setBankrupt(true);
    }

    public void handlePayment(Player player, int payment){
        int balanceCheck = player.b.getBalance()-payment;
        if (balanceCheck>=payment)
            player.b.subBalance(payment);

        else if(balanceCheck<=0) {
            if (player.getTotalPropertyValue()<payment){
                player.b.setBankrupt(true);
            }
            else if (player.getTotalPropertyValue()>payment){
                sellProperty(player,payment);
            }
        }
    }




}




