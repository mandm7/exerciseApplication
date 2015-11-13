package joseph.peterson.mythreads;

/**
 * Created by Joseph on 11/2/2015.
 */
public class SubclassThreads extends Thread {

  public void run(){
            for (int i = 0; i < 3; i++) {
                System.out.println("Thread id: "
                        +Thread.currentThread().getName());
                try {
                    Thread.currentThread().sleep(100);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        public static void main(String[] args){
            for (int threadCnt = 0; threadCnt < 3; threadCnt++) {
                SubclassThreads aSillyThread = new SubclassThreads();
                aSillyThread.start();
            }
        }
    }

