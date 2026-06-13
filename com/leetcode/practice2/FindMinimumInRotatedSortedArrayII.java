package leetcode.practice2;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii

public class FindMinimumInRotatedSortedArrayII {

    public static void main(String[] args) {
        System.out.println(findMin(new int[] {4, 5, 6, 7, 0, 1, 4}));
        System.out.println(findMin(new int[] {7, 0, 1, 4, 4, 5, 6}));
        System.out.println(findMin(new int[] {0, 1, 4, 4, 5, 6, 7}));

        System.out.println(findMin(new int[] {2, 2, 2, 0, 1}));
        System.out.println(findMin(new int[] {2, 0, 1, 2, 2}));
        System.out.println(findMin(new int[] {0, 1, 2, 2, 2}));

        System.out.println(findMin(new int[] {2, 2, 2, 0, 2}));
        System.out.println(findMin(new int[] {2, 0, 2, 2, 2}));
        System.out.println(findMin(new int[] {0, 2, 2, 2, 2}));

        System.out.println(findMin(new int[] {3, 1}));

        System.out.println(findMin(new int[] {10, 10, 1, 10, 10}));
    }

    static int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1, nums.length);
    }

    private static int findMin(int[] nums, int s, int e, int n) {
        // base case
        if (s >= e) {
            return nums[s < n ? s : e];
        }

        // recursive case
        int min = Integer.MAX_VALUE;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            min = Integer.min(nums[mid], min);
            if (nums[mid] >= nums[s] && nums[mid] > nums[e]) {
                s = mid + 1;
            } else if (nums[mid] < nums[s] && nums[mid] <= nums[e]) {
                e = mid - 1;
            } else {
                int left = findMin(nums, s, mid - 1, n);
                int right = findMin(nums, mid + 1, e, n);
                min = Math.min(Math.min(left, right), min);
                break;
            }
        }
        return min;
    }

}
