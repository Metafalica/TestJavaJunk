package Proxy;

public class Client {
    public void makeRequest(CommonInterface ci) {
        ci.makeRequestTo("http://test.ru/api/v1/asd/dsa");
    }
}