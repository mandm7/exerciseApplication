package mikecoleman.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Mike on 10/26/2015.
 * This way of Threading uses the Executors and ExecutorService interfaces to handle multithreading.
 * This is the newest way to multithread in java
 * This is a good way to handle multithreading because you create a pool of threads to be used and reused as necessary.
 */

class Processor implements Runnable {
    // Create variable id for us to track a process task
    private int id;
    // Constructor of Processor that takes id as a parameter
    public Processor(int id){
        this.id = id;
    }

    // Override the run() method with logic we want our Threads to run
    @Override
    public void run() {
        System.out.println("Starting " + id);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed " + id);
    }
}

public class ExecutorThreadPractice {
    public static void main(String[] args) {
        // Create a ThreadPool of 2 threads to be reused in our program
        ExecutorService executor = Executors.newFixedThreadPool(2);
        // For loop for threads to work on 5 times taking parameter of our Processor run method
        for(int i = 0; i < 5; i++) {
            executor.submit(new Processor(i));
        }
        // Allows completion of submitted tasks by threads but rejects new tasks from being accepted
        executor.shutdown();

        System.out.println("All tasks submitted");
        // Waits until all tasks have completed after shutdown request
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Prints once all tasks are completed by threads
        System.out.println("All tasks completed");
    }
}
