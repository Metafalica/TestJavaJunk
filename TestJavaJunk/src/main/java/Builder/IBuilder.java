package Builder;

public interface IBuilder {
    void setCpu(Cpu cpu);
    void setRam(Ram ram);
    void setNand(NandMemory nand);
    void setBluetooth(Bluetooth btModule);
    void setWiFi(WiFi wifiModule);
    void setDisplay(Display display);
}