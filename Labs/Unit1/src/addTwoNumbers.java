import java.util.Scanner;

public class addTwoNumbers {
    public static int addNumbers(int a, int b) {
        return a + b;
    }

    //    public
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter a:");
        int a = scn.nextInt();
        System.out.println("Enter b:");
        int b = scn.nextInt();
        System.out.println(addTwoNumbers.addNumbers(a, b));
    }
}
