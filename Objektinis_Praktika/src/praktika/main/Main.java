package praktika.main;

import java.util.Map;

import org.junit.jupiter.api.Test;

import praktika.tasks.first.Rectangle;
import praktika.tasks.second.Chronometer;

public class Main {

//    @Test
//    public void testRectangle() {
//        Rectangle rectangle = new Rectangle();
//        rectangle.setLength(12D);
//        rectangle.setWidth(5D);
//        rectangle.setLeftUpperCorner(0D, 5D);
//
//        System.out.println("Area:" + rectangle.getArea());
//        System.out.println("Perimeter:" + rectangle.getPerimeter());
//        System.out.printf("Diagonal: %.2f\n",rectangle.getDiagonal());
//        System.out.println("Intersection coordinates: " + rectangle.getDiagonalIntersection().get("x") + ","
//                + rectangle.getDiagonalIntersection().get("y"));
//        Map<String, Double> corners = rectangle.getAllCorners();
//        System.out.println("Upper left corner: " + corners.get("xUL") + "," + corners.get("yUL"));
//        System.out.println("Upper right corner: " + corners.get("xUR") + "," + corners.get("yUR"));
//        System.out.println("Bottom left corner: " + corners.get("xBL") + "," + corners.get("yBL"));
//        System.out.println("Uppe left corner: " + corners.get("xBR") + "," + corners.get("yBR"));
//    }
//
//    @Test
//    public void testChronometerHappyPath() throws InterruptedException {
//        Chronometer chronometer = new Chronometer();
//        chronometer.start();
//        Thread.sleep(3000);
//        System.out.println(chronometer.getIntermediate());
//        Thread.sleep(2000);
//        System.out.println(chronometer.getIntermediate());
//        Thread.sleep(3000);
//        chronometer.pause();
//        Thread.sleep(1000);
//        chronometer.pause();
//        System.out.println(chronometer.getIntermediate());
//        System.out.println(chronometer.stop());
//    }
//
//    @Test
//    public void testChronometerRandomPath() throws InterruptedException {
//        Chronometer chronometer = new Chronometer();
//        chronometer.start();
//        Thread.sleep(3000);
//        chronometer.pause();
//        Thread.sleep(2000);
//        System.out.println(chronometer.getIntermediate());
//        Thread.sleep(2000);
//        System.out.println(chronometer.getIntermediate());
//        Thread.sleep(3000);
//        chronometer.pause();
//        Thread.sleep(1000);
//        System.out.println(chronometer.getIntermediate());
//        chronometer.pause();
//        Thread.sleep(1000);
//        System.out.println(chronometer.stop());
//    }
//
//    @Test
//    public void testSeveralPausesBetweenIntermediates() throws InterruptedException {
//        Chronometer chronometer = new Chronometer();
//        chronometer.start();
//        Thread.sleep(3000);
//        System.out.println(chronometer.getIntermediate());
//        Thread.sleep(2000);
//        System.out.println(chronometer.getIntermediate());
//        Thread.sleep(1);
//        chronometer.pause();
//        Thread.sleep(1000);
//        chronometer.pause();
//        Thread.sleep(3000);
//        chronometer.pause();
//        Thread.sleep(2000);
//        chronometer.pause();
//        System.out.println(chronometer.getIntermediate());
//        System.out.println(chronometer.stop());
//    }

    @Test
    public void testChronometer() {
    	Chronometer chronometer = new Chronometer();
    	chronometer.chronometerWork();
    }
}
