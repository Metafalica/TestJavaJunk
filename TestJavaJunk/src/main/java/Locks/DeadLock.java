package Locks;

import java.util.concurrent.locks.Lock;

public class DeadLock extends BaseLock {    
    @Override
    void lockAndExecute(Lock outerLock, Lock innerLock, Runnable actionOnOuterLock, Runnable actionOnInnerLock) {
        System.out.println(Thread.currentThread().getName() + " --> Acquiring outer lock...");
        outerLock.lock();
                
        try {
            System.out.println(Thread.currentThread().getName() + " --> Executing action 1...");
            actionOnOuterLock.run();
            
            System.out.println(Thread.currentThread().getName() + " --> Acquiring inner lock...");
            innerLock.lock();
            
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
        }
        catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
        finally {
            outerLock.unlock();
        }
    }
    
    public static void main(String[] args) {
        DeadLock dl = new DeadLock();
        dl.demonstrate();       
    }   
}