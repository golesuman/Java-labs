package OOP.PolyMorphism;

public class Triangle implements  Shape{
    @Override
    public void display() {
    System.out.println("this is triangle");
    }

    @Override
    public double calculateArea(double r) {
        return 0;
    }
    public  static  void main(String[] args){
        Triangle t = new Triangle();
        t.calculateArea(3);
        t.display();
    }
}
