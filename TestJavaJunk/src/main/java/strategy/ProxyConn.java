package strategy;

class ProxyConn implements IConnMaker {
    @Override
    public boolean establishConnectionTo(String addr) {
        System.out.println("Proxy connection established");
        return true;
    }
}