package leetcode.problemset;

// https://leetcode.com/problems/minimum-element-after-replacement-with-digit-sum/

public class MinimumElementAfterReplacementWithDigitSum {

    public static void main(String[] args) {
        System.out.println(minElement(new int[] {10,12,13,14})); // 1
        System.out.println(minElement(new int[] {1,2,3,4})); // 1
        System.out.println(minElement(new int[] {999,19,199})); // 10
    }

    static int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            while (nums[i] > 0) {
                sum += nums[i] % 10;
                nums[i] /= 10;
            }
            min = Math.min(sum, min);
        }
        return min;
    }

}
