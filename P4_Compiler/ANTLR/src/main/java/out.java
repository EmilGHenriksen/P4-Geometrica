import Other.*;
import java.awt.*;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
public class out{
    
    //---default functions---
    private static IDrawing drawer = new Drawing();
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
        drawer.clear();
    }
    private static void draw(point toDraw){
        drawer.draw(toDraw);
    }
    private static void draw(line toDraw){
        drawer.draw(toDraw);
    }
    private static void draw(circle toDraw){
        drawer.draw(toDraw);
    }
    private static void draw(triangle toDraw){
        drawer.draw(toDraw);
    }
    private static void draw(square toDraw){
        drawer.draw(toDraw);
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
    private static point createPoint(double x, double y) {
        return new point(x, y);
    }
    private static line createLine(point A, point B) {
        return new line(A, B);
    }
    private static triangle createTriangle(point A, point B, point C) {
        return new triangle(A, B, C);
    }
    private static square createSquare(point A, point B, point C, point D) {
        return new square(A, B, C, D);
    }
    private static circle createCircle(point center, double radius) {
        return new circle(center, radius);
    }
    //---end of default library---
    
    
    public static void main(String[] args) {
        draw(createPoint((double)10.0, (double)10.0));
    }
}
