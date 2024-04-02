import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class SvgScene {
    private List<Shape> shapes;

    public SvgScene() {
        this.shapes = new ArrayList<>();
    }

    public void add(Shape shape) {
        this.shapes.add(shape);
    }

    public void save(String path) {
        StringBuilder sb = new StringBuilder();

        sb.append("<html><body><svg width=\"1024\" height=\"768\" xmlns=\"http://www.w3.org/2000/svg\">\n");

        for (Shape shape : shapes) {
            sb.append(shape.toSvg())
                    .append("\n");
        }

        sb.append("</svg></body></html>");

        try {
            FileWriter writer = new FileWriter(path);
            writer.write(sb.toString());

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
