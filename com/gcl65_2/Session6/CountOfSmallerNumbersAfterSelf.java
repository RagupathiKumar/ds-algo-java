package gcl65_2.Session6;

// https://leetcode.com/problems/count-of-smaller-numbers-after-self/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {

    public static void main(String[] args) {
        System.out.println(new CountOfSmallerNumbersAfterSelf().countSmaller(new int[] {5,2,6,1}));
        System.out.println(new CountOfSmallerNumbersAfterSelf().countSmaller(new int[] {5,2,4,3,1}));
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>(Collections.nCopies(nums.length, 0));
        countSmaller(nums, 0, nums.length - 1, result);
        return result;
    }

    private void countSmaller(int[] nums, int s, int e, List<Integer> result) {
        // base case
        if (s >= e) {
            return;
        }

        // recursive case
        int mid = s + (e - s) / 2;
        countSmaller(nums, s, mid, result); // left
        countSmaller(nums, mid + 1, e, result); // right

        for (int i = s; i <= mid; i++) {
            for (int j = mid + 1; j <= e; j++) {
                if (nums[i] > nums[j]) {
                    result.set(i, result.get(i) + 1);
                }
            }
        }
    }

}
