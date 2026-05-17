package gcl65_2.Session2;

// https://leetcode.com/problems/contains-duplicate-ii/

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[] {1,2,3,1}, 3)); // true
        System.out.println(containsNearbyDuplicate(new int[] {1,0,1,1}, 1)); // true
        System.out.println(containsNearbyDuplicate(new int[] {1,2,3,1,2,3}, 2)); // false

        System.out.println(containsNearbyDuplicate2(new int[] {1,2,3,1}, 3)); // true
        System.out.println(containsNearbyDuplicate2(new int[] {1,0,1,1}, 1)); // true
        System.out.println(containsNearbyDuplicate2(new int[] {1,2,3,1,2,3}, 2)); // false
    }

    // O(n*k) & O(1)
    static boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int m = Math.min((i + 1 + k), n);
            for (int j = i + 1; j < m; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // O(n) & O(n)
    static boolean containsNearbyDuplicate2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

}
