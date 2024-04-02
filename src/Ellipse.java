import java.util.Locale;

class Ellipse extends Shape {
    Point center;
    double radiusX;
    double radiusY;

    public Ellipse(Point center, double radiusX, double radiusY, Style style) {
        super(style);
        this.center = center;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
    }

    public Ellipse(Point center, double radiusX, double radiusY) {
        super(new Style("transparent", "black", 1.0));
        this.center = center;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
    }

    @Override
    public String toSvg() {
        return String.format(
                Locale.ENGLISH,
                "<ellipse cx=\"%f\" cy=\"%f\" rx=\"%f\" ry=\"%f\" %s/>",
                this.center.x,
                this.center.y,
                this.radiusX,
                this.radiusY,
                this.style.toSvg());
    }
}
