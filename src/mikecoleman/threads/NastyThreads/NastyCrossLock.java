package mikecoleman.threads.NastyThreads;

/**
 * Created by Mike on 11/3/2015.
 * This program is a Nasty path example demonstrating a crosslock or deadlock in java multithreading.
 * This occurs when you have two threads trying to gain access to a shared resource and end up having
 * to wait on each other. This "crossing paths" causing the program to essentially freeze or pause as it
 * cannot complete while one thread is waiting on the other and vice versa.
 * The fix to this particular code so that we do not have a crosslock is simply to switch the order of
 * obtaining the locks on the two objects, for example, running synchronized on object 1, then object2
 * in our Runner2.
 */
public class NastyCrossLock  {
    public static void main(String args[]) {
        // Create two instances of our NastyCrossLock class to be accessed from our two Runnables
        NastyCrossLock object1 = new NastyCrossLock();
        NastyCrossLock object2 = new NastyCrossLock();

        // Create Runnable Runner1
        Runnable Runner1 = new Runnable() {
            @Override
            public void run() {
                try {
                    // Use synchronized to prevent concurrent access to object1 from multiple threads
                    synchronized (object1) {
                        System.out.println("Runner1 has lock on object1 and will sleep");
                        Thread.sleep(100);
                        System.out.println("Runner1 is awake and will attempt to acquire lock for object2");
                        // Attempts to gain lock on object2
                        synchronized (object2) {
                            Thread.sleep(100);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        // Create Runnable Runner2
        Runnable Runner2 = new Runnable() {
            @Override
            public void run() {
                try {
                    // Use synchronized to prevent concurrent access to object2 from multiple threads
                    synchronized (object2) {
                        System.out.println("Runner2 has lock on object2 and will sleep");
                        Thread.sleep(100);
                        System.out.println("Runner2 is awake and will acquire to acquire lock for object1");
                        // Attempts to gain lock on object1
                        synchronized (object1) {
                            Thread.sleep(100);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        // Creates threads for both Runners and starts them
        new Thread(Runner1).start();
        new Thread(Runner2).start();
    }
}