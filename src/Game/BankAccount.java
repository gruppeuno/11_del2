package Game;

public class BankAccount {

        private MyFieldTest field;
        private Player player;

        private int balance;

        public BankAccount(Player p, int b1, MyFieldTest f) {
                field = f;
                player = p;
                balance = b1;
        }

        public int newBalance() {
                field.setMyFieldValue(player);
                return balance += field.getMyFieldValue();
        }


        public static void main(String[] args) {

                Player playerrolf = new Player("rolf");
                MyFieldTest test = new MyFieldTest();

                BankAccount b = new BankAccount(playerrolf, 1000, test);
                System.out.println(b.newBalance());
        }

}
