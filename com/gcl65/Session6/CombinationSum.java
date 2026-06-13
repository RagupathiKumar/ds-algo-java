package gcl65.Session6;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        comb(new int[] {2, 3, 5}, 8, 0, new ArrayList<>(), result);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    private static void comb(int[] nums, int target, int i, List<Integer> path, List<List<Integer>> result) {

        // base case
        if (i == nums.length) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        // recursive case
        if (target > 0) {
            path.add(nums[i]);
            comb(nums, target - nums[i], i, path, result);
            path.remove(path.size() - 1);
        }

        comb(nums, target, i + 1, path, result);
    }

}
