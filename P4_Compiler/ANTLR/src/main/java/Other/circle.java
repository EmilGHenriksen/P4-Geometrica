package Other;

public class circle {
    public circle(point _center, double _radius) {
        center = _center;
        radius = _radius;
    }

    public circle(circle c) {
        center = c.center;
        radius = c.radius;
    }

    public point center;
    public double radius;

    public void move(double _x, double _y) {
        center.move(_x, _y);
    }
}
