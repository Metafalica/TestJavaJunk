package Decorator;

import java.util.LinkedList;
import java.util.List;

public class Client {
    public void DoSomething() {
        List<Integer> lst = new LinkedList<Integer>();
        lst.add(1);
        lst.add(-6);
        lst.add(0);
        lst.add(5);
        lst.add(8);
        lst.add(2);
        
        BaseDecorator bd = new ZeroFreeCollectionWriter(new OrderedCollectionWriter(new SimpleCollectionWriter()));
        bd.write(lst, "lst.txt");
    }
}