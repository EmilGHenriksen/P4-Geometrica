package Other;

public class point {
    public point(double _x, double _y) {
        x = _x;
        y = _y;
    }

    public point(point p) {
        x = p.x;
        y = p.y;
    }

    public double x;
    public double y;

    public void move(double _x, double _y) {
        x += _x;
        y += _y;
    }
}
