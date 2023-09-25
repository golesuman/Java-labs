public class Rectangle {
    private int height;
    private int width;

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getPerimeter() {
        return 2 * (this.height + this.width);
    }

    public int calculateArea() {
        return this.height * this.width;
    }


    public static void main(String[] args) {
        Rectangle r = new Rectangle(2, 3);
        System.out.println(r.getPerimeter());
        System.out.println(r.calculateArea());

    }
}
