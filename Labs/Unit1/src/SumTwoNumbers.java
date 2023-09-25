import java.util.Scanner;

public class SumTwoNumbers {
    public static int sum(int x, int y) {
        return x+ y;
    }
    public static void main(String[] args){
        int x, y;
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter username");

        System.out.println("Enter a:");
        int a = myObj.nextInt();
        System.out.println("Enter b:");
        int b = myObj.nextInt();
        System.out.println(SumTwoNumbers.sum(a, b));

    }
}
