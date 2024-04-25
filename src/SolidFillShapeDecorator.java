class SolidFillShapeDecorator extends ShapeDecorator {
    private String color;

    public SolidFillShapeDecorator(Shape decoratedShape, String color) {
        super(decoratedShape);
        this.color = color;
    }

    @Override
    public String toSvg(String parameters) {
        String params = String.format("fill=\"%s\" %s", color, parameters);

        return decoratedShape.toSvg(params);
    }
}
