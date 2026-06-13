package gcl65.Session6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {

    public static void main(String[] args) {

        List<List<Integer>> result = new ArrayList<>();

        permutate(new int[] {1, 2, 3}, 0, result);

        for (List<Integer> list : result) {
            System.out.println(list);
        }

    }

    private static void permutate(int[] nums, int i, List<List<Integer>> result) {

        // base case
        if (i == nums.length) {
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }

        // recursive case
        for (int j = i; j < nums.length; j++) {
            swap(nums, i, j);
            permutate(nums, i + 1, result);

            swap(nums, j, i); // backtracking - to retain array to original state
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
