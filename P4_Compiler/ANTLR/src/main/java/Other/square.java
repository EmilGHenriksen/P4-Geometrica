package Other;

public class square {
    public square(point _A, point _B, point _C, point _D) {
        A = _A;
        B = _B;
        C = _C;
        D = _D;
    }

    public square(square s) {
        A = s.A;
        B = s.B;
        C = s.C;
        D = s.D;
    }

    public point A;
    public point B;
    public point C;
    public point D;

    public void move(double _x, double _y) {
        A.move(_x, _y);
        B.move(_x, _y);
        C.move(_x, _y);
        D.move(_x, _y);
    }
}
