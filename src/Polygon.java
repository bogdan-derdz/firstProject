class Polygon {
    private Point[] points;
    Style style;

    public Polygon(Point[] points) {
        this.points = points;
        this.style = new Style("transparent", "black", 1.0);
    }

    public Polygon(Point[] points, Style style) {
        this.points = points;
        this.style = style;
    }

    public Polygon(Polygon polygon) {
        this.points = new Point[polygon.points.length];
        this.style = new Style(polygon.style.fillColor, polygon.style.strokeColor, polygon.style.strokeWidth);

        for (int i = 0; i < polygon.points.length; i++) {
            this.points[i] = new Point(polygon.points[i].x, polygon.points[i].y);
        }
    }

    public String toSvg() {
        StringBuilder svg = new StringBuilder();
        svg.append("<polygon points=\"");

        for (Point point : points) {
            svg.append(point.x).append(",").append(point.y).append(" ");
        }

        svg.append("\"").append(style.toSvg()).append("/>");

        return svg.toString();
    }
}
