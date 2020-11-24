package Test;

import Game.FieldController;
import Game.Fields.Property;
import Game.GUIView;
import Game.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FieldControllerTest {



    /**Test af landOnJail*//*
    @Test
    public void isPlayerInJail(){
        Player testPlayer1 = new Player("testPerson1");
        testPlayer1.putInJail();

        boolean expected = true;
        boolean actual = testPlayer1.getIsInPrison();

        assertEquals(expected,actual);
    }


    //test af om spiller bliver rykket fra Jail til JailVisit
 @Test
 public void isJailedPlayerMovedToJailVisitField(){
     Player testPlayer = new Player("testPerson");
     PlayerController playerController = new PlayerController();
     FieldController fieldController = new FieldController();

     fieldController.landOnJail(testPlayer);
     int actual = 6;

     assertEquals(actual,testPlayer.getFieldNumber());
 }

 @Test
 public void playerIsInPrison(){
    Player testPlayer = new Player("testPerson");
    PlayerController playerController = new PlayerController();
    FieldController fieldController = new FieldController();

    fieldController.landOnJail(testPlayer);
    boolean actual = true;

    assertEquals(actual,testPlayer.getIsInPrison());
 }
    *//**Test af ownedBySamePlayer*//*
    //positiv test
    // @Test
    // public void ownedBySamePlayerTest(){
    //     PlayerController playerController = new PlayerController();
    //     FieldController fieldController = new FieldController();
    //     playerController.createPlayers(2);
    //     Property prop1 = (Property) fieldController.getFields()[1];
    //     Property prop2 = (Property) fieldController.getFields()[2];
    //     prop1.setOwner("p1");
    //     prop2.setOwner("p1");
    //     playerController.getPlayerArray()[0].setFieldNumber(1);

    //     boolean actual = true;

    //     assertEquals(actual,fieldController.ownedBySamePlayer(playerController.getPlayerByName("p0"),prop1));
    // }
    @Test
    public void isJailCardWorks(){

        FieldController fieldController = new FieldController();
        PlayerController playerController = new PlayerController();
        playerController.createPlayers(2);
        Player testPlayer = playerController.getPlayerByName("p0");

        Jail jail = new Jail("testjail", 18, "test");

        testPlayer.bankAccount.setBalance(20);
        testPlayer.setJailCard(true);

        //testspiller lander på fængsel
        fieldController.landOnJail(testPlayer);

        //spiller lander på nyt felt
        fieldController.landOnProperty(testPlayer,playerController, (Property)fieldController.getFields()[10]);

        //Spiller lander på skatepark og køber for 2M
        int expected = 18;
        int actual = testPlayer.bankAccount.getBalance();
        assertEquals(actual,expected);
    }

    //test af om spiller betaler for at komme ud af fængsel
    @Test
    public void playerPayToGetOut(){

        FieldController fieldController = new FieldController();
        PlayerController playerController = new PlayerController();
        playerController.createPlayers(2);
        Player testPlayer = playerController.getPlayerByName("p0");

        Jail jail = new Jail("testjail", 18, "test");

        testPlayer.bankAccount.setBalance(20);

        //testspiller lander på fængsel
        fieldController.landOnJail(testPlayer);


        //spiller lander på nyt felt
        testPlayer.setFieldNumber(10);
        fieldController.landOnField(testPlayer,playerController, fieldController);

        //Spiller lander på skatepark og køber for 2M
        int expected = 17;
        int actual = testPlayer.bankAccount.getBalance();
        assertEquals(actual,expected);
    }



    //Test om owner bliver sat til true
    @Test
    public void buyPropertyOwnerTest() {
        FieldController FieldController = new FieldController();
        Property testProperty = new Property("Horsensgade", 2, 5, "test", "test");
        PlayerController playerController = new PlayerController();
        playerController.createPlayers(3);
        Player testPlayer = playerController.getPlayerByName("p0");
        testPlayer.bankAccount.setBalance(100);

        FieldController.buyProperty(testPlayer, playerController, testProperty);
        boolean actual = true;
        assertEquals(actual, testProperty.getOwnedByPlayer());
    }

    //test af om buyProperty opdaterer ownedByPlayer i Field
    @Test
    public void buyPropertyTest1() {
        Player testPlayer = new Player("testPerson");
        Property testProperty = new Property("Horsensgade", 2, 5, "test", "test");
        testProperty.setOwner(testPlayer.getPlayerName());
        testPlayer.bankAccount.subBalance(testProperty.getFieldPrice());

        boolean actual = true;
        assertEquals(actual, testProperty.getOwnedByPlayer());

    }

    //test af om buyProperty opdaterer playerID i Field
    @Test
    public void buyPropertyTest2() {
        Player testPlayer = new Player("testPerson");
        Property testProperty = new Property("Horsensgade", 2, 5, "test", "test");
        testProperty.setOwner(testPlayer.getPlayerName());
        testPlayer.bankAccount.subBalance(testProperty.getFieldPrice());

        String actual = "testPerson";
        assertEquals(actual, testProperty.getOwnerName());
    }

    *//**Test af buyProperty*//*
    //test af balance opdatering
    @Test
    public void buyPropertyBalanceUpdateTest() {
        FieldController FieldController = new FieldController();
        PlayerController testPlayerController = new PlayerController();
        Property testProperty = new Property("Horsensgade", 2, 5, "test", "test");
        //skaber 2 nye spillere i playerarray
        testPlayerController.createPlayers(2);
        testPlayerController.getPlayerByName("p0").bankAccount.setBalance(100);
        FieldController.buyProperty(testPlayerController.getPlayerByName("p0"), testPlayerController, testProperty);
        int actual = 95;
        assertEquals(actual, testPlayerController.getPlayerByName("p0").bankAccount.getBalance());
    }

    //test af om grundens ejer bliver opdateret
    @Test
    public void buyPropertyOwnerUpdateTest() {
        FieldController FieldController = new FieldController();
        PlayerController testPlayerController = new PlayerController();
        Property testProperty = new Property("Horsensgade", 2, 5, "test", "test");

        //skaber 2 nye spillere i playerarray
        testPlayerController.createPlayers(2);

        testPlayerController.getPlayerByName("p0").bankAccount.setBalance(100);

        FieldController.buyProperty(testPlayerController.getPlayerByName("p0"), testPlayerController, testProperty);

        String actual = "p0";
        assertEquals(actual, testProperty.getOwnerName());
    }

    *//*** Test af payRent*//*
    //Test af om payrent betaling bliver trukket fra spilleren der lander på et ejet felt
    @Test
    public void payRentTest(){
        FieldController FieldController = new FieldController();
        PlayerController testPlayerController = new PlayerController();
        Player testPlayer = new Player("testPerson");
        Property testProperty = new Property("Horsensgade", 2, 5, "test", "test");
        //skaber 2 nye spillere i playerarray
        testPlayerController.createPlayers(2);

        //sætter owner til p0, det samme som spilleren hedder efter kald på createPlayers ovenfor.
        testProperty.setOwner("p0");
        //setter begge spillers balance til 100
        testPlayer.bankAccount.setBalance(100);
        testPlayerController.getPlayerByName("p0").bankAccount.setBalance(100);

        FieldController.payRent(testPlayer, testPlayerController, testProperty);

        int actual = 95;
        assertEquals(actual, testPlayer.bankAccount.getBalance());
    }

    //Test af om payRent betaling går igennem til den modtagende spiller
    @Test
    public void recieveRentTest(){
        FieldController FieldController = new FieldController();
        PlayerController testPlayerController = new PlayerController();
        Player testPlayer = new Player("testPerson");
        Property testProperty = new Property("Horsensgade", 2,5,"test","test");

        //skaber 2 nye spillere i playerarray
        testPlayerController.createPlayers(2);

        //sætter owner til p0, det samme som spilleren hedder efter kald på createPlayers ovenfor.
        testProperty.setOwner("p0");
        //setter begge spillers balance til 100
        testPlayer.bankAccount.setBalance(100);
        testPlayerController.getPlayerByName("p0").bankAccount.setBalance(100);

        FieldController.payRent(testPlayer, testPlayerController, testProperty);

        int actual = 105;
        assertEquals(actual,testPlayerController.getPlayerByName("p0").bankAccount.getBalance());
    }

    //TODO metoden mangler at laves og testes
    *//**Sælge egendom for at payRent*//*


    *//**Test af setDoubleRent og removeDouble rent*//*
    @Test
    public void setDoubleRentTest(){
        Property testProperty = new Property("Horsensgade", 2,5,"test","test");
        testProperty.setDoubleRent();
        int actual = 10;
        assertEquals(actual, testProperty.getFieldRent());
    }

    @Test
    public void removeDoubleRentTest(){
        Property testProperty = new Property("Horsensgade", 2,5,"test","test");
        testProperty.setDoubleRent();
        testProperty.removeDoubleRent();
        int actual = 5;
        assertEquals(actual, testProperty.getFieldRent());
    }

    *//**Test af om setDoubleRent bliver kaldt når spiller køber 2. grund af samme farve*//*
    //test af om rent bliver dobbelt
    @Test
    public void buyPropertySetDoubleRentTest(){
        FieldController FieldController = new FieldController();
        PlayerController testPlayerController = new PlayerController();
        Property testProperty = new Property("testVej", 2,4,"test","blå");
        Property testProperty1 = new Property("testVej1", 2,4,"test","rød");
        Property testProperty2 = new Property("testVej2", 2,4,"test","gul");
        Property testProperty3 = new Property("testVej3", 2,4,"test","rød");

        //skaber 2 nye spillere i playerarray
        testPlayerController.createPlayers(2);

        FieldController.buyProperty(testPlayerController.getPlayerByName("p0"), testPlayerController,testProperty);
        FieldController.buyProperty(testPlayerController.getPlayerByName("p0"), testPlayerController,testProperty1);
        FieldController.buyProperty(testPlayerController.getPlayerByName("p0"), testPlayerController,testProperty2);
        FieldController.buyProperty(testPlayerController.getPlayerByName("p0"), testPlayerController,testProperty3);

        int actual = 8;
        assertEquals(actual,testProperty3.getFieldRent());
    }
*/

//    @Test
//    public void removePropertyOwnerTest(){
//        FieldController fieldController = new FieldController();
//        PlayerController playerController = new PlayerController();
//        GUIView guiView = new GUIView();
//        playerController.createPlayers(2);
//        Player p0 = playerController.getPlayerByName("p0");
//        Player p1 = playerController.getPlayerByName("p1");
//
//        fieldController.buyProperty(p0,playerController,((Property) fieldController.getFields()[1]),guiView);
//        fieldController.buyProperty(p0,playerController,((Property) fieldController.getFields()[2]),guiView);
//        System.out.println(((Property) fieldController.getFields()[2]).getFieldRent());
//        fieldController.removePropertyOwner(((Property) fieldController.getFields()[2]),p0);
//        int actual = 1;
//        assertEquals(actual,((Property) fieldController.getFields()[2]).getFieldRent());
//    }



    /** Test af at spillerens totale property værdi går fra 5 til 0*/
    @Test
    public void excactlyBankruptWhileSellPropertyTest(){
        Player player = new Player("gab");
        GUIView guiView= new GUIView();
        FieldController fieldController = new FieldController();
        Property testProperty = new Property("testVej1", 2,5,"test","rød");

        int pay = 5;

        testProperty.setOwner("gab");
        player.addPropertyOwned(testProperty);
        player.getBankAccount().setBalance(0);

        fieldController.sellProperty(player,pay,guiView);

        boolean actual = true;
        assertEquals(actual,player.getBankAccount().getBankrupt());
    }
}