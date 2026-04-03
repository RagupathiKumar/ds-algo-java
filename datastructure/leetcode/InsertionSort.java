package leetcode;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11};
        sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {

            // traverse sorted part of the array
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int t = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = t;
                } else {
                    break;
                }
            }

        }
    }

}
