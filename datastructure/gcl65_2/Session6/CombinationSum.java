package gcl65_2.Session6;

// https://leetcode.com/problems/combination-sum/description/

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        List<List<Integer>> results = new CombinationSum().combinationSum(new int[]{2, 3, 5}, 8);
        results.forEach(r -> System.out.println(r));
        System.out.println();

        results = new CombinationSum().combinationSum(new int[]{2}, 1);
        results.forEach(r -> System.out.println(r));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        combinationSum(candidates, target, 0, 0, path, results);
        return results;
    }

    private void combinationSum(int[] candidates, int target, int i, int pathSum, List<Integer> path, List<List<Integer>> results) {
        // base case
        if (pathSum > target) {
            return;
        } else if (pathSum == target) {
            results.add(new ArrayList<>(path));
            return;
        }

        // recursive case
        for (int idx = i; idx < candidates.length; idx++) {
            path.add(candidates[idx]);
            combinationSum(candidates, target, idx, pathSum + candidates[idx], path, results);
            path.remove(path.size() - 1); // backtracking
        }
    }

}
