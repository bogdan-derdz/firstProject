import java.util.Locale;

class TransformationDecorator extends ShapeDecorator {
    String transform;

    public TransformationDecorator(Shape shape, String transform) {
        super(shape);
        this.transform = transform;
    }

    static class Builder {
        String transform;

        public Builder() {
            transform = "";
        }

        public Builder translate(Vec2 translation) {
            this.transform += String.format(Locale.ENGLISH, " translate(%f %f)", translation.x, translation.y);

            return this;
        }

        public Builder rotate(float rotateAngle, Vec2 rotateCenter) {
            this.transform += String.format(Locale.ENGLISH, " rotate(%f %f %f)", rotateAngle, rotateCenter.x, rotateCenter.y);

            return this;
        }

        public Builder scale(Vec2 scaleVector) {
            this.transform += String.format(Locale.ENGLISH, " scale(%f %f)", scaleVector.x, scaleVector.y);

            return this;
        }

        TransformationDecorator build(Shape shape) {
            return new TransformationDecorator(shape, transform);
        }
    }

    @Override
    public String toSvg(String param) {
        return super.toSvg(String.format("%s transform=\"%s\"", param, this.transform));
    }
}