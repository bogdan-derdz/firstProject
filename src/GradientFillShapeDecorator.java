import java.util.ArrayList;

public class GradientFillShapeDecorator extends ShapeDecorator {
    private static int index = 0;
    private ArrayList<Stop> stops;

    private record Stop(double offset, String color) {
    }

    public GradientFillShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    public static class Builder {
        private ArrayList<Stop> stops;
        private Shape shape;

        public Builder() {
            this.stops = new ArrayList<>();
        }

        public Builder setShape(Shape shape) {
            this.shape = shape;

            return this;
        }

        public Builder addStop(double offset, String color) {
            stops.add(new Stop(offset, color));

            return this;
        }

        public GradientFillShapeDecorator build() {
            GradientFillShapeDecorator result = new GradientFillShapeDecorator(shape);
            result.stops = this.stops;

            return result;
        }
    }

    public int addDefToScene() {
        StringBuilder gradient = new StringBuilder();
        gradient.append("\t<linearGradient id=\"g" + index + "\" >\n");

        for (Stop stop : stops) {
            String s = String.format("\t\t<stop offset=\"%f\" style=\"stop-color:%s\" />\n", stop.offset, stop.color);
            gradient.append(s);
        }

        gradient.append("\t</linearGradient>");

        SvgScene.getInstance().addDef(gradient.toString());

        return index++;
    }

    @Override
    public String toSvg(String parameters) {
        int index = addDefToScene();

        String params = String.format("fill=\"url(#g%d)\" %s", index, parameters);

        return super.toSvg(params);
    }
}
