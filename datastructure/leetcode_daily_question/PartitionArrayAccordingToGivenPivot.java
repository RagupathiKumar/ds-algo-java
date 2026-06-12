package leetcode_daily_question;

// https://leetcode.com/problems/partition-array-according-to-given-pivot/description/

import java.util.Arrays;

public class PartitionArrayAccordingToGivenPivot {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(pivotArray(new int[]{9, 12, 5, 10, 14, 3, 10}, 10))); // [9,5,3,10,10,12,14]
        System.out.println(Arrays.toString(pivotArray(new int[]{-3, 4, 3, 2}, 2))); // [-3,2,4,3]
    }

    static int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;

        int s = 0, e = n - 2;
        while (s < e) {
            if (nums[s] <= pivot) {
                s++;
            } else {
                int t = nums[s];
                nums[s] = nums[e];
                nums[e--] = t;
            }
        }

        int t = nums[s];
        nums[s] = nums[n - 1];
        nums[n - 1] = t;
        return nums;
    }

}
