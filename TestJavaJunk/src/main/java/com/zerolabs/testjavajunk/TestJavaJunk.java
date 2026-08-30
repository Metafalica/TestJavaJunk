package com.zerolabs.testjavajunk;

import Locks.DeadLock;
import Locks.LiveLock;
import SecondTask.SecondTask;

public class TestJavaJunk {

    public static void main(String[] args) {
        //DeadLock dl = new DeadLock();
        //dl.demonstrate();
        
        //LiveLock ll = new LiveLock();
        //ll.demonstrate();
        
        SecondTask st = new SecondTask();
        st.demonstrate();
    }
}