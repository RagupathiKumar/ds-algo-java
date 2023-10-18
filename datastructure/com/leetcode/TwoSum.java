package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class TwoSum {

    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{2, 11, 8, 15, 7}, 17);
        System.out.println(Arrays.toString(ints));

        ints = twoSum(new int[] {3, 3}, 6);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] twoSum(int[] nums, int target) {

        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> tempList = new ArrayList<>(list);
        Collections.sort(list);

        int[] result = new int[2];
        int i = 0;
        int j = list.size() - 1;

        while (i < j) {
            int sum = list.get(i) + list.get(j);
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                result[0] = tempList.indexOf(list.get(i));
                result[1] = tempList.lastIndexOf(list.get(j));
                break;
            }
        }

        return result;
    }

}
