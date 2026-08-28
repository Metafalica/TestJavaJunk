package Proxy;

public class ClientUsage {
    public void DoSomething() {
        Client client = new Client();            
        RealObject realObj = new RealObject();
        client.makeRequest(realObj); //напрямую

        Proxy proxy = new Proxy(realObj);
        client.makeRequest(proxy); //через прокси
    }
}