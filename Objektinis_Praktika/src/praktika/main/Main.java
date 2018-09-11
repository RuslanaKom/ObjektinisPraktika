package praktika.main;

import java.util.Map;

import praktika.tasks.first.Rectangle;

public class Main {
    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle();
        rectangle.setLength(12D);
        rectangle.setWidth(4D);
        rectangle.setLeftUpperCorner(-2D, 10D);

        System.out.println("Area:" + rectangle.getArea());
        System.out.println("Perimeter:" + rectangle.getPerimeter());
        System.out.println("Diagonal:" + rectangle.getDiagonal());
        System.out.println("Intersection coordinates: " + rectangle.getDiagonalIntersection().get("x") + ","
                + rectangle.getDiagonalIntersection().get("y"));
        Map<String, Double> corners = rectangle.getAllCorners();
        System.out.println("Upper left corner: " + corners.get("xUL") + "," + corners.get("yUL"));
        System.out.println("Upper right corner: " + corners.get("xUR") + "," + corners.get("yUR"));
        System.out.println("Bottom left corner: " + corners.get("xBL") + "," + corners.get("yBL"));
        System.out.println("Uppe left corner: " + corners.get("xBR") + "," + corners.get("yBR"));
    }
}
