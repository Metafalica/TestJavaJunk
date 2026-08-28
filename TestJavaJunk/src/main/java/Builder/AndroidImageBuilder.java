package Builder;

public class AndroidImageBuilder implements IBuilder {
    private Cpu cpu;
    private Bluetooth bluetooth;
    private WiFi wifi;
    private Display display;
    
    @Override
    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    @Override
    public void setRam(Ram ram) {
        System.out.println("RAM module isn't matter for Android image.");
    }

    @Override
    public void setNand(NandMemory nand) {
        System.out.println("NAND module isn't matter for Android image.");
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
    
    public AndroidImage getResult() {
        AndroidImage ai = new AndroidImage();
        ai.setCpu(this.cpu);
        ai.setBluetooth(this.bluetooth);
        ai.setWifi(this.wifi);
        ai.setDisplay(this.display);
                
        return ai;
    }
}