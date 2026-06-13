package leetcode.practice2;


// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/

public class CheckIfArrayIsSortedAndRotated {

    public static void main(String[] args) {
        System.out.println(check(new int[]{3, 4, 5, 1, 2})); // true
        System.out.println(check(new int[]{5, 1, 2, 3, 4})); // true
        System.out.println(check(new int[]{1, 2, 3, 4, 5})); // true
        System.out.println(check(new int[]{2, 1, 3, 4})); // false
        System.out.println(check(new int[]{10, 1, 1, 10})); // true
        System.out.println(check(new int[]{3,6,10,1,8,9,9,8,9})); // false
    }

    static boolean check(int[] nums) {
        int n = nums.length - 1, cnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[i + 1]) {
                cnt++;
            }
        }
        return (cnt == 0 && nums[0] <= nums[n]) || (cnt == 1 && nums[0] >= nums[n]);
    }

}
