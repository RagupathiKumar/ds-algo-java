package gcl65_2.Session6;

// https://leetcode.com/problems/permutations-ii/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII {

    public static void main(String[] args) {
        List<List<Integer>> results = new PermutationsII().permuteUnique(new int[]{1, 1, 2});
        for (List<Integer> result : results) {
            System.out.println(result);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> results = new HashSet<>();
        permuteUnique(nums, nums.length, 0, results);
        return new ArrayList<>(results);
    }

    private void permuteUnique(int[] nums, int n, int i, Set<List<Integer>> results) {
        // base case
        if (i == n) {
            List<Integer> path = new ArrayList<>();
            for (int num : nums) path.add(num);
            results.add(path);
            return;
        }

        // recursive case
        for (int j = i; j < n; j++) {
            swap(nums, i, j);
            permuteUnique(nums, nums.length, i + 1, results);
            swap(nums, i, j); // backtracking
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
