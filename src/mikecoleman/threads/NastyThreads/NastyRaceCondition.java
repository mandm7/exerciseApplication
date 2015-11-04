package mikecoleman.threads.NastyThreads;

/**
 * Created by Mike on 10/30/2015.
 * This is a demonstration of a NastyPath called a "race condition" that can occur within MultiThreading in Java.
 * Race conditions occur when there are two or more threads acting on the same Object when that object has multiple
 * steps in its processing such as the example below of an incrementor. The increment process being getting
 */

public class NastyRaceCondition {
    public static void main(String[] args) throws InterruptedException {
        // Create instance of the ThisCounter class
        MyCounter counter = new MyCounter();

        /* Create instances of Thread class and pass instance of our SimpleRunner class
           created below into the Thread constructor */
        Thread t1 = new Thread(new RaceCondition(counter));
        Thread t2 = new Thread(new RaceCondition(counter));

        // Starts both Threads
        t1.start();
        t2.start();
        // Allows Threads t1 & t2 to finish before main thread finishes
        t1.join();
        t2.join();
        // Print value of our counter variable
        System.out.println(counter.value());
    }
}

class RaceCondition implements Runnable {
    private MyCounter counter;
    // Creates a constructor that takes parameters of MyCounter class and the counter variable
    public RaceCondition(MyCounter counter) {
        this.counter = counter;
    }
    // Method for our threads to run 1000 times and call the increment()method
    public void run() {
        for ( int i=0; i<1000; i++ ) {
            counter.increment();
        }
    }
}


class MyCounter {
    // Declare an int variable c to be used as a counter
    private int c = 0;
    // Simple method to increment our c counter variable. ***Change public to synchronized to fix the race condition***
    public void increment() {
        c++;
    }
    // Return the value of c, this will be referenced once the threads have finished running
    public int value() {
        return c;
    }
}