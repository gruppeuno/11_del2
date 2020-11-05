package Game;

/**
 * BankAccount
 * @author Gruppe11
 */
public class BankAccount {

        private int balance = 20;

        /**
         * Updaterer spillerens balance
         * Sikrer at spilleren ikke kan have en balance på under 0
         * @param value holds value
         */
        //Balance skal hentes fra Field
        public void updateBalance(int value) {
                int balanceMIN = balance - value;
                if (balanceMIN>=0)
                balance += value;
                else {
                        balance = 0;
                }
        }

        /**
         * Checker om spilleren har en balance på 3000 eller derovre, hvis ja setPlayerWin
         */

        public void addBalance(int value) {
                balance += value;
        }

        public void subBalance(int value) {
                balance -= value;
        }

        public void setBalance(int setValue) {
                balance = setValue;
        }

        public int getBalance() {
                return balance;
        }

}
