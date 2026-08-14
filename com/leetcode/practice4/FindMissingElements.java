package leetcode.practice4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMissingElements {

    public static void main(String[] args) {
        System.out.println(findMissingElements(new int[]{1, 4, 2, 5})); // 3
        System.out.println(findMissingElements(new int[]{7, 8, 6, 9})); //
        System.out.println(findMissingElements(new int[]{5, 1})); // 234
    }

    static List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        int n = nums.length, j = 0;
        for (int num = nums[0]; num <= nums[n - 1]; num++) {
            if (num != nums[j]) {
                result.add(num);
            } else {
                j++;
            }
        }
        return result;
    }

}
