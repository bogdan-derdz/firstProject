class Polygon implements Shape {
    private Vec2[] points;

    public Polygon(Vec2[] points) {
        this.points = points;
    }

    public Polygon(Polygon polygon) {
        this.points = new Vec2[polygon.points.length];

        for (int i = 0; i < polygon.points.length; i++) {
            this.points[i] = new Vec2(polygon.points[i].x, polygon.points[i].y);
        }
    }

    @Override
    public String toSvg(String parameters) {
        StringBuilder svg = new StringBuilder();
        svg.append("<polygon points=\"");

        for (Vec2 point : points) {
            svg.append(point.x).append(",").append(point.y).append(" ");
        }

        svg.append("\" ").append(parameters).append(" />");

        return svg.toString();
    }

    public static Polygon square(Segment segment) {
        Vec2 pointH = new Vec2(((segment.getStartPoint().x + segment.getEndPoint().x) / 2), ((segment.getStartPoint().y + segment.getEndPoint().y) / 2));
        Segment segmentH = new Segment(segment.getStartPoint(), pointH);
        Segment[] secR = Segment.perpendicularSegments(segmentH, pointH);
        Vec2[] pointsTab = {segment.getStartPoint(), secR[0].getEndPoint(), segment.getEndPoint(), secR[1].getEndPoint()};
        return new Polygon(pointsTab);
    }

//    public static String square(Segment line, Style style) {
//
//    }
}
