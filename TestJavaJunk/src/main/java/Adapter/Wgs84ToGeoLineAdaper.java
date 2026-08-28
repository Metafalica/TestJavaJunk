package Adapter;

//Адаптация класса Wgs84GeoLine под GeoLine
public class Wgs84ToGeoLineAdaper extends GeoLine {
    private Wgs84GeoLine wgs84GeoLine;
    
    public Wgs84ToGeoLineAdaper(Wgs84GeoLine wgs84GeoLine) {
        super(0, 0, 0, 0); //все равно какие координаты будут у родителя, метод-то я перегружу
        this.wgs84GeoLine = wgs84GeoLine;
    }
    
    @Override
    public double getDistance() {
        return this.wgs84GeoLine.getDistance();
    }
}