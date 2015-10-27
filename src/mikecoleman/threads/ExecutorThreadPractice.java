package mikecoleman.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Mike on 10/26/2015.
 */

class Processor implements Runnable {
    private int id;

    public Processor(int id){
        this.id = id;
    }


    @Override
    public void run() {
        System.out.println("Starting " + id);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed " + id);
    }
}

public class ExecutorThreadPractice {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        for(int i = 0; i < 5; i++) {
            executor.submit(new Processor(i));
        }

        executor.shutdown();

        System.out.println("All tasks submitted");

        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All tasks completed");
    }
}
