package joseph.peterson.mythreads.nastythreads;

/**
 * Created by Joseph on 11/6/2015.
 */
public class NullThreadIsBad {
    public static void main(String[] args) throws InterruptedException {
        // Create instance of the ThisCounter class
        ThisCounter counter = new ThisCounter();

        /* Create instances of Thread class and pass a null into Thread t1 and
           an instance of our SimpleRunner class created below into the Thread constructor.
           The null will throw a NullPointerException*/
        Thread t1 = new Thread(new SimpleRunner(null));
        Thread t2 = new Thread(new SimpleRunner(counter));

        // Starts both Threads
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.value());
    }
}

class SimpleRunner implements Runnable {
    private ThisCounter counter;

    public SimpleRunner(ThisCounter counter) {
        this.counter = counter;
    }

    public void run() {
        for ( int i=0; i<1000; i++ ) {
            counter.increment();
        }
    }
}


class ThisCounter {
    private int c = 0;
    // Change public to synchronized to fix the race condition
    public void increment() {
        c++;
    }

    public  int value() {
        return c;
    }
}

