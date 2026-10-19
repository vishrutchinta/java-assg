// Exercise 1: Two tasks running simultaneously using Runnable
package A26;
class PrintNumbers implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Task 1 (numbers): " + i);
            try { Thread.sleep(300); } catch (InterruptedException e) { }
        }
    }
}

class PrintLetters implements Runnable {
    public void run() {
        for (char c = 'A'; c <= 'E'; c++) {
            System.out.println("Task 2 (letters): " + c);
            try { Thread.sleep(300); } catch (InterruptedException e) { }
        }
    }
}

public class RunnableTasks {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new PrintNumbers(), "NumbersThread");
        Thread t2 = new Thread(new PrintLetters(), "LettersThread");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Both tasks completed.");
    }
}
