package Adapter;

//А это несовместимый класс, хранящий две точки в системе координат WGS84 с возможностью определить расстояние между ними
//Его мы адаптируем.
public class Wgs84GeoLine {
    private double lat1;
    private double lon1;
    private double alt1;
    private double lat2;
    private double lon2;
    private double alt2;
    
    public Wgs84GeoLine(double lat1, double lon1, double alt1, double lat2, double lon2, double alt2) {
        this.lat1 = lat1;
        this.lon1 = lon1;
        this.alt1 = alt1;
        this.lat1 = lat2;
        this.lon1 = lon2;
        this.alt1 = alt2;
    }
    
    public double getDistance() {
        //В эти вычисления вникать не стоит...
        double lat1Rad = Math.toRadians(this.lat1);
        double lon1Rad = Math.toRadians(this.lon1);
        double lat2Rad = Math.toRadians(this.lat2);
        double lon2Rad = Math.toRadians(this.lon2);

        double deltaLat = lat2Rad - lat1Rad;
        double deltaLon = lon2Rad - lon1Rad;

        double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2) +
                   Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                   Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);
                   
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return 6371.0088/*радиус Земли*/ * c * 1000;
    }
}