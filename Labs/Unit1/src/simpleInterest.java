import java.util.Scanner;

public class simpleInterest {
    public static double interest(int p, int t, double r) {
        return (p * t * r) / 100;
    }

    public static void main(String[] args) {
        System.out.println("Enter the principle");
        Scanner scn = new Scanner(System.in);
        int p = scn.nextInt();
        int t = scn.nextInt();
        int r = scn.nextInt();
        System.out.println(simpleInterest.interest(p, t, r));
    }
}
