import java.lang.Math;

class Segment {
    private Point startPoint;
    private Point endPoint;

    public Segment(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public String toSvg() {
        return "<svg height=\"250\" width=\"500\" xmlns=\"http://www.w3.org/2000/svg\">" +
                "<line x1=\"" + startPoint.x +
                "\" y1=\"" + startPoint.y +
                "\" x2=\"" + endPoint.x + "\" y2=\"" + endPoint.y +
                "\" style=\"stroke:red;stroke-width:8\" />" +
                "</svg>";
    }

    public double length() {
        return Math.sqrt(Math.pow(endPoint.x - startPoint.x, 2) + Math.pow(endPoint.y - startPoint.y, 2));
    }

    public static Segment[] getPerpendicularSegment(Segment line, Point c) {
        int distX = line.getEndPoint().x - line.getStartPoint().x;
        int distY = line.getEndPoint().y - line.getStartPoint().y;

        Point d = new Point(c.x + distY, c.y - distX);
        Point e = new Point(c.x - distY, c.y + distX);

        Segment[] array = {new Segment(c, d), new Segment(c, e)};

        return array;
    }
}