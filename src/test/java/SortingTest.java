import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;

public class SortingTest {
    private int[] numbers;

    @Before
    public void setUp() {
        numbers = new int[10];
        Random generator = new Random();
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(20);
        }
    }

    @Test
    public void testMergeSort() {
        MergeSort.sort(numbers);
        for(int i = 0; i < numbers.length-1; i++) {
            assertTrue(numbers[i] + " should be less or equal than " + numbers[i+1], numbers[i]<=numbers[i+1]);
        }
    }

    @Test
    public void testBubbleSort() {
        BubbleSort.sort(numbers);
        for(int i = 0; i < numbers.length-1; i++) {
            assertTrue(numbers[i] + " should be less or equal than " + numbers[i+1], numbers[i]<=numbers[i+1]);
        }
    }

    @Test
    public void testQuickSort() {
        QuickSort.sort(numbers);
        for(int i = 0; i < numbers.length-1; i++) {
            assertTrue(numbers[i] + " should be less or equal than " + numbers[i+1], numbers[i]<=numbers[i+1]);
        }
    }
}
