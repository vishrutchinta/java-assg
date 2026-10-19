// Exercise 2: Bank transactions using Thread class (deposit thread + withdrawal thread)
package A25;
class Account {
    private int balance = 1000;

    synchronized void deposit(int amt) {
        balance += amt;
        System.out.println("[Deposit]    +" + amt + "  Balance = " + balance);
    }

    synchronized void withdraw(int amt) {
        if (amt <= balance) {
            balance -= amt;
            System.out.println("[Withdrawal] -" + amt + "  Balance = " + balance);
        } else {
            System.out.println("[Withdrawal] -" + amt + "  FAILED (insufficient funds), Balance = " + balance);
        }
    }

    synchronized int getBalance() { return balance; }
}

class DepositThread extends Thread {
    Account acc;
    DepositThread(Account a) { acc = a; setName("Deposit-Thread"); }
    public void run() {
        int[] amounts = {500, 200, 300, 100};
        for (int a : amounts) {
            acc.deposit(a);
            try { Thread.sleep(200); } catch (InterruptedException e) { }
        }
    }
}

class WithdrawThread extends Thread {
    Account acc;
    WithdrawThread(Account a) { acc = a; setName("Withdraw-Thread"); }
    public void run() {
        int[] amounts = {300, 400, 2000, 150};
        for (int a : amounts) {
            acc.withdraw(a);
            try { Thread.sleep(250); } catch (InterruptedException e) { }
        }
    }
}

public class BankThreads {
    public static void main(String[] args) throws InterruptedException {
        Account acc = new Account();
        Thread d = new DepositThread(acc);
        Thread w = new WithdrawThread(acc);
        System.out.println("Initial balance = " + acc.getBalance());
        System.out.println(d.getName() + " state: " + d.getState());   // NEW
        d.start(); w.start();
        d.join(); w.join();
        System.out.println(d.getName() + " state: " + d.getState());   // TERMINATED
        System.out.println("Final balance = " + acc.getBalance());
    }
}
