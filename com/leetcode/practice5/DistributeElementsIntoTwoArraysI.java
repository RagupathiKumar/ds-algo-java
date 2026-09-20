package leetcode.practice5;

import java.util.Arrays;

public class DistributeElementsIntoTwoArraysI {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(resultArray(new int[]{2, 1, 3})));
        System.out.println(Arrays.toString(resultArray(new int[]{5, 4, 3, 8})));
        System.out.println(Arrays.toString(resultArray(new int[]{1, 2, 4})));
    }

    static int[] resultArray(int[] nums) {
        int n = nums.length, i = 0, j = 0;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        arr1[0] = nums[0];
        arr2[0] = nums[1];

        for (int idx = 2; idx < n; idx++) {
            if (arr1[i] > arr2[j]) {
                arr1[++i] = nums[idx];
            } else {
                arr2[++j] = nums[idx];
            }
        }

        int idx = 0;
        int[] arr = new int[n];
        for (int num : arr1) {
            if (num == 0) {
                break;
            }
            arr[idx++] = num;
        }
        for (int num : arr2) {
            if (num == 0) {
                break;
            }
            arr[idx++] = num;
        }
        return arr;
    }

}
