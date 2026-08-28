package ChainOfResponsibility;

public class IspDns extends BaseDns {
    public IspDns() {
        this.knownHosts.put("host-known-by-isp.ru".toLowerCase(), 456);
    }  
}