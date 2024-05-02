class DropShadowDecorator extends ShapeDecorator {
    private static int index = 0;

    public DropShadowDecorator(Shape decoratedShape) {
        super(decoratedShape);
        
        SvgScene.getInstance().addDef("\t<filter id=\"f" + index + "\" x=\"-100%%\" y=\"-100%%\" width=\"300%%\" height=\"300%%\">\n" +
                "\t\t<feOffset result=\"offOut\" in=\"SourceAlpha\" dx=\"5\" dy=\"5\" />\n" +
                "\t\t<feGaussianBlur result=\"blurOut\" in=\"offOut\" stdDeviation=\"5\" />\n" +
                "\t\t<feBlend in=\"SourceGraphic\" in2=\"blurOut\" mode=\"normal\" />\n" +
                "\t</filter>");

        index++;
    }

    @Override
    public String toSvg(String parameters) {
        String params = String.format("filter=\\\"url(#f%d)\\\" %s", index, parameters);

        return super.toSvg(params);
    }
}
