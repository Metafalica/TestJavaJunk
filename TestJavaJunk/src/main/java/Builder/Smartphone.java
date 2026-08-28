package Builder;

public class Smartphone {
    private Cpu cpu;
    private Ram ram;
    private NandMemory nand;
    private Bluetooth bluetooth;
    private WiFi wifi;
    private Display display;
    
    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }
    
    public void setRam(Ram ram) {
        this.ram = ram;
    }
    
    public void setNand(NandMemory nand) {
        this.nand = nand;
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