package gcl65.Session5;

import java.util.ArrayList;
import java.util.List;

public class SubArray {

    public static void main(String[] args) {

        List<List<Integer>> result = subarray(new int[] {1, 2, 3});
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    private static List<List<Integer>> subarray(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            List<Integer> path = new ArrayList<>();
            subarray(nums, result, path, i);
        }

        return result;
    }

    private static void subarray(int[] nums, List<List<Integer>> result, List<Integer> path, int i) {

        // base case
        if (i == nums.length) {
            return;
        }

        // recursive case
        path.add(nums[i]);
        result.add(new ArrayList<>(path));
        subarray(nums, result, path, i + 1);
    }

}
