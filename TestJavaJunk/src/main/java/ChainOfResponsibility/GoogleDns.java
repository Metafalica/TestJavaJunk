package ChainOfResponsibility;

public class GoogleDns extends BaseDns {
    public GoogleDns() {
        this.knownHosts.put("youtube.com".toLowerCase(), 789);
    }  
}