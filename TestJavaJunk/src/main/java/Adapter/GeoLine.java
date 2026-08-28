package Adapter;

//"Сторонний" класс, хранящий две точки в системе координат Гаусса-Крюгера с возможностью определить расстояние между ними
public class GeoLine {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    
    public GeoLine(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
    }
    
    public double getDistance()
    {
        double deltaX = x2 - x1;
        double deltaY = y2 - y1;
        
        return Math.sqrt((deltaX * deltaX) + (deltaY * deltaY));
    }
}