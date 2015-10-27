package mikecoleman.threads;

/**
 * Created by Mike on 10/10/2015.
 * This program lets us create Threads by implementing the Runnable interface
 */
class ImplementsRunner implements Runnable {
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

public class ImplementsRunnablePractice {
    public static void main(String[] args) {
        /* Create instances of Thread class and pass instance of our ImplementsRunner class
         * created above into the Thread constructor
         */
        Thread t1 = new Thread(new ImplementsRunner());
        Thread t2 = new Thread(new ImplementsRunner());
        // Starts both Threads
        t1.start();
        t2.start();
    }
}
