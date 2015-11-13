package joseph.peterson.mythreads;

/**
 * Created by Joseph on 11/6/2015.
 */
public class SimpleRunnableStarter{
    public static void main(String[] args){
        for (int threadCnt = 0; threadCnt < 3; threadCnt++) {
            SimpleRunnable aSimpleRunnable = new SimpleRunnable();
            Thread aSimpleThread = new Thread(aSimpleRunnable);
            aSimpleThread.start();
        }
    }
}
