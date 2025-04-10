import java.util.Arrays;
import java.util.Random;

public class SortHomework {

    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = random.nextInt(10000);
        return arr;
    }

    public static int[] bubbleSort(int[] arr) {
        int[] result = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < result.length - 1; i++) {
            for (int j = 1; j < result.length - i; j++) {
                if (result[j - 1] > result[j]) {
                    int temp = result[j];
                    result[j] = result[j - 1];
                    result[j - 1] = temp;
                }
            }
        }
        return result;
    }

    public static int[] insertionSort(int[] arr) {
        int[] result = Arrays.copyOf(arr, arr.length);
        for (int i = 1; i < result.length; i++) {
            int key = result[i];
            int j = i - 1;
            while (j >= 0 && result[j] > key) {
                result[j + 1] = result[j];
                j--;
            }
            result[j + 1] = key;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = generateRandomArray(10000);
        long start, time;

        start = System.nanoTime();
        bubbleSort(arr);
        time = System.nanoTime() - start;
        System.out.println("BubbleSort: " + time);
        start = System.nanoTime();
        insertionSort(arr);
        time = System.nanoTime() - start;
        System.out.println("InsertionSort: " + time);
        start = System.nanoTime();
        Arrays.sort(arr);
        time = System.nanoTime() - start;
        System.out.println("Arrays.sort(): " + time);
    }
}
