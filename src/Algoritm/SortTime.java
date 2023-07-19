package Algoritm;

import java.util.Arrays;
import java.util.Random;

public class SortTime {
    public static void main(String[] args) {
        sortBubble(GenerateRandomArray());
        sortSelection(GenerateRandomArray());
        sortInsertion(GenerateRandomArray());
    }

    public static int[] GenerateRandomArray() {
        int[] arr = new int[100_000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }
        int copy[] = Arrays.copyOf(arr, arr.length);
        return copy;
    }

    public static void sortBubble(int[] copy) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy.length; j++) {
                if (copy[j] > copy[copy.length- 1]) {
                    swapElement(copy, i, j + 1);
                }
            }
        }
        System.out.println("bubblSpeed: " + (System.currentTimeMillis() - start));
    }
    public static void sortSelection(int[]copy) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < copy.length; i++) {
            int minElementIndex = i;
            for (int j = i+1; j < copy.length; j++) {
                if (copy[j] < copy[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElement(copy, i, minElementIndex);
        }
        System.out.println("selectionSpeed: " + (System.currentTimeMillis() - start));
    }

    public static void sortInsertion(int[] copy) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < copy.length; i++) {
            int temp = copy[i];
            int j = i;
            while (j > 0 && copy[j - 1] >= temp) {
                copy[j] = copy[j - 1];
                j--;
            }
            copy[j] = temp;
        }
        System.out.println("insertionSpeed: " + (System.currentTimeMillis() - start));
    }

    public static void swapElement(int[] copy, int indexA, int indexB) {
        int tmp = copy[indexA];
        copy[indexA] = copy[indexB];
        copy[indexB] = tmp;
    }
}
