package gcl65_2.Session5;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {6, 9, 1, 4, 8, 5, 7, 3, 2};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int start, int end) {
        // base case
        if (start >= end) return;

        // recursive case
        int pivot = pivot(arr,  start, end);
        sort(arr, start, pivot - 1); // left
        sort(arr, pivot + 1, end); // right
    }

    private static int pivot(int[] arr, int start, int end) {
        int p = end, i = start - 1;
        for (int j = start; j < end; j++) {
            if (arr[j] < arr[p]) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, p);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
