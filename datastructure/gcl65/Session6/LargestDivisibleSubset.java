package gcl65.Session6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset {

    // not working yet
    public static void main(String[] args) {

//        System.out.println(new LargestDivisibleSubset().largestDivisibleSubset(new int[]{1, 2, 4, 8}));
        System.out.println(new LargestDivisibleSubset().largestDivisibleSubset(new int[]{5,9,18,54,108,540,90,180,360,720}));

    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        largestDivisibleSubset(nums, 0, path, result);

        return result;
    }

    private void largestDivisibleSubset(int[] nums, int i, List<Integer> path, List<Integer> result) {

        // base case
        if (i == nums.length) {
            if (satisfies(path) && path.size() > result.size()) {
                result.clear();
                result.addAll(path);
            }
            return;
        }

        // recursive case
        path.add(nums[i]); // include
        largestDivisibleSubset(nums, i + 1, path, result);
        path.remove(path.size() - 1); // backtracking

        largestDivisibleSubset(nums, i + 1, path, result); // exclude
    }

    private boolean satisfies(List<Integer> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            if (list.get(i) % list.get(i + 1) != 0 && list.get(i + 1) % list.get(i) != 0) {
                return false;
            }
        }
        return true;
    }

}
