import java.lang.Math;
import java.util.Locale;

class Segment {
    private Vec2 startPoint;
    private Vec2 endPoint;

    public Segment(Vec2 startPoint, Vec2 endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Vec2 getStartPoint() {
        return startPoint;
    }

    public Vec2 getEndPoint() {
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

    public static Segment[] perpendicularSegments(Segment segment, Vec2 point) {
        double dX = segment.getEndPoint().x - segment.getStartPoint().x;
        double dY = segment.getEndPoint().y - segment.getStartPoint().y;

        Vec2 endPoint = new Vec2(point.x - dY, point.y + dX);
        Vec2 endPoint2 = new Vec2(point.x + dY, point.y - dX);

        return new Segment[]{new Segment(point, endPoint), new Segment(point, endPoint2)};
    }

    public static Segment[] perpendicularSegments(Segment segment, Vec2 center, double length) {
        double dx = ((segment.getEndPoint().x - segment.getStartPoint().x) / segment.length()) * length;
        double dy = ((segment.getEndPoint().y - segment.getStartPoint().y) / segment.length()) * length;
        return new Segment[]{
                new Segment(center, new Vec2(
                        center.x - dy, center.y + dx
                )),
                new Segment(center, new Vec2(
                        center.x + dy, center.y - dx
                )),
        };
    }
}