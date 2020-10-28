package Game;

public class BankAccount {

        private final Player player;
        private int balance = 1000;

        public BankAccount(Player player) {
                this.player = player;
        }

        //Balance skal hentes fra Field
        public void updateBalance(int value) {
                int balanceMIN = balance + value;
                if (balanceMIN>=0)
                balance += value;
                else if (balanceMIN<0){
                        balance = 0;
                }
                checkBalance3000();
        }

        public void checkBalance3000(){
                if (balance>=3000)
                        player.setPlayerWin();
        }

        public int getBalance() {
                return balance;
        }
}
