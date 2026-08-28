package Adapter;

public class ClientCode {
    public void DoSomething() {
        GeoLineTester glt = new GeoLineTester(1000); //лимит в 1 км
        
        GeoLine gl1 = new GeoLine(12, 34, 56, 78);
        boolean test1 = glt.isGeoLineFits(gl1);
        Wgs84GeoLine wgs84gl = new Wgs84GeoLine(40.7128, -74.0060, 0, 34.0522, -118.2437, 0);
        Wgs84ToGeoLineAdaper wgs84ToGkAdaper = new Wgs84ToGeoLineAdaper(wgs84gl);
        boolean test2 = glt.isGeoLineFits(wgs84ToGkAdaper); //тоже сработает.
    }
}