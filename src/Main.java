public class Main {
    public static void main(String[] args) {
        Point a = new Point(0, 10);
        Point b = new Point(20, 100);

        Segment seg = new Segment(a, b);

        System.out.printf("%f", seg.length());
    }
}