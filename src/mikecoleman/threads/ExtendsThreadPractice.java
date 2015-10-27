package mikecoleman.threads;

/**
 * Created by Mike on 10/25/2015.
 * This program is the oldest way to create Threads by extending the Thread class
 */
// Create a class to that extends the Thread class
class ThreadRunner extends Thread {
// Override the default run() method and insert code you want your Thread to compute
    @Override
    public void run() {
        for (int i = 0; i <= 100; i += 10) {
            System.out.println(i);
            try {
                // This slows the program down so we can see the Threads while they are running
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ExtendsThreadPractice {
    public static void main(String[] args) {
        // Creates two instances of our ThreadRunner class previously created and starts them both
        ThreadRunner thread1 = new ThreadRunner();
        thread1.start();

        ThreadRunner thread2 = new ThreadRunner();
        thread2.start();
    }
}






