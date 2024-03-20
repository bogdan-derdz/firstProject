import java.lang.Math;
import java.util.Locale;

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
//        return "<line x1=\"" + startPoint.x +
//                "\" y1=\"" + startPoint.y +
//                "\" x2=\"" + endPoint.x +
//                "\" y2=\"" + endPoint.y +
//                "\" stroke=\"black\" />";

        return String.format(
                Locale.ENGLISH,
                "<line x1=\"%f\" y1=\"%f\" x2=\"%f\" y2=\"%f\" stroke=\"black\"/>",
                startPoint.x, startPoint.y, endPoint.x, endPoint.y);
    }

    public double length() {
        return Math.sqrt(Math.pow(endPoint.x - startPoint.x, 2) + Math.pow(endPoint.y - startPoint.y, 2));
    }

    public static Segment[] perpendicularSegments(Segment segment, Point point) {
        double dX = segment.getEndPoint().x - segment.getStartPoint().x;
        double dY = segment.getEndPoint().y - segment.getStartPoint().y;

        Point endPoint = new Point(point.x - dY, point.y + dX);
        Point endPoint2 = new Point(point.x + dY, point.y - dX);

        return new Segment[]{new Segment(point, endPoint), new Segment(point, endPoint2)};
    }
}