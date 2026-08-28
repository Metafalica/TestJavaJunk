package Builder;

public class Client {
    public void ConstructJunk() {
        Director director = new Director();
        SmartphoneBuilder spBuilder = new SmartphoneBuilder();
        director.BuildMotorolaX1Y2Z3(spBuilder);
        Smartphone readyDevice = spBuilder.getResult();

        AndroidImageBuilder aiBuilder = new AndroidImageBuilder();
        director.BuildMotorolaX1Y2Z3(aiBuilder);
        AndroidImage readyAndroidImage = aiBuilder.getResult();
    }
}