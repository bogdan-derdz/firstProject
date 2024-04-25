class SolidFilledPolygon extends Polygon {
    private String color;

    public SolidFilledPolygon(Vec2[] points, String color) {
        super(points);
        this.color = color;
    }

    @Override
    public String toSvg(String parameters) {
        String params = String.format("fill=\"%s\" %s", this.color, parameters);
        return super.toSvg(params);
    }
}
