public class findArea {
    public double findPerimeter(double length, double breadth) {
        return 2 * (length + breadth);
    }

    public double findArea1(double length, double breadth) {
        return length * breadth;
    }

    public static void main(String[] args) {
        findArea fa = new findArea();
        double result = fa.findPerimeter(2, 3);
        double areaResult = fa.findArea1(2, 3);
        System.out.println("the result of perimeter is " + result);
        System.out.println("the result of area is " + areaResult);

    }

}
