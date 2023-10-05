import java.util.Scanner;

public class AreaCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Select a shape to calculate its area:");
        System.out.println("1. Circle");
        System.out.println("2. Square");
        System.out.println("3. Rectangle");
        System.out.println("4. Sphere");

        int choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter the radius of the circle: ");
                double radius = input.nextDouble();
                double circleArea = calculateCircleArea(radius);
                System.out.println("The area of the circle is: " + circleArea);
                break;

            case 2:
                System.out.print("Enter the side length of the square: ");
                double sideLength = input.nextDouble();
                double squareArea = calculateSquareArea(sideLength);
                System.out.println("The area of the square is: " + squareArea);
                break;

            case 3:
                System.out.print("Enter the length of the rectangle: ");
                double length = input.nextDouble();
                System.out.print("Enter the width of the rectangle: ");
                double width = input.nextDouble();
                double rectangleArea = calculateRectangleArea(length, width);
                System.out.println("The area of the rectangle is: " + rectangleArea);
                break;

            case 4:
                System.out.print("Enter the radius of the sphere: ");
                double sphereRadius = input.nextDouble();
                double sphereArea = calculateSphereArea(sphereRadius);
                System.out.println("The surface area of the sphere is: " + sphereArea);
                break;

            default:
                System.out.println("Invalid choice.");
        }

        input.close();
    }

    public static double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }

    public static double calculateSquareArea(double sideLength) {
        return sideLength * sideLength;
    }

    public static double calculateRectangleArea(double length, double width) {
        return length * width;
    }

    public static double calculateSphereArea(double radius) {
        return 4 * Math.PI * radius * radius;
    }
}
