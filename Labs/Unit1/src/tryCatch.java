import java.util.Scanner;

public class tryCatch {
    public static void main(String[] args) {
        Scanner myobj = new Scanner(System.in);
        System.out.println("Enter a : ");
        int a = myobj.nextInt();
        System.out.println("Enter b: ");
        int b = myobj.nextInt();
        try {
            int res = a / b;
            String string = String.format("The division result is %d", res);
            System.out.println(string);

        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
            int sum = a + b;
            System.out.println("The final sum is " + sum);
        }
    }
}
