package praktika.tasks.first;

import java.util.HashMap;
import java.util.Map;

public class Rectangle {

    private Double length;
    private Double width;
    private Map<String, Double> leftUpperCorner=new HashMap<>();
    
    public Double getArea() {
        return length*width;  
    }
    
    public Double getPerimeter() {
        return length*2+width*2;
    }
    
    public Double getDiagonal() {
        return Math.sqrt(Math.pow(length, 2)+Math.pow(width, 2));
    }
    
    public Map<String, Double> getDiagonalIntersection(){
        Map <String, Double> intersection=new HashMap<>();
        intersection.put("x", leftUpperCorner.get("x")+length/2);
        intersection.put("y", leftUpperCorner.get("y")-width/2);
        return intersection ;
    }
    public Map<String, Double> getAllCorners(){
        Map <String, Double> corners=new HashMap<>();
        corners.put("xUL", leftUpperCorner.get("x"));
        corners.put("yUL", leftUpperCorner.get("y"));
        corners.put("xUR", leftUpperCorner.get("x")+length);
        corners.put("yUR", leftUpperCorner.get("y"));
        corners.put("xBL", leftUpperCorner.get("x"));
        corners.put("yBL", leftUpperCorner.get("y")-width);
        corners.put("xBR", corners.get("xUR"));
        corners.put("yBR", corners.get("yBL"));
        return corners ;
    }
    
    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Map<String, Double> getLeftUpperCorner() {
        return leftUpperCorner;
    }

    public void setLeftUpperCorner(Double x, Double y) {
        this.leftUpperCorner.put("x", x);
        this.leftUpperCorner.put("y", y);
    }


}
