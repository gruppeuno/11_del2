package Game;

public class BankAccount {

        private Player player;
        private int balance = 1000;

        public BankAccount(Player player) {
                this.player = player;
        }

        //Balance skal hentes fra Field
        public int newBalance(int value) {
                balance += value;
                checkBalance3000();
                //return balance;

                return balance;
        }

        public void checkBalance3000(){
                if (balance>=3000)
                        player.setPlayerWin();
        }

        public int getBalance() {
                return balance;
        }
}
