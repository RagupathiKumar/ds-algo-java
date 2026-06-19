package leetcode.practice3;
// https://leetcode.com/problems/find-the-highest-altitude/description/
public class FindTheHighestAltitude {

    public static void main(String[] args) {
        System.out.println(largestAltitude(new int[]{-5,1,5,0,-7})); // 1
        System.out.println(largestAltitude(new int[]{-4,-3,-2,-1,4,3,2})); // 0
    }

    static int largestAltitude(int[] gain) {
        int max = 0;
        for (int i = 0, alt = 0; i < gain.length; i++) {
            alt += gain[i];
            max = Math.max(alt, max);
        }
        return max;
    }

}