package Game;

/**
 * BankAccount
 * @author Gruppe11
 */
public class BankAccount {

        private int balance;
        private boolean bankrupt = false;
        private int propertyValue;

        public void addBalance(int value) {
                balance += value;
        }

        public void subBalance(int value) {
                balance -= value;
        }

        public void setBankrupt(boolean bankrupt) { this.bankrupt = bankrupt; }
        public void setBalance(int setValue) { balance = setValue; }
        public int getBalance() { return balance; }
        public boolean getBankrupt() { return bankrupt; }
        public int getPropertyValue() { return propertyValue; }
        public void setPropertyValue(int propertyValue) { this.propertyValue = propertyValue; }
        public void addPropertyValue(int propertyValue) { this.propertyValue += propertyValue; }
}
