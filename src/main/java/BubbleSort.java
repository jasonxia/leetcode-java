public class BubbleSort {
    public static void sort(int[] numbers) {
        for(int i = numbers.length - 1; i > 0; i--) {
            for(int j = 0; j < i; j ++) {
                if(numbers[j] > numbers[j+1]) {
                    int tmp = numbers[j+1];
                    numbers[j+1] = numbers[j];
                    numbers[j] = tmp;
                }
            }
        }
    }
}
