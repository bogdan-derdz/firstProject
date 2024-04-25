import java.util.Locale;

class StrokeShapeDecorator extends ShapeDecorator {
    String color;
    double width;

    public StrokeShapeDecorator(Shape decoratedShape, String color, double width) {
        super(decoratedShape);
        this.color = color;
        this.width = width;
    }

    @Override
    public String toSvg(String parameters) {
        String params = String.format(Locale.ENGLISH, "stroke=\"%s\" stroke-width=\"%f\" %s", color, width, parameters);

        return super.toSvg(params);
    }
}
