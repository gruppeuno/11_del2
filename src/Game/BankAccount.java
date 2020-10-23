package Game;

public class BankAccount {

        private Field field;
        private Player player;
        private int balance = 1000;

        public BankAccount(Player player) {
                this.player = player;
        }

        //Balance skal hentes fra Field
        public int newBalance() {
                return balance += field.getFieldValue();
        }

}
