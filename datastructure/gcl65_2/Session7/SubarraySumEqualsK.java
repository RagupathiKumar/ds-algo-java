package gcl65_2.Session7;

// https://leetcode.com/problems/subarray-sum-equals-k/

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static void main(String[] args) {
        System.out.println(new SubarraySumEqualsK().subarraySum(new int[] {3, 4, 7, 2, -3, 1, 4, 2, 1}, 7));
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(k, 1);

        int n = nums.length, sum = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                cnt += map.get(sum);
            }
            map.put(sum + k, map.getOrDefault(sum + k, 0) + 1);
        }
        return cnt;
    }

}
