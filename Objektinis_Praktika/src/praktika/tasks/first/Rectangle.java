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
