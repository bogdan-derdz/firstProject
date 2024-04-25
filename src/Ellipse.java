import java.util.Locale;

class Ellipse implements Shape {
    Vec2 center;
    double radiusX;
    double radiusY;

    public Ellipse(Vec2 center, double radiusX, double radiusY) {
        this.center = center;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
    }

    @Override
    public String toSvg(String parameters) {
        return String.format(
                Locale.ENGLISH,
                "<ellipse cx=\"%f\" cy=\"%f\" rx=\"%f\" ry=\"%f\" %s/>",
                this.center.x,
                this.center.y,
                this.radiusX,
                this.radiusY,
                parameters);
    }
}
