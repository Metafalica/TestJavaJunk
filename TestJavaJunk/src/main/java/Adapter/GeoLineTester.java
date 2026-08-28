package Adapter;

//"Сторонний" класс, который сверяет длину переданной линии со своим лимитом.
public class GeoLineTester {
    private double distanceLimit;
    
    public GeoLineTester(double dstLimit) {
        this.distanceLimit = dstLimit;
    }
    
    public boolean isGeoLineFits(GeoLine geoLine) {
        if (geoLine == null) {
            return false;
        }
        
        return geoLine.getDistance() <= this.distanceLimit;
    }
}