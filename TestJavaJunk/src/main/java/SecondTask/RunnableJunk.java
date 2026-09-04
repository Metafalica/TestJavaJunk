package SecondTask;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RunnableJunk implements Runnable {
    private static final Lock lock = new ReentrantLock(true);
    private static final AtomicInteger currValueToPrint = new AtomicInteger(1);
    
    private long liveMs;
    private final int valueToPrint;
   
    public RunnableJunk(int valueToPrint, long liveMs) {
        this.liveMs = liveMs;
        this.valueToPrint = valueToPrint;
    }
    
    @Override
    public void run() {
        long operationStartMs = System.currentTimeMillis();
        
        while(!Thread.currentThread().isInterrupted() && (liveMs == 0 || System.currentTimeMillis() - operationStartMs <= this.liveMs)) {
            if (RunnableJunk.lock.tryLock()) {
                if(RunnableJunk.currValueToPrint.compareAndSet(this.valueToPrint, (this.valueToPrint & 1) + 1)) {
                    System.out.println(this.valueToPrint);
                }
                
                RunnableJunk.lock.unlock();
            }
        }
    }    
}