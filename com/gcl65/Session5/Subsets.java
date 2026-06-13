package gcl65.Session5;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {

        List<List<Integer>> result = subsets(new int[] {1, 2, 3});
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    private static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int i = 0;

        subsets(nums, result, path, i);

        return result;
    }

    private static void subsets(int[] nums, List<List<Integer>> result, List<Integer> path, int i) {

        // base case
        if (i == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        // recursive case
        path.add(nums[i]);
        subsets(nums, result, path, i + 1); // included
        path.remove(path.size() - 1); // backtracking

        subsets(nums, result, path, i + 1); // excluded
    }

}
