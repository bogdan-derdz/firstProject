class Polygon {
    private Point[] points;

    public Polygon(Point[] points) {
        this.points = points;
    }

    public Polygon(Polygon polygon) {
        this.points = new Point[polygon.points.length];

        for (int i = 0; i < polygon.points.length; i++) {
            this.points[i] = new Point(polygon.points[i].x, polygon.points[i].y);
        }
    }

    public String toSvg() {
        StringBuilder svgCode = new StringBuilder();
        svgCode.append("<svg><polygon points=\"");

        for (Point point : this.points) {
            svgCode.append(point.x).append(",").append(point.y).append(" ");
        }

        svgCode.append( "\" style=\"stroke:red;stroke-width:8\" /></svg>");

        return svgCode.toString();
    }

}
