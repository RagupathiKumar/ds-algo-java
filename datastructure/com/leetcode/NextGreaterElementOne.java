package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElementOne {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[] {4,1,2}, new int[] {1,3,4,2})));
        System.out.println(Arrays.toString(nextGreaterElement(new int[] {2,4}, new int[] {1,2,3,4})));
        System.out.println(Arrays.toString(nextGreaterElement(new int[] {2,3}, new int[] {3, 2, 1, 4})));
        System.out.println(Arrays.toString(nextGreaterElement(new int[] {2,1,3}, new int[] {3, 2, 1, 4})));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int n1 = nums1.length, n2 = nums2.length;
        int[] ans = new int[n1];

        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums2[n2 - 1], -1);

        for (int i = n2 - 2; i >= 0; i--) {
            for (int j = i + 1; j < n2; j++) {
                if (nums2[j] > nums2[i]) {
                    map.put(nums2[i], nums2[j]);
                    break;
                }
            }
        }

        for (int i = 0; i < n1; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }

        return ans;
    }

}
