package Game;

public class BankAccount {

        //??
        private Field field;
        private Player player;
        private int balance = 1000;

        public BankAccount(Player player) {
                this.player = player;
        }

        //Balance skal hentes fra Field
        public int newBalance() {
                balance += field.getFieldValue();
                checkBalance3000();
                return balance;

        }

        public void checkBalance3000(){
                if (balance>=3000)
                        player.setPlayerWin();
        }
}
