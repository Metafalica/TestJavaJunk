package Proxy;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RealObject implements CommonInterface {
    @Override
    public void makeRequestTo(String addr) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(addr))
        .build();
        
        try {
            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException ex) {
            System.getLogger(RealObject.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (InterruptedException ex) {
            System.getLogger(RealObject.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }    
}