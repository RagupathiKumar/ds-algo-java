package gcl65_2.Session4;

import java.util.Arrays;

public class BubbleSort2 {

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11};
        sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {

            // traverse unsorted part of array and swap always
            for (int j = n - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    int t = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = t;
                }
            }

        }
    }

}
