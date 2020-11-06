package Game;

/**
 * BankAccount
 * @author Gruppe11
 */
public class BankAccount {

        private int balance;

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
