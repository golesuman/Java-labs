package OOP.CalculateArea;

import java.util.Scanner;

class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Square {
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public double calculateArea() {
        return sideLength * sideLength;
    }
}

class Rectangle {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double calculateArea() {
        return length * width;
    }
}

class Sphere {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    public double calculateSurfaceArea() {
        return 4 * Math.PI * radius * radius;
    }
}

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
                double circleRadius = input.nextDouble();
                Circle circle = new Circle(circleRadius);
                System.out.println("The area of the circle is: " + circle.calculateArea());
                break;

            case 2:
                System.out.print("Enter the side length of the square: ");
                double squareSideLength = input.nextDouble();
                Square square = new Square(squareSideLength);
                System.out.println("The area of the square is: " + square.calculateArea());
                break;

            case 3:
                System.out.print("Enter the length of the rectangle: ");
                double rectangleLength = input.nextDouble();
                System.out.print("Enter the width of the rectangle: ");
                double rectangleWidth = input.nextDouble();
                Rectangle rectangle = new Rectangle(rectangleLength, rectangleWidth);
                System.out.println("The area of the rectangle is: " + rectangle.calculateArea());
                break;

            case 4:
                System.out.print("Enter the radius of the sphere: ");
                double sphereRadius = input.nextDouble();
                Sphere sphere = new Sphere(sphereRadius);
                System.out.println("The surface area of the sphere is: " + sphere.calculateSurfaceArea());
                break;

            default:
                System.out.println("Invalid choice.");
        }

        input.close();
    }
}
