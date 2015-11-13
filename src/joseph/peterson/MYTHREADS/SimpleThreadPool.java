package joseph.peterson.mythreads;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Joseph on 11/6/2015.
 */
public class SimpleThreadPool {
    public static void main(String[] args) {
        Executor anExecutor = Executors.newCachedThreadPool();
        for(int threadCnt = 0; threadCnt < 3; threadCnt++){
            SimpleRunnable aSillyRunnable = new SimpleRunnable();
            anExecutor.execute(aSillyRunnable);
        }
        try {
            Thread.sleep(5000);
            System.out.println("Done Sleeping");
            for(int threadCnt = 0; threadCnt < 3; threadCnt++){
                SimpleRunnable aSimpleRunnable = new SimpleRunnable();
                anExecutor.execute(aSimpleRunnable);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
