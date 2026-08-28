package strategy;

public class StrategyContext {
    private IConnMaker connMaker;    
    
    public void setConnectionType(IConnMaker connMaker) {
        this.connMaker = connMaker;
    }
    
    public boolean establishConnectionTo(String addr) {
        if (this.connMaker == null) {
            System.out.println("Connection strategy isn't chosen. Use setConnectionType method!");
            return false;
        }
        
        return this.connMaker.establishConnectionTo(addr);
    }    
}