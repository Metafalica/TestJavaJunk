package Builder;

public class SmartphoneBuilder implements IBuilder {
    private Cpu cpu;
    private Ram ram;
    private NandMemory nand;
    private Bluetooth bluetooth;
    private WiFi wifi;
    private Display display;
    
    @Override
    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    @Override
    public void setRam(Ram ram) {
        this.ram = ram;
    }

    @Override
    public void setNand(NandMemory nand) {
        this.nand = nand;
    }

    @Override
    public void setBluetooth(Bluetooth btModule) {
        this.bluetooth = btModule;
    }

    @Override
    public void setWiFi(WiFi wifiModule) {
        this.wifi = wifiModule;
    }

    @Override
    public void setDisplay(Display display) {
        this.display = display;
    }    
    
    public Smartphone getResult() {
        Smartphone sp = new Smartphone();
        sp.setCpu(this.cpu);
        sp.setRam(this.ram);
        sp.setNand(this.nand);
        sp.setBluetooth(this.bluetooth);
        sp.setWifi(this.wifi);
        sp.setDisplay(this.display);
                
        return sp;
    }
}