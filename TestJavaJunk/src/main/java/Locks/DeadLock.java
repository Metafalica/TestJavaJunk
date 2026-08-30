package Locks;

import static java.lang.Thread.sleep;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {
    private Lock lock1;
    private Lock lock2;
    
    public DeadLock() {
        this.lock1 = new ReentrantLock(true);
        this.lock2 = new ReentrantLock(true);
    }
    
    public void demonstrate() {
        new Thread(() -> { this.operation1(); }, "Th1").start();
        new Thread(() -> { this.operation2(); }, "Th2").start();
    }
    
    public void operation1() {
        lock1.lock();
        System.out.println("lock1 acquired, acquiring lock2...");
        try {
            sleep(50);
        } catch (InterruptedException ex) {
            System.out.println(DeadLock.class.getName() + " --> operation1 --> sleep(50) --> " + ex);
        }

        lock2.lock();
        System.out.println("lock2 acquired");

        System.out.println("First operation done, releasing locks...");

        lock2.unlock();
        lock1.unlock();
    }

    public void operation2() {
        lock2.lock();
        System.out.println("lock2 acquired, acquiring lock1...");
        try {
            sleep(50);
        } catch (InterruptedException ex) {
            System.out.println(DeadLock.class.getName() + " --> operation2 --> sleep(50) --> " + ex);
        }

        lock1.lock();
        System.out.println("lock1 acquired");

        System.out.println("Second operation done, releasing locks...");

        lock1.unlock();
        lock2.unlock();
    }
}