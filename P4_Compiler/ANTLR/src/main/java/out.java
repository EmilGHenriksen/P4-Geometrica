import Other.point;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;

class out extends Canvas {
    Graphics g;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Geometry");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new out();
        canvas.setSize(400, 400);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }

    public void paint(Graphics _g) {
        g = _g;

        trueMain();
    }
    public void draw(point toDraw){
        int x = (int) (toDraw.x * 10);
        int y = (int) (toDraw.y * 10);
        int width = (int)3;
        g.drawRect(x,y, width, width);
    }
    public point createPoint(double x, double y){
        return new point(x, y);
    }
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

    public void trueMain(){
        draw(createPoint(10, 10));
        wait((double)1000);
    }
}