public class sumOfArray {
    public static int sum(int[] array) {
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        return sum;

    }
    public static void main(String[] args){
        int[] array = {1, 2, 3, 4, 5, 6};
        System.out.println(sumOfArray.sum(array));
    }
}
