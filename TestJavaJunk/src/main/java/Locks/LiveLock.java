package Locks;

import static java.lang.Thread.sleep;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LiveLock {
    private Lock lock1;
    private Lock lock2;
    
    public LiveLock() {
        this.lock1 = new ReentrantLock(true);
        this.lock2 = new ReentrantLock(true);
    }
    
    public void demonstrate() {
        new Thread(() -> { this.operation1(); }, "Th1").start();
        new Thread(() -> { this.operation2(); }, "Th2").start();
    }
    
    public void operation1() {
        while (true) {
            try {
                lock1.tryLock(50, TimeUnit.MILLISECONDS);
            } catch (InterruptedException ex) {
                System.out.println(LiveLock.class.getName() + " --> operation1 --> lock1.tryLock(50, TimeUnit.MILLISECONDS) --> " + ex);
            }
            System.out.println("lock1 acquired, acquiring lock2...");
            try {
                sleep(50);
            } catch (InterruptedException ex) {
                System.out.println(LiveLock.class.getName() + " --> operation1 --> sleep(50) --> " + ex);
            }

            if (lock2.tryLock()) {
                System.out.println("lock2 acquired.");
            } else {
                System.out.println("Cannot acquire lock2, releasing lock1.");
                lock1.unlock();
                continue;
            }

            System.out.println("First operation done, releasing locks...");
            break;
        }
        
        lock2.unlock();
        lock1.unlock();
    }

    public void operation2() {
        while (true) {
            try {
                lock2.tryLock(50, TimeUnit.MILLISECONDS);
            } catch (InterruptedException ex) {
                System.out.println(LiveLock.class.getName() + " --> operation1 --> lock2.tryLock(50, TimeUnit.MILLISECONDS) --> " + ex);
            }
            System.out.println("lock2 acquired, acquiring lock1...");
            try {
                sleep(50);
            } catch (InterruptedException ex) {
                System.out.println(LiveLock.class.getName() + " --> operation2 --> sleep(50) --> " + ex);
            }

            if (lock1.tryLock()) {
                System.out.println("lock1 acquired.");
            } else {
                System.out.println("Cannot acquire lock1, releasing lock2.");
                lock2.unlock();
                continue;
            }

            System.out.println("Second operation done, releasing locks...");
            break;
        }
        
        lock1.unlock();
        lock2.unlock();
    }
}