package gcl65_2.Session6;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/permutations/

public class Permutations {

    public static void main(String[] args) {
        List<List<Integer>> results = new Permutations().permute(new int[]{1, 2, 3});
        for (List<Integer> result : results) {
            System.out.println(result.toString());
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        permute(nums, nums.length, 0, results);
        return results;
    }

    private void permute(int[] nums, int n, int i, List<List<Integer>> results) {
        // base case
        if (i == n) {
            List<Integer> path = new ArrayList<>();
            for (int num : nums) path.add(num);
            results.add(path);
            return;
        }

        // recursive case
        for (int j = i; j < n; j++) {
            swap(nums, i , j);
            permute(nums, nums.length, i + 1, results);
            swap(nums, i , j); // backtracking
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


}
