package Game;

public class BankAccount {

        private final Field updateFieldValue = new Field();

        private int balance;
        public BankAccount(int balance,int fieldValue) {
        }
        public int newBalance(int balance, int FieldValue) {
            return balance += FieldValue;
        }


}

class test1 {
        public static void main(String[] args) {
                BankAccount b = new BankAccount(1000, 100);
                System.out.println(b.newBalance(1000,100));
        }
}
