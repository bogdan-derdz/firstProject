class Polygon extends Shape {
    private Point[] points;

    public Polygon(Point[] points) {
        super(new Style("transparent", "black", 1.0));
        this.points = points;
    }

    public Polygon(Point[] points, Style style) {
        super(style);
        this.points = points;
    }

    public Polygon(Polygon polygon) {
        super(new Style(polygon.style.fillColor, polygon.style.strokeColor, polygon.style.strokeWidth));
        this.points = new Point[polygon.points.length];

        for (int i = 0; i < polygon.points.length; i++) {
            this.points[i] = new Point(polygon.points[i].x, polygon.points[i].y);
        }
    }

    @Override
    public String toSvg() {
        StringBuilder svg = new StringBuilder();
        svg.append("<polygon points=\"");

        for (Point point : points) {
            svg.append(point.x).append(",").append(point.y).append(" ");
        }

        svg.append("\"").append(style.toSvg()).append("/>");

        return svg.toString();
    }

//    public static String square(Segment line, Style style) {
//
//    }
}
