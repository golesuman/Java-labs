package Shape;

public class ShapeDemo {
    public static void main(String[] args) {
        Circle c = new Circle(2);
        System.out.println(c.getArea());
        Square s = new Square(3);
        System.out.println(s.getArea());
        System.out.println(s.getSide());
    }
}
