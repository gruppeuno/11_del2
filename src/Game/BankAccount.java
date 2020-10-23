package Game;

public class BankAccount {

        private Field field;
        private Player player;
        private int balance = 1000;
        private String accountName;

        public BankAccount(Player player) {
                this.player = player;
        }

        //Balance skal hentes fra Field
        public int newBalance() {
                field.getPoints(player);
                return balance += field.getMyFieldValue();
        }

        //Account name hvis vi vil bruge
        /*
        private void setAccountName(Player player){
                accountName=player.getPlayerName() + "123Account";
        }
        */

        public static void main(String[] args) {

                Player playerrolf = new Player("rolf");
                MyFieldTest test = new MyFieldTest();

                BankAccount b = new BankAccount(playerrolf);
                System.out.println(b.newBalance());
        }

}
