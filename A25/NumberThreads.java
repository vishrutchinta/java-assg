// Exercise 1: Multiple threads printing numbers simultaneously (extends Thread)
package A25;
class NumberPrinter extends Thread {
    NumberPrinter(String name) { super(name); }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " prints " + i);
            try { Thread.sleep(300); } catch (InterruptedException e) { return; }
        }
    }
}

public class NumberThreads {
    public static void main(String[] args) throws InterruptedException {
        NumberPrinter t1 = new NumberPrinter("Thread-A");
        NumberPrinter t2 = new NumberPrinter("Thread-B");
        NumberPrinter t3 = new NumberPrinter("Thread-C");

        // Lifecycle demonstration
        System.out.println("State after creation : " + t1.getState());   // NEW
        t1.start(); t2.start(); t3.start();
        System.out.println("State after start()  : " + t1.getState());   // RUNNABLE
        Thread.sleep(100);
        System.out.println("State during sleep   : " + t1.getState());   // TIMED_WAITING
        t1.join(); t2.join(); t3.join();
        System.out.println("State after finish   : " + t1.getState());   // TERMINATED
        System.out.println("Main thread finished.");
    }
}
