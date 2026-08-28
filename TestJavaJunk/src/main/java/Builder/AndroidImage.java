package Builder;

//Класс описывает образ Андроида, т.е. драйверы каких модулей должны быть в нем, чтобы смартфон работал
//Оперативка и NAND используют общие драйверы, поэтому здесь не указаны
public class AndroidImage {
    private Cpu cpu;
    private Bluetooth bluetooth;
    private WiFi wifi;
    private Display display;    
    
    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }
    
    public void setBluetooth(Bluetooth btModule) {
        this.bluetooth = btModule;
    }
    
    public void setWifi(WiFi wifiModule) {
        this.wifi = wifiModule;
    }
    
    public void setDisplay(Display display) {
        this.display = display;
    }
}