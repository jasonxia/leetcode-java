public class QuickSort {
    public static void sort(int[] numbers) {
        sort(numbers, 0, numbers.length - 1);
    }

    private static void sort(int[] numbers, int left, int right) {
        int i = left;
        int j = right;
        int pivot = numbers[left + (right - left) / 2];

        while(i <= j) {
            while(numbers[i] < pivot) {
                i++;
            }

            while(numbers[j] > pivot) {
                j--;
            }

            if(i <= j) {
                int tmp = numbers[j];
                numbers[j] = numbers[i];
                numbers[i] = tmp;
                i++;
                j--;
            }
        }

        System.out.println(numbers);
        if(left < j) {
            sort(numbers, left, j);
        }

        if(i < right) {
            sort(numbers, i, right);
        }
    }
}
