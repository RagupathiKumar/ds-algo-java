package gcl65.Session16;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequenceApproach1 {

    public static void main(String[] args) {
        LongestIncreasingSubsequenceApproach1 app = new LongestIncreasingSubsequenceApproach1();
        System.out.println(app.lengthOfLIS(new int[] {10,9,2,5,3,7,101,18})); // 4
        System.out.println(app.lengthOfLIS(new int[] {9,2,4,10,1,6,7,15,3})); // 5
        System.out.println(app.lengthOfLIS(new int[] {2,10,3,4,7})); // 4
        System.out.println(app.lengthOfLIS(new int[] {8,4,6,1,9,10,2,5,7,0})); // 4
        System.out.println(app.lengthOfLIS(new int[] {3,1,5,2,7})); // 3
        System.out.println(app.lengthOfLIS(new int[] {7,7,7,7,7,7,7})); // 1
    }

    // Approach 1 : Generate all subsequence
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        return lengthOfLIS(nums, 0, list);
    }

    public int lengthOfLIS(int[] nums, int i, List<Integer> list) {
        // base case
        if (i >= nums.length) {
            return getLIS(list);
        }

        // recursive case
        list.add(nums[i]);
        int longest = lengthOfLIS(nums, i + 1, list);

        list.remove(list.size() - 1); // backtracking
        return Math.max(longest, lengthOfLIS(nums, i + 1, list));
    }

    private int getLIS(List<Integer> list) {
        boolean isValid = true;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                isValid = false;
                break;
            }
        }
        return isValid ? list.size() : -1;
    }

}