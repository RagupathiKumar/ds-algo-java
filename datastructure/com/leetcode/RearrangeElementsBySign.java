package com.leetcode;

import java.util.Arrays;

public class RearrangeElementsBySign {

    public static void main(String[] args) {
        int[] arr = new RearrangeElementsBySign().rearrangeArray(new int[]{28,-41,22,-8,-37,46,35,-9,18,-6,19,-26,-37,-10,-9,15,14,31});
        System.out.println(Arrays.toString(arr));
    }

    public int[] rearrangeArray(int[] nums) {

        int n = nums.length, i = 0;
        boolean isPositive = true;

        for (int j = 0; j < n; j++) {
            if ((isPositive && nums[j] >= 0) || (!isPositive && nums[j] < 0)) {

                int t = nums[j];
                for (int k = j; k > i; k--) {
                    nums[k] = nums[k - 1];
                }
                nums[i] = t;

                j = i;
                i++;
                isPositive = !isPositive;
            }
        }
        return nums;
    }
}
