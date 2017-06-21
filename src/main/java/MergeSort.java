/**
 * Created by xiay on 20/6/17.
 */
public class MergeSort {
    public static void sort(int[] numbers) {
        int[] tmp = new int[numbers.length];
        sort(numbers, tmp, 0, numbers.length - 1);
    }

    private static void sort(int[] numbers, int[] tmp, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            sort(numbers, tmp, left, center);
            sort(numbers, tmp, center + 1, right);
            merge(numbers, tmp, left, center + 1, right);
        }
    }

    private static void merge(int[] numbers, int[] tmp, int left, int right, int rightEnd) {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(numbers[left] < numbers[right])
                tmp[k++] = numbers[left++];
            else
                tmp[k++] = numbers[right++];

        while(left <= leftEnd)    // Copy rest of first half
            tmp[k++] = numbers[left++];

        while(right <= rightEnd)  // Copy rest of right half
            tmp[k++] = numbers[right++];

        // Copy tmp back
        for(int i = 0; i < num; i++, rightEnd--)
            numbers[rightEnd] = tmp[rightEnd];
    }


}
