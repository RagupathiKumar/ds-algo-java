package com.leetcode;

import java.util.Arrays;

public class TestIterativeSort {

    public static void main(String[] args) {
        bubbleSort(new int[] {7, 5, 2, 8, 1, 4, 3});
        insertionSort(new int[] {7, 5, 2, 8, 1, 4, 3});
        selectionSort(new int[] {7, 5, 2, 8, 1, 4, 3});
    }

    private static void selectionSort(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            int t = nums[min];
            nums[min] = nums[i];
            nums[i] = t;
        }

        System.out.println(Arrays.toString(nums));
    }

    private static void insertionSort(int[] nums) {
        int n = nums.length;

        for (int i = 1; i < n; i++) {

            int t = nums[i];
            int j = i - 1;

            while (j >= 0 && nums[j] > t) {
                nums[j + 1] = nums[j];
                j--;
            }

            nums[j + 1] = t;
        }

        System.out.println(Arrays.toString(nums));
    }

    private static void bubbleSort(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int t = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = t;
                }
            }
        }

        System.out.println(Arrays.toString(nums));
    }

}
