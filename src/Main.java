public class Main {
    public static void main(String[] args) {
        Point[] pointsArray = {
                new Point(50, 50),
                new Point(50, 20),
                new Point(100, 20),
                new Point(100, 50)};

        Point[] pointsArray2 = {
                new Point(150, 100),
                new Point(250, 50),
                new Point(250, 100)};

        Polygon polygon = new Polygon(pointsArray, new Style("green", "black", 1.0));
        Polygon polygon2 = new Polygon(pointsArray2, new Style("red", "blue", 2.0));
        Ellipse ellipse = new Ellipse(new Point(100, 100), 20, 20, new Style("blue", "black", 1.0));
        Ellipse ellipse2 = new Ellipse(new Point(200, 150), 20, 40, new Style("red", "black", 1.0));

        SvgScene scene = new SvgScene();
        scene.add(polygon);
        scene.add(polygon2);
        scene.add(ellipse);
        scene.add(ellipse2);

        scene.save("scene.html");
    }
}