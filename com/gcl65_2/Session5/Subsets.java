package gcl65_2.Session5;

// https://leetcode.com/problems/subsets/

import java.util.ArrayList;
import java.util.List;

class Subsets {

    public static void main(String[] args) {
        List<List<Integer>> subsets = new Subsets().subsets(new int[]{1, 2, 3});
        for (List<Integer> subset : subsets) {
            if (subset.size() == 0) {
                System.out.print("EMPTY");
            } else {
                for (Integer num : subset) {
                    System.out.print(num + " ");
                }
            }
            System.out.println();
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        subsets(nums, result, path, 0, nums.length);
        return result;
    }

    private void subsets(int[] nums, List<List<Integer>> result, List<Integer> path, int i, int n) {
        // base case
        if (i == n) {
            result.add(new ArrayList<>(path));
            return;
        }

        // recursive case
        // include
        path.add(nums[i]);
        subsets(nums, result, path, i + 1, n);
        path.remove(path.size() - 1);

        // exclude
        subsets(nums, result, path, i + 1, n);
    }

}