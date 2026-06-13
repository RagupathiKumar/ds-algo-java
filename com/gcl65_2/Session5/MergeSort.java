package gcl65_2.Session5;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {6, 5, 1, 2, 4, 0};
        new MergeSort().sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private void sort(int[] arr, int s, int e) {
        // base case
        if (s >= e) return;

        // recursive case
        int mid = s + ((e - s) / 2);

        sort(arr, s, mid); // left array
        sort(arr, mid + 1, e); // right array

        merge(arr, s, mid, e);
    }

    private void merge(int[] arr, int s, int mid, int e) {
        int n = (mid - s + 1) + (e - (mid + 1) + 1);
        int[] temp = new int[n];
        int i = s, j = mid + 1, k = 0;

        while (i <= mid && j <= e) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= e) {
            temp[k++] = arr[j++];
        }

        for (int idx = 0; idx < n; idx++) { // update source array
            arr[s + idx] = temp[idx];
        }
    }

}