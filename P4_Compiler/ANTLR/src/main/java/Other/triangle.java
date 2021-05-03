package Other;

public class triangle {
    public triangle(point _A, point _B, point _C) {
        A = _A;
        B = _B;
        C = _C;
    }

    public triangle(triangle t) {
        A = t.A;
        B = t.B;
        C = t.C;
    }

    public point A;
    public point B;
    public point C;

    public void move(double _x, double _y) {
        A.move(_x, _y);
        B.move(_x, _y);
        C.move(_x, _y);
    }
}
