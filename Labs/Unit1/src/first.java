public class first {

    public int checkBalanced(int[] numbers){
        for (int i = 0; i < numbers.length; i++) {
            if (i % 2 == 0 && numbers[i] % 2 == 0){
                continue;
            }
            else if (i % 2 == 1 && numbers[i] % 2 == 1){
                continue;
            }
            else {
                return 1;
            }


        }
        return 0;
    }

    public static void main(String[] args) {
        first m = new first();
        int[] numbers = {2, 3, 4, 5, 6, 4};
        System.out.println(m.checkBalanced(numbers));
//    m.checkBalanced(numbers);
    }
}