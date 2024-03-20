public class Main {
    public static void main(String[] args) {
        Point[] pointsArray = {
                new Point(50, 50),
                new Point(50, 20),
                new Point(100, 20),
                new Point(100, 50)};

        Polygon polygon = new Polygon(pointsArray);
        System.out.println(polygon.toSvg());
        
        Polygon polygon2 = new Polygon(polygon);
        System.out.println(polygon2.toSvg());
    }
}