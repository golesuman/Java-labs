package OOP;

public class SampleInheritence {
    private int x;
    private int y;

    public SampleInheritence(int a, int b) {
        this.x = a;
        this.y = b;

    }

    public int sum() {
        return this.x + this.y;
    }

    public int sub() {
        return this.x - this.y;
    }
}