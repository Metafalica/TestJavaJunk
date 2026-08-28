package ChainOfResponsibility;

public class Client {
    private BaseDns firstDns2Ask;
    
    public Client() {
        HostsDns node1 = new HostsDns();
        IspDns node2 = new IspDns();
        GoogleDns node3 = new GoogleDns();
        node1.setNext(node2);
        node2.setNext(node3);  
    }
    
    public int ask4Ip(String addr) {
        return this.firstDns2Ask.getIp(addr);
    }
}