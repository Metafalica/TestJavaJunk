package strategy;

public class Client {
    public Client() {
        
    }
    
    public void visitSomething() {
        StrategyContext sc = new StrategyContext();
        
        //Сначала клиент захочет посетить что-то, что он знает, что доступно без прокси
        sc.setConnectionType(new DirectConn());
        sc.establishConnectionTo("https://rt.ru");
        
        //а затем он захочет посетить что-то запрещенное
        sc.setConnectionType(new ProxyConn());
        sc.establishConnectionTo("https://telegram.org");
    }
}