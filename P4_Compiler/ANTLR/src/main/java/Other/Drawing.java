package Other;

import javax.swing.*;
import java.awt.*;

//---default classes---
public class Drawing extends Canvas implements IDrawing {
    public Drawing() {
        frame = new JFrame("My Drawing");
        this.setSize(400, 400);
        frame.add(this);
        frame.pack();
        frame.setVisible(true);
        pixelsPerUnit = 10;
        pointSize = 3;
    }
    JFrame frame;
    final double pixelsPerUnit;
    final double pointSize;

    public void draw(point toDraw) {
        Graphics g = getGraphics();
        int x = (int) (toDraw.x * pixelsPerUnit);
        int y = (int) (toDraw.y * pixelsPerUnit);
        int width = (int)pointSize;
        g.setColor(new Color(0, 0, 0));
        g.drawRect(x,y, width, width);
        this.paint(g);
    }

    public void draw(line toDraw) {
        Graphics g = getGraphics();
        int Ax = (int) (toDraw.A.x * pixelsPerUnit);
        int Ay = (int) (toDraw.A.y * pixelsPerUnit);
        int Bx = (int) (toDraw.B.x * pixelsPerUnit);
        int By = (int) (toDraw.B.y * pixelsPerUnit);
        g.drawLine(Ax, Ay, Bx, By);
        this.paint(g);
    }

    public void draw(circle toDraw) {
        Graphics g = getGraphics();
        int x = (int) (toDraw.center.x * pixelsPerUnit);
        int y = (int) (toDraw.center.y * pixelsPerUnit);
        int diameter = (int) (toDraw.radius * pixelsPerUnit * 2);
        g.drawOval(x, y, diameter, diameter);
    }

    public void draw(triangle toDraw) {
        Graphics g = getGraphics();
        int Ax = (int) (toDraw.A.x * pixelsPerUnit);
        int Ay = (int) (toDraw.A.y * pixelsPerUnit);
        int Bx = (int) (toDraw.B.x * pixelsPerUnit);
        int By = (int) (toDraw.B.y * pixelsPerUnit);
        int Cx = (int) (toDraw.C.x * pixelsPerUnit);
        int Cy = (int) (toDraw.C.y * pixelsPerUnit);
        g.drawLine(Ax, Ay, Bx, By);
        g.drawLine(Bx, By, Cx, Cy);
        g.drawLine(Cx, Cy, Ax, Ay);
        this.paint(g);
    }

    public void draw(square toDraw) {
        Graphics g = getGraphics();
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
        this.paint(g);
    }

    public void clear() {
        //TBD
    }
    //drawAll TBD
}
