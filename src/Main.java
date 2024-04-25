public class Main {
    public static void main(String[] args) {
        SvgScene scene = new SvgScene();

        Polygon sqr = Polygon.square(new Segment(new Vec2(250, 150), new Vec2(450, 250)));

        Shape polygon = new Polygon(new Vec2[]{
                new Vec2(500, 100),
                new Vec2(220, 20),
                new Vec2(400, 25),
                new Vec2(70, 33),
        });

        TransformationDecorator.Builder builder = new TransformationDecorator.Builder();
        Shape s = builder
                .rotate(-50, new Vec2(0, 0))
                .translate(new Vec2(50, 60))
                .scale(new Vec2(1, 1.5))
                .build(new Ellipse(new Vec2(40, 50), 20, 40));

        scene.add(s);
        scene.save("scene.html");
    }
}