package OOP;

public class Enscapsulation {
    private int age;
    private String name;

    public Enscapsulation(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
//        System.out.println(this.name);
        return this.name;
    }

    public int getAge() {
//        System.out.println(age);
        return this.age;
    }

    public static void main(String[] args) {
        Enscapsulation e = new Enscapsulation(1, "suman");
        int resultAge = e.getAge();
        String name = e.getName();
        System.out.println(resultAge);
        System.out.println(name);

    }
}
