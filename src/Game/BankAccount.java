package Game;

/**
 * BankAccount
 * @author Gruppe11
 */
public class BankAccount {

        private final Player player;
        private int balance = 1000;

        /**
         * Tildeler en BankAccount til en spiller
         * @param player
         */
        public BankAccount(Player player) {
                this.player = player;
        }

        /**
         * Updaterer spillerens balance
         * Sikrer at spilleren ikke kan have en balance på under 0
         * @param value
         */
        //Balance skal hentes fra Field
        public void updateBalance(int value) {
                int balanceMIN = balance + value;
                if (balanceMIN>=0)
                balance += value;
                else if (balanceMIN<0){
                        balance = 0;
                }
        }

        /**
         * Checker om spilleren har en balance på 3000 eller derovre, hvis ja setPlayerWin
         */

        public int getBalance() {
                return balance;
        }

}
