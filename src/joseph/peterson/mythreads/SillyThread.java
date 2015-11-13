package joseph.peterson.mythreads;

/**
 * Created by Joseph on 11/6/2015.
 */
public class SillyThread extends Thread{
    //Why must we always override the interfaces methods?
    //which is best, runnable or threadpool?
    public void run(){
        for (int i = 0; i < 3; i++) {
            System.out.println("Thread id: "
                    +Thread.currentThread().getName());
            try {
                //the less the sleep number, the faster the threads run.
                Thread.currentThread().sleep(100);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    //this creates three threads
    public static void main(String[] args){
        for (int threadCnt = 0; threadCnt < 5; threadCnt++) {
            SillyThread aSillyThread = new SillyThread();
            aSillyThread.start();
        }
    }
}
