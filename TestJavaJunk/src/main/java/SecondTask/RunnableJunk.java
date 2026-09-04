package SecondTask;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RunnableJunk implements Runnable {
    private static final Lock LOCK = new ReentrantLock();
    private static AtomicInteger currValueToPrint = new AtomicInteger(1);
    
    private long liveMs;
    private final int valueToPrint;
   
    public RunnableJunk(int valueToPrint, long liveMs) {
        this.liveMs = liveMs;
        this.valueToPrint = valueToPrint;
    }
    
    @Override
    public void run() {
        long operationStartMs = System.currentTimeMillis();
        
        while(!Thread.currentThread().isInterrupted() && (this.liveMs == 0 || System.currentTimeMillis() - operationStartMs <= this.liveMs)) {
            if (RunnableJunk.LOCK.tryLock()) {
                try {
                    if(RunnableJunk.currValueToPrint.compareAndSet(this.valueToPrint, (this.valueToPrint & 1) + 1)) {
                        System.out.println(this.valueToPrint);
                    }
                }
                catch(Exception exc) {
                    System.out.println(exc.getMessage());
                }
                finally {
                    RunnableJunk.LOCK.unlock();
                }
            }
        }
    }    
}