package leetcode.LeetCode75;

public class FindTheHighestAltitude {

    public int largestAltitude(int[] gain) {
        int alt = 0, max = 0;
        for (int g : gain) {
            alt += g;
            max = Math.max(alt, max);
        }
        return max;
    }

}
