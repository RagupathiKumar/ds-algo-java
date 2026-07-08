package leetcode.LeetCode75;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // 49
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{1, 2, 1})); // 2
    }

    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int i = 0, j = height.length - 1;
        while (i < j) {
            max = Math.max(Math.min(height[i], height[j]) * (j - i), max);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }

}
