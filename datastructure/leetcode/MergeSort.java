package leetcode;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {6, 5, 1, 2, 4, 0, 7};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int s, int e) {
        // base case
        if (s == e) return;

        // recursive case
        int mid = s + (e - s) / 2;

        sort(arr, s, mid);
        sort(arr, mid + 1, e);

        merge(arr, s, mid, e);
    }

    private static void merge(int[] arr, int s, int mid, int e) {
        int len1 = mid - s + 1;
        int len2 = e - (mid + 1) + 1;
        int[] temp = new int[len1 + len2];
        int idx = 0;

        int i = s, j = mid + 1;
        while (i <= mid && j <= e) {
            if (arr[i] <= arr[j]) {
                temp[idx++] = arr[i++];
            } else {
                temp[idx++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[idx++] = arr[i++];
        }
        while (j <= e) {
            temp[idx++] = arr[j++];
        }

        for (int index = 0; index < temp.length; index++) { // update source array
            arr[s + index] = temp[index];
        }
    }

}
