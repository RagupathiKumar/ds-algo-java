package gcl65.Session10;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(largestRectangleArea(new int[]{6, 2, 5, 4, 5, 1, 6}));

        System.out.println(largestRectangleAreaChaman(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(largestRectangleAreaChaman(new int[]{6, 2, 5, 4, 5, 1, 6}));
    }

    // O(N ^ 2) Note:- Below solution time exceeded in LeetCode submit
    public static int largestRectangleArea(int[] heights) {

        int max = Integer.MIN_VALUE, n = heights.length;

        for (int i = 0; i < heights.length; i++) {
            int j1 = i, j2 = i;
            while (j1 > 0 && heights[j1 - 1] >= heights[i]) {
                j1--;
            }
            while (j2 < n - 1 && heights[j2 + 1] >= heights[i]) {
                j2++;
            }
            max = Math.max(max, (j2 - j1 + 1) * heights[i]);
        }

        return max;
    }

    public static int largestRectangleAreaChaman(int[] heights) {

        Stack<Integer> s = new Stack<>();
        int n = heights.length, max = Integer.MIN_VALUE, i = 0;

        while (i < n) {
            if (s.isEmpty() || heights[i] >= heights[s.peek()]) {
                s.push(i);
                i++;
            } else {
                int top = s.pop();
                int currArea = heights[top] * (s.isEmpty() ? i : (i - s.peek() - 1));
                max = Math.max(max, currArea);
            }
        }

        while (!s.isEmpty()) {
            int top = s.pop();
            int currArea = heights[top] * (s.isEmpty() ? i : (i - s.peek() - 1));
            max = Math.max(max, currArea);
        }

        return max;
    }

}
