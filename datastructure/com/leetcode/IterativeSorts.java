package com.leetcode;

import java.util.Arrays;

public class IterativeSorts {

    public static void main(String[] args) {
        bubbleSort(new int[] {7, 5, 2, 8, 1, 4, 3});
        insertionSort(new int[] {7, 5, 2, 8, 1, 4, 3});
        selectionSort(new int[] {7, 5, 2, 8, 1, 4, 3});
    }

    private static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n - 1 - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    int t = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = t;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int temp = arr[i];

            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int t = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = t;
        }

        System.out.println(Arrays.toString(arr));
    }

}
