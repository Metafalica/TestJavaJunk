package SecondTask;

public class SecondTask {    
    public void demonstrate() {
        RunnableJunk rj1 = new RunnableJunk(1, 0);
        RunnableJunk rj2 = new RunnableJunk(2, 0);
        Thread thread1 = new Thread(rj1);
        Thread thread2 = new Thread(rj2);
        
        thread2.start();
        thread1.start();
    }
    
    public static void main(String[] args) {
        SecondTask st = new SecondTask();
        st.demonstrate();
    }
}