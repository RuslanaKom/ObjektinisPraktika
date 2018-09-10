package praktika.main;

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
        System.out.println("Intersection coordinates: " + rectangle.getDiagonalIntersection().get("x")+","+rectangle.getDiagonalIntersection().get("y"));
    }
}
