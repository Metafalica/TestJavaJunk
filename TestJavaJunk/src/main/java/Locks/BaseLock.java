package Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class BaseLock {
    public void demonstrate() {
        Lock fileAccessLock = new ReentrantLock();
        Lock consoleAccessLock = new ReentrantLock();
        Runnables.ReadFileAction rfa = new Runnables.ReadFileAction("asd.txt");
        Runnables.ReadConsoleAction rca = new Runnables.ReadConsoleAction();
        Runnables.WriteFileAction wfa = new Runnables.WriteFileAction("dsa.txt", "qwe");
        
        new Thread(() -> { lockAndExecute(fileAccessLock, consoleAccessLock, rfa, () -> { System.out.println("File content is: " + rfa.getResult()); }); }, "Th1").start();
        new Thread(() -> { lockAndExecute(consoleAccessLock, fileAccessLock, rca, wfa); }, "Th2").start();
    }
    
    abstract void lockAndExecute(Lock outerLock, Lock innerLock, Runnable actionOnOuterLock, Runnable actionOnInnerLock);
}