package Assignment9;

class BankAccount {
    final int accountNumber;
    String accountHolder;
    double balance;

    BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
}

public class BankAccountApp {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount(234567, "Vishrut Chinta", 130000.00);
        acc.display();

    }
}
