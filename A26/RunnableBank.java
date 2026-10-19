// Exercise 2: Deposit and withdrawal tasks using Runnable
package A26;
class BankAccount {
    private int balance = 1000;

    synchronized void deposit(int amt) {
        balance += amt;
        System.out.println(Thread.currentThread().getName() + " deposited " + amt + " | Balance: " + balance);
    }

    synchronized void withdraw(int amt) {
        if (amt <= balance) {
            balance -= amt;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amt + " | Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " failed to withdraw " + amt
                    + " (insufficient) | Balance: " + balance);
        }
    }

    synchronized int getBalance() { return balance; }
}

class DepositTask implements Runnable {
    private final BankAccount acc;
    DepositTask(BankAccount acc) { this.acc = acc; }
    public void run() {
        for (int amt : new int[]{500, 250, 100}) {
            acc.deposit(amt);
            try { Thread.sleep(200); } catch (InterruptedException e) { }
        }
    }
}

class WithdrawTask implements Runnable {
    private final BankAccount acc;
    WithdrawTask(BankAccount acc) { this.acc = acc; }
    public void run() {
        for (int amt : new int[]{300, 1500, 200}) {
            acc.withdraw(amt);
            try { Thread.sleep(250); } catch (InterruptedException e) { }
        }
    }
}

public class RunnableBank {
    public static void main(String[] args) throws InterruptedException {
        BankAccount acc = new BankAccount();
        Thread t1 = new Thread(new DepositTask(acc), "Deposit-Thread");
        Thread t2 = new Thread(new WithdrawTask(acc), "Withdraw-Thread");
        t1.start(); t2.start();
        t1.join(); t2.join();
        System.out.println("Final balance = " + acc.getBalance());
    }
}
