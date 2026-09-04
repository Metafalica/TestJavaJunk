package Locks;

import java.util.concurrent.locks.Lock;

public class LiveLock extends BaseLock {       
    @Override
    void lockAndExecute(Lock outerLock, Lock innerLock, Runnable actionOnOuterLock, Runnable actionOnInnerLock) {
        System.out.println(Thread.currentThread().getName() + " --> Acquiring outer lock...");
        outerLock.lock();
                
        try {
            System.out.println(Thread.currentThread().getName() + " --> Executing action 1...");
            actionOnOuterLock.run();
            
            while(true) {
                System.out.println(Thread.currentThread().getName() + " --> Acquiring inner lock...");
                
                if (innerLock.tryLock()) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " --> Executing action 2...");
                        actionOnInnerLock.run();
                    }
                    catch(Exception exc) {
                        System.out.println(exc.getMessage());
                    }
                    finally {
                        innerLock.unlock();
                    }
                    
                    break;
                }
            }            
        }
        catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
        finally {
            outerLock.unlock();
        }
    }
    
    public static void main(String[] args) {
        LiveLock ll = new LiveLock();
        ll.demonstrate();
    }
}