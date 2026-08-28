package ChainOfResponsibility;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseDns {
    private BaseDns next;
    protected Map<String, Integer> knownHosts;
    
    public BaseDns() {
        this.knownHosts = new HashMap<String, Integer>();
    }
    
    public int getIp(String addr) {
        if (addr != null && this.knownHosts.containsKey(addr.toLowerCase())) {
            return this.knownHosts.get(addr);
        }
        else {
            return getIpFromNext(addr);
        }
    }   
    
    public int getIpFromNext(String addr) {
        if (this.next == null) {
            return 0;
        }
        else {
            return this.next.getIp(addr);
        }
    }
    
    public void setNext(BaseDns next) {
        this.next = next;
    }
}