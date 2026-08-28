package ChainOfResponsibility;

public class HostsDns extends BaseDns {
    public HostsDns() {
        //"Читаем" локальный hosts файл и добавляем хосты в список
        //...
        this.knownHosts.put("host-stored-in-hosts-file.ru".toLowerCase(), 132);
    }    
}