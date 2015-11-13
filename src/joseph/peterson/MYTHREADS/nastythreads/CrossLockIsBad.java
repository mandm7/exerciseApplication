package joseph.peterson.mythreads.nastythreads;

/**
 * Created by Joseph on 11/6/2015.
 */
//cross lock is a dead lock. Same thing. Look up dead lock online.
public class CrossLockIsBad {
    public static void main(String args[]) {
        // Create two instances of our NastyCrossLock class to be accessed from our two Runnables
        CrossLockIsBad object1 = new CrossLockIsBad();
        CrossLockIsBad object2 = new CrossLockIsBad();

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
                        System.out.println("Runner2 is awake and will attempt to acquire lock for object1");
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
