package Game;

/**
 * BankAccount
 * @author Gruppe11
 */
public class BankAccount {

        private int balance;
        private boolean bankrupt = false;

        public void addBalance(int value) {
                balance += value;
        }

        public void subBalance(int value) {
                int balanceCheck = balance-=value;
                if(balanceCheck<0)
                        bankrupt=true;
                else if (balanceCheck>=0)
                balance -= value;
        }

        public void setBalance(int setValue) {
                balance = setValue;
        }

        public int getBalance() {
                return balance;
        }

        public boolean getBankrupt() { return bankrupt; }
}
