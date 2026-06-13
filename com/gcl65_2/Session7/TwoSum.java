package gcl65_2.Session7;

// https://leetcode.com/problems/two-sum/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] idxs = new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9); // 0, 1
        System.out.println(Arrays.toString(idxs));

        idxs = new TwoSum().twoSum(new int[]{3,2,4}, 6); // 1, 2
        System.out.println(Arrays.toString(idxs));

        idxs = new TwoSum().twoSum(new int[]{3, 3}, 6); // 0, 1
        System.out.println(Arrays.toString(idxs));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> idxMap = new HashMap<>();
        int n = nums.length, i = 0, j = 0;

        for (int idx = 0; idx < n; idx++) {
            int rem = target - nums[idx];
            if (idxMap.get(rem) != null) {
                i = idxMap.get(rem);
                j = idx;
                break;
            }
            idxMap.put(nums[idx], idx);
        }

        return new int[] {i, j};
    }

}
