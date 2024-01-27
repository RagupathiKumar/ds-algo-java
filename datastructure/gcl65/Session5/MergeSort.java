package gcl65.Session5;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int[] arr = {6, 5, 1, 2, 4, 0};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));


        int[] result = mergeSortV2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(result));
    }

    private static int[] mergeSortV2(int[] arr, int s, int e) {
        // base case
        if (s == e) {
            return new int[] { arr[s] };
        }

        // recursive case
        int m = s + (e - s) / 2;
        int[] left = mergeSortV2(arr, s, m);
        int[] right = mergeSortV2(arr, m + 1, e);

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {

        int leftN = left.length;
        int rightN = right.length;
        int[] t = new int[leftN + rightN];
        int l = 0, r = 0, k = 0;

        while (l < leftN && r < rightN) {
            if (left[l] < right[r]) {
                t[k++] = left[l++];
            } else {
                t[k++] = right[r++];
            }
        }

        while (l < leftN) {
            t[k++] = left[l++];
        }

        while (r < rightN) {
            t[k++] = right[r++];
        }

        return t;
    }

    private static void mergeSort(int[] arr, int s, int e) {
        // base case
        if (s == e) {
            return;
        }

        // recursive case
        int m = s + (e - s) / 2;
        mergeSort(arr, s, m);
        mergeSort(arr, m + 1, e);

        merge(arr, s, m, e);
    }

    private static void merge(int[] arr, int s, int m, int e) {

        int[] t = new int[e - s + 1];
        int i = s, j = m + 1, k = 0;

        while (i <= m && j <= e) {
            if (arr[i] < arr[j]) {
                t[k++] = arr[i++];
            } else {
                t[k++] = arr[j++];
            }
        }

        while (i <= m) {
            t[k++] = arr[i++];
        }

        while (j <= e) {
            t[k++] = arr[j++];
        }

        for (int idx = 0; idx < t.length; idx++) {
            arr[s + idx] = t[idx];
        }
    }

}
