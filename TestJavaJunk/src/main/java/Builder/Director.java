package Builder;

public class Director {
    public void BuildMotorolaX1Y2Z3(IBuilder builder) {
        builder.setCpu(Cpu.Snapdragon_8_Elite_Gen_5);
        builder.setRam(Ram.Gb_8);
        builder.setNand(NandMemory.Samsung_256);
        builder.setBluetooth(Bluetooth.MK01_nRF52832);
        builder.setWiFi(WiFi.MT7681);
        builder.setDisplay(Display.AMOLED);
    }
    
    public void BuildAcerLiquidZestZ628Plus(IBuilder builder) {
        builder.setCpu(Cpu.Dimensity_9500M);
        builder.setRam(Ram.GB_2);
        builder.setNand(NandMemory.Samsung_128);
        builder.setBluetooth(Bluetooth.MK05_nRF52810);
        builder.setWiFi(WiFi.MT7687);
        builder.setDisplay(Display.IPS);
    }
}