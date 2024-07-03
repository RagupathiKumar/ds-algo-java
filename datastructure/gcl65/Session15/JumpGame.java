package gcl65.Session15;

public class JumpGame {

    // solution not working for all cases
    public boolean canJump(int[] nums) {
        int i = nums[0] - 1, n = nums.length;

        if (i > 0) {
            while (i < n && nums[i] > 0) {
                i += nums[i];
            }
        } else {
            i = 0;
        }

        return i >= n - 1;
    }

}