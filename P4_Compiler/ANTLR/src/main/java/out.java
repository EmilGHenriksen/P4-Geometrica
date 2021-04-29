import java.util.List;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
public class out{
    //---default classes---
    private class point{
        private point(double _x, double _y){
            x = _x;
            y = _y;
        }
        double x;
        double y;
        void move(double _x, double _y){
            x += _x;
            y += _y;
        }
    }
    private class line{
        private line(point _A, point _B){
            A = _A;
            B = _B;
        }
        point A;
        point B;
        void move(double _x, double _y){
            A.move(_x, _y);
            B.move(_x, _y);
        }
    }
    private class circle{
        private circle(point _center, double _radius){
            center = _center;
            radius = _radius;
        }
        point center;
        double radius;
        void move(double _x, double _y){
            center.move(_x, _y);
        }
    }
    private class triangle{
        private triangle(point _A, point _B, point _C){
            A = _A;
            B = _B;
            C = _C;
        }
        point A;
        point B;
        point C;
        void move(double _x, double _y){
            A.move(_x, _y);
            B.move(_x, _y);
            C.move(_x, _y);
        }
    }
    private class square{
        private square(point _A, point _B, point _C, point _D){
            A = _A;
            B = _B;
            C = _C;
            D = _D;
        }
        point A;
        point B;
        point C;
        point D;
        void move(double _x, double _y){
            A.move(_x, _y);
            B.move(_x, _y);
            C.move(_x, _y);
            D.move(_x, _y);
        }
    }
    private static class canvas{
        //TBD
    
        private static void draw(point toDraw){
            //TBD
        }
        private static void draw(line toDraw){
            //TBD
        }
        private static void draw(circle toDraw){
            //TBD
        }
        private static void draw(triangle toDraw){
            //TBD
        }
        private static void draw(square toDraw){
            //TBD
        }
        private static void clear(){
            //TBD
        }
        //drawAll TBD
    }
    //---default functions---
    //default angle functions
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
    //other default functions
    private static void clearcanvas(){
        canvas.clear();
    }
    private static void draw(point toDraw){
        canvas.draw(toDraw);
    }
    private static void draw(line toDraw){
        canvas.draw(toDraw);
    }
    private static void draw(circle toDraw){
        canvas.draw(toDraw);
    }
    private static void draw(triangle toDraw){
        canvas.draw(toDraw);
    }
    private static void draw(square toDraw){
        canvas.draw(toDraw);
    }
    //drawAll TBD
    private static double root(double value, double rootOf){
        return Math.pow(value, 1/rootOf);
    }
    private static double sqrt(double value){
        return Math.sqrt(value);
    }
    private static void wait(double milliseconds) {
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
        catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
    //constructor callers
    private point createPoint(double x, double y) {
        return new point(x, y);
    }
    private line createLine(point A, point B) {
        return new line(A, B);
    }
    private triangle createTriangle(point A, point B, point C) {
        return new triangle(A, B, C);
    }
    private square createSquare(point A, point B, point C, point D) {
        return new square(A, B, C, D);
    }
    private circle createCircle(point center, double radius) {
        return new circle(center, radius);
    }
    //---end of default library---
    
    
    
    private static long a = (long)((long)((-(long)5) + (long)((long)2 * (long)(Math.pow((long)6, (long)7)))) + ((long)((long)6 - (long)4)));
    private static long asda;
    private static List<Long> myArr = Arrays.asList((long)1, (long)2, (long)3);
    private static double foo(double asda) {
        double b = (double)2.5;
        a = (long)(a + (long)1);
        return b;
    }
    public static void main(String[] args) {
        if((a == (long)4)) {
            a = (long)0;
        }
        
    }
}
