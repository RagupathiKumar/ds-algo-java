package gcl65_2.Session10;

// https://leetcode.com/problems/largest-rectangle-in-histogram/description/

import java.util.Stack;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3})); // 10
        System.out.println(largestRectangleArea(new int[]{2, 4})); // 4
        System.out.println(largestRectangleArea(new int[]{2, 5, 4, 1, 5})); // 8
        System.out.println();
        System.out.println(largestRectangleArea2(new int[]{2, 1, 5, 6, 2, 3})); // 10
        System.out.println(largestRectangleArea2(new int[]{2, 4})); // 4
        System.out.println(largestRectangleArea2(new int[]{2, 5, 4, 1, 5})); // 8
    }

    // Brute Force Approach -- Time Limit Exceeded -- Formula used (height * (right - left - 1))
    static int largestRectangleArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0, n = heights.length; i < n; i++) {
            int height = heights[i];

            int left = i - 1;
            while (left >= 0 && heights[left] >= height) {
                left--;
            }

            int right = i + 1;
            while (right < n && heights[right] >= height) {
                right++;
            }

            maxArea = Math.max(height * (right - left - 1), maxArea);
        }
        return maxArea;
    }

    // Approach 2 - Formula used (height * (i - (peek or -1) - 1))
    static int largestRectangleArea2(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();

        int i = 0;
        while (i < heights.length) {
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int area = heights[st.pop()] * (i - (!st.isEmpty() ? st.peek() : -1) - 1);
                maxArea = Math.max(area, maxArea);
            }
            st.push(i);
            i++;
        }

        while (!st.isEmpty()) {
            int area = heights[st.pop()] * (i - (!st.isEmpty() ? st.peek() : -1) - 1);
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }

}
