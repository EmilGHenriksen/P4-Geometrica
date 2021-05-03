package Other;

import javax.swing.*;
import java.awt.*;
import java.util.List;

//---default classes---
public class Drawing extends Canvas implements IDrawing {
    public Drawing() {
        frame = new JFrame("Geometrica");
        this.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(this);
        frame.pack();
        pixelsPerUnit = 10;
        pointSize = 3;
    }
    public JFrame frame;
    final double pixelsPerUnit;
    final double pointSize;
    public Graphics g;


    public void draw(point toDraw) {
        int x = (int) (toDraw.x * pixelsPerUnit);
        int y = (int) (toDraw.y * pixelsPerUnit);
        int width = (int)pointSize;
        g.drawRect(x,y, width, width);
    }

    public void draw(line toDraw) {
        int Ax = (int) (toDraw.A.x * pixelsPerUnit);
        int Ay = (int) (toDraw.A.y * pixelsPerUnit);
        int Bx = (int) (toDraw.B.x * pixelsPerUnit);
        int By = (int) (toDraw.B.y * pixelsPerUnit);
        g.drawLine(Ax, Ay, Bx, By);
        repaint();
    }

    public void draw(circle toDraw) {
        int x = (int) (toDraw.center.x * pixelsPerUnit);
        int y = (int) (toDraw.center.y * pixelsPerUnit);
        int diameter = (int) (toDraw.radius * pixelsPerUnit * 2);
        g.drawOval(x, y, diameter, diameter);
        repaint();
    }

    public void draw(triangle toDraw) {
        int Ax = (int) (toDraw.A.x * pixelsPerUnit);
        int Ay = (int) (toDraw.A.y * pixelsPerUnit);
        int Bx = (int) (toDraw.B.x * pixelsPerUnit);
        int By = (int) (toDraw.B.y * pixelsPerUnit);
        int Cx = (int) (toDraw.C.x * pixelsPerUnit);
        int Cy = (int) (toDraw.C.y * pixelsPerUnit);
        g.drawLine(Ax, Ay, Bx, By);
        g.drawLine(Bx, By, Cx, Cy);
        g.drawLine(Cx, Cy, Ax, Ay);
        repaint();
    }

    public void draw(square toDraw) {
        int Ax = (int) (toDraw.A.x * pixelsPerUnit);
        int Ay = (int) (toDraw.A.y * pixelsPerUnit);
        int Bx = (int) (toDraw.B.x * pixelsPerUnit);
        int By = (int) (toDraw.B.y * pixelsPerUnit);
        int Cx = (int) (toDraw.C.x * pixelsPerUnit);
        int Cy = (int) (toDraw.C.y * pixelsPerUnit);
        int Dx = (int) (toDraw.D.x * pixelsPerUnit);
        int Dy = (int) (toDraw.D.y * pixelsPerUnit);
        g.drawLine(Ax, Ay, Bx, By);
        g.drawLine(Bx, By, Cx, Cy);
        g.drawLine(Cx, Cy, Dx, Dy);
        g.drawLine(Dx, Dy, Ax, Ay);
        repaint();
    }

    public void clear() {
        //TBD
    }
    //drawAll TBD
}
