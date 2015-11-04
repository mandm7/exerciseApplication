package mikecoleman.threads.happyThreads;

/**
 * Created by Mike on 10/25/2015.
 * This program is the oldest way to create Threads by extending the Thread class
 * We do not use this method of creating threads anymore. We should be implementing Runnable.
 */

// Create a class that extends the Thread class which will be used for happy paths
class HappyThreadRunner extends Thread {
    // Override the default run() method and insert code you want your Thread to compute
    @Override
    public void run() {
        for (int i = 0; i <= 100; i += 10) {
            System.out.println(i);
            try {
                // This slows the program down so we can see the Threads while they are running
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ExtendsThreadPractice {
    public static void main(String[] args) {
        // Creates two instances of our NastyThreadRunner class previously created and starts them both
        HappyThreadRunner thread1 = new HappyThreadRunner();
        thread1.start();

        HappyThreadRunner thread2 = new HappyThreadRunner();
        thread2.start();
    }
}






