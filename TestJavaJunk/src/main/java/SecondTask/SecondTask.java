package SecondTask;

public class SecondTask {    
    public void demonstrate() {
        RunnableJunk rj1 = new RunnableJunk(1, 6000);
        RunnableJunk rj2 = new RunnableJunk(2, 6000);
        Thread thread1 = new Thread(rj1);
        Thread thread2 = new Thread(rj2);
        
        thread2.start();
        thread1.start();
    }
}