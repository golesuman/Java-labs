import OOP.SampleInheritence;

public class ChildClass extends SampleInheritence {
    public ChildClass(int a, int b) {
        super(a, b);
    }

    public static void main(String[] args) {
        ChildClass c = new ChildClass(3, 2);
        int res = c.sum();
        int diff = c.sub();
        System.out.println("the sum is  " + res);
        System.out.println("The difference is " + diff);

    }
}