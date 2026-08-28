package Proxy;

import java.util.HashMap;
import java.util.Map;

public class Proxy implements CommonInterface {
    private RealObject realObj;
    private Map<String, Integer> addr2freq;

    public Proxy(RealObject realObj) {
        this.realObj = realObj;
        this.addr2freq = new HashMap<String, Integer>();
    }
    
    //Ведем счет обращений по разным адресам
    @Override
    public void makeRequestTo(String addr) {
        if (!this.addr2freq.containsKey(addr)) {
            this.addr2freq.put(addr, 0);
        }
        
        //Увеличиваем счетчик запросов к переданному адресу
        Integer currVal = this.addr2freq.get(addr);
        this.addr2freq.put(addr, currVal + 1);
        
        this.realObj.makeRequestTo(addr);
    }        
}