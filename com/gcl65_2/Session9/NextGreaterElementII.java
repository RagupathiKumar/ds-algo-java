package gcl65_2.Session9;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {

    public static void main(String[] args) {
        System.out.println(Arrays.asList(nextGreaterElements(new int[] {1, 2, 3, 4, 6, 4, 5, 3, 4}))); // [2, 3, 4, 6, -1, 5, 6, 4, 6]
    }

    static int[] nextGreaterElements(int[] nums) {

        int n = nums.length;

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                ans[stack.pop()] = nums[i];
            }
            stack.push(i);
        }



        return null;
    }

}
