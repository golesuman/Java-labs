package OOP.PolyMorphism;

public class Circle implements Shape{
    @Override
    public double calculateArea(double r) {
        return 3.14 * r * r;
    }

    @Override
    public void display() {
        System.out.println("this is circle");
    }


    public static  void  main(String[] args){
        Circle c = new Circle();
        double res = c.calculateArea(4);
        System.out.println(res);
        c.display();
    }
}
