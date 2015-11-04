package mikecoleman.threads.happyThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Mike on 10/26/2015.
 * This way of Threading uses the Executors and ExecutorService interfaces to handle multithreading.
 * This is the newest way to multithread in java
 * This is a good way to handle multithreading because you create a pool of threads to be used and reused as necessary.
 */

class Task implements Runnable {
    // Create variable id for us to track a task
    private int id;
    // Constructor of Task that takes id as a parameter
    public Task(int id){
        this.id = id;
    }

    // Override the run() method with logic we want our Threads to run
    @Override
    public void run() {
        System.out.println("Started " + id);
        try {
            // Slow our thread down so we can see the results better in the console
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed " + id);
    }
}

public class ExecutorServicePractice {
    public static void main(String[] args) {
        // Create a ThreadPool of 2 threads to be reused in our program
        ExecutorService executor = Executors.newFixedThreadPool(2);
        // For loop for threads to work on 5 times taking parameter of our Task run method
        for(int i = 0; i < 5; i++) {
            executor.submit(new Task(i));
        }
    }
}
