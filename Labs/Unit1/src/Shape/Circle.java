package Shape;

public class Circle {
    private int radius;
    private static final double PI = 3.14;

    public Circle(int radius) {
        this.radius = radius;
    }

    public double getArea (){
        return PI * radius * radius;
    }

}
