package gcl65.Session7;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static void main(String[] args) {
//        System.out.println(subarraySum(new int[] {1, 1, 1}, 2));
//        System.out.println(subarraySum(new int[] {1, 2, 3}, 3));
//        System.out.println(subarraySumNg(new int[] {1}, 0));
        System.out.println(subarraySum(new int[] {3, 4, 7, 2, -3, 1, 4, 2, 1}, 7));
    }

    private static int subarraySumNg(int[] arr, int k) {

        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == k) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private static int subarraySum(int[] nums, int k) {

        int cnt = 0, prevSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            prevSum += num;
            if (map.containsKey(prevSum - k)) {
                cnt += map.get(prevSum - k);
            }
            map.compute(prevSum, (key, v) -> v == null ? 1 : v + 1);
        }

        return cnt;
    }

}
