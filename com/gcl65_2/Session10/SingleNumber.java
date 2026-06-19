package gcl65_2.Session10;
// https://leetcode.com/problems/single-number/description/
public class SingleNumber {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[] {2,2,1})); // 1
        System.out.println(singleNumber(new int[] {4,1,2,1,2})); // 4
        System.out.println(singleNumber(new int[] {1})); // 1
    }

    static int singleNumber(int[] nums) {
        int num = nums[0];
        for (int i = 1, n = nums.length; i < n; i++) {
            num ^= nums[i];
        }
        return num;
    }

}
