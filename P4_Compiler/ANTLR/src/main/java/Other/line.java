package Other;

public class line {
    public line(point _A, point _B) {
        A = _A;
        B = _B;
    }

    public line(line l) {
        A = l.A;
        B = l.B;
    }

    public point A;
    public point B;

    public void move(double _x, double _y) {
        A.move(_x, _y);
        B.move(_x, _y);
    }
}
