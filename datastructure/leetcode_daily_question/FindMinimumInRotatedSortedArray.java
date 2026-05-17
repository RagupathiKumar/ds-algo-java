package leetcode_daily_question;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(findMin(new int[] {4,5,6,7,0,1,2}));
        System.out.println(findMin(new int[] {5,1,2,3,4}));
    }

    static int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;

        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;

            min = Integer.min(nums[mid], min);
            if (nums[s] < nums[e]) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }

        }
        return min;
    }

}
