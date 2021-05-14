import Other.*;
import java.awt.*;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
public class out extends Canvas{
    //---start of default library---
    public static void main(String[] args) {
        _canvasSize = 600;
        _unitSize = 10;
        _pointRadius = 2;
        JFrame frame = new JFrame("Geometry");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new out();
        canvas.setSize(_canvasSize, _canvasSize);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }
    
    public void paint(Graphics _g_in) {
        _g = _g_in;
    
        clearcanvas();
    
        _trueMain();
    
        wait(Math.pow(10, 3+10));
    }
    Graphics _g;
    public static int _canvasSize;
    public static double _unitSize;
    public static int _pointRadius;
    public int _convertX(int x){
        return x+(int)(_canvasSize/2);
    }
    public int _convertY(int y){
        return -y+(int)(_canvasSize/2);
    }
    
    
    //---default functions---
    //constructor callers
    public point createPoint(double x, double y){
        return new point(x, y);
    }
    public line createLine(point A, point B){
        return new line(A, B);
    }
    public triangle createTriangle(point A, point B, point C){
        return new triangle(A, B, C);
    }
    public square createSquare(point A, point B, point C, point D){
        return new square(A, B, C, D);
    }
    public circle createCircle(point center, double radius){
        return new circle(center, radius);
    }
    //default math functions
    private static double arccos(double length){
        return Math.acos(length);
    }
    private static double arcsin(double length){
        return Math.asin(length);
    }
    private static double arctan(double length){
        return Math.atan(length);
    }
    private static double cos(double angle){
        return Math.cos(angle);
    }
    private static double sin(double angle){
        return Math.sin(angle);
    }
    private static double tan(double angle){
        return Math.tan(angle);
    }
    private static double root(double value, double rootOf){
        return Math.pow(value, 1/rootOf);
    }
    private static double sqrt(double value){
        return Math.sqrt(value);
    }
    //default drawing functions
    public void draw(point toDraw){
        int x = _convertX((int) (toDraw.x * _unitSize));
        int y = _convertY((int) (toDraw.y * _unitSize));
        for(int width = 2; width <= _pointRadius*2; width += 2){
            _g.drawOval(x-(width/2), y-(width/2), width, width);
        }
    }
    public void draw(line toDraw){
        draw(toDraw, true);
        draw(toDraw.A);
        draw(toDraw.B);
        // _g.drawString("A", _convertX((int)(toDraw.A.x*_unitSize))+5, _convertY((int)(toDraw.A.y*_unitSize))-5);
        // _g.drawString("B", _convertX((int)(toDraw.B.x*_unitSize))+5, _convertY((int)(toDraw.B.y*_unitSize))-5);
    }
    public void draw(line toDraw, boolean isCustom){
        int Ax = _convertX((int) (toDraw.A.x * _unitSize));
        int Ay = _convertY((int) (toDraw.A.y * _unitSize));
        int Bx = _convertX((int) (toDraw.B.x * _unitSize));
        int By = _convertY((int) (toDraw.B.y * _unitSize));
        _g.drawLine(Ax, Ay, Bx, By);
    }
    public void draw(triangle toDraw){
        line AB = createLine(toDraw.A, toDraw.B);
        line BC = createLine(toDraw.B, toDraw.C);
        line CA = createLine(toDraw.C, toDraw.A);
        draw(toDraw.A);
        draw(toDraw.B);
        draw(toDraw.C);
        draw(AB, true);
        draw(BC, true);
        draw(CA, true);
        _g.drawString("A", _convertX((int)(toDraw.A.x*_unitSize))+5, _convertY((int)(toDraw.A.y*_unitSize))-5);
        _g.drawString("B", _convertX((int)(toDraw.B.x*_unitSize))+5, _convertY((int)(toDraw.B.y*_unitSize))-5);
        _g.drawString("C", _convertX((int)(toDraw.C.x*_unitSize))+5, _convertY((int)(toDraw.C.y*_unitSize))-5);
    }
    public void draw(square toDraw){
        line AB = createLine(toDraw.A, toDraw.B);
        line BC = createLine(toDraw.B, toDraw.C);
        line CD = createLine(toDraw.C, toDraw.D);
        line DA = createLine(toDraw.D, toDraw.A);
        draw(toDraw.A);
        draw(toDraw.B);
        draw(toDraw.C);
        draw(toDraw.D);
        draw(AB, true);
        draw(BC, true);
        draw(CD, true);
        draw(DA, true);
        _g.drawString("A", _convertX((int)(toDraw.A.x*_unitSize))+5, _convertY((int)(toDraw.A.y*_unitSize))-5);
        _g.drawString("B", _convertX((int)(toDraw.B.x*_unitSize))+5, _convertY((int)(toDraw.B.y*_unitSize))-5);
        _g.drawString("C", _convertX((int)(toDraw.C.x*_unitSize))+5, _convertY((int)(toDraw.C.y*_unitSize))-5);
        _g.drawString("D", _convertX((int)(toDraw.D.x*_unitSize))+5, _convertY((int)(toDraw.D.y*_unitSize))-5);
    }
    public void draw(circle toDraw){
        int x = _convertX((int) (toDraw.center.x * _unitSize));
        int y = _convertY((int) (toDraw.center.y * _unitSize));
        int radius = (int) (toDraw.radius * _unitSize);
        _g.drawOval(x, y, radius, radius);
    }
    public void clearcanvas(){
        int brightness = 255;
        _g.setColor(new Color(brightness, brightness, brightness));
        _g.fillRect(-10, -10, _canvasSize+20, _canvasSize+20);
        brightness = 150;
        _g.setColor(new Color(brightness, brightness, brightness));
        int centerX = (int)(_canvasSize/2);
        int centerY = (int)(_canvasSize/2);
        //vertical line
        _g.drawLine(0, centerY, _canvasSize, centerY);
        //horizontal line
        _g.drawLine(centerX, 0, centerX, _canvasSize);
        _g.setColor(new Color(0, 0, 0));
    }
    //other default functions
    public static void wait(double milliseconds) {
        long precisionDigits = 4;
        try{
            if(milliseconds < Math.pow(10, precisionDigits-3)){
                long nanoseconds = (long)(milliseconds*1000*1000);
                TimeUnit.NANOSECONDS.sleep(nanoseconds);
            }
            else if(milliseconds < Math.pow(10, precisionDigits)){
                long microseconds = (long)(milliseconds*1000);
                TimeUnit.MICROSECONDS.sleep(microseconds);
            }
            else if(milliseconds < Math.pow(10, precisionDigits+3)){
                TimeUnit.MILLISECONDS.sleep((long)milliseconds);
            }
            else if(milliseconds < Math.pow(10, precisionDigits+6)){
                long seconds = (long)(milliseconds/1000);
                TimeUnit.SECONDS.sleep(seconds);
            }
            else if(milliseconds < Math.pow(10, 1+precisionDigits+9)){
                long hours = (long)(milliseconds/(1000*60*60));
                TimeUnit.HOURS.sleep(hours);
            }
            else{
                long days = (long)(milliseconds/(1000*60*60*24));
                TimeUnit.DAYS.sleep(days);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    //---end of default library---
    
    
    
    
    private double x = (-(long)30);
    private double f(double x) {
        x = Double.valueOf(x);
        
        double y = (((-((Math.pow(x, (long)2)))) + ((long)3 * x)) + (long)5);
        return y;
    }
    public void _trueMain(){
        while((x < (long)30)) {
            point p1 = createPoint(x, f(x));
            point p2 = createPoint((double)(x + (long)1), f((double)(x + (long)1)));
            line current = createLine(p1, p2);
            draw(current);
            x = (double)(x + (long)1);}
    }
}
