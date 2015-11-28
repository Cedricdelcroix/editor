package org.ulco;

/**
 * Created by cedric on 28/11/2015.
 */
public class Triangle extends GraphicsObject {
    private Point point1;
    private Point point2;
    private Point point3;

    public Triangle() {
        this.point1 = new Point(0,0);
        this.point2 = new Point(0,0);
        this.point3 = new Point(0,0);
    }

    public Triangle(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    public void Triangle(String json){
        String str = json.replaceAll("\\s+","");
        int point1index = str.indexOf("point1");
        int point2index = str.indexOf("point2");
        int point3index = str.indexOf("point3");
        int endIndex = str.lastIndexOf("}");

        this.point1 = new Point(str.substring(point1index + 7, point2index - 1));
        this.point2 = new Point(str.substring(point2index + 7, point3index - 1));
        this.point3 = new Point(str.substring(point3index + 7, endIndex - 1));
    }
    @Override
    public GraphicsObject copy() {
        return new Triangle(point1.copy(),point2.copy(),point3.copy());
    }

    @Override
    public boolean isClosed(Point pt, double distance) {
        Point center = new Point(point1.getX() + point2.getX() + point3.getX()/ 3,
                +                point1.getY() + point2.getY() + point3.getY()/ 3);
        return Utility.isClosed(center,pt,distance);
    }

    @Override
    void move(Point delta) {
        point1.move(delta);
        point2.move(delta);
        point3.move(delta);
    }

    @Override
    public String toJson() {
        return "{ type: triangle, point1: " + point1.toJson() + ", point2: " + point2.toJson() + ", point3: " + point3.toJson() + " }";    }

    @Override
    public String toString() {
        return "triangle[" + point1.toString() + "," + point2.toJson() + "," + point3.toJson() + "]";
    }
}
