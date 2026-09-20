package leetcode.LeetCode75;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{5, 10, -5}))); // 5,10
        System.out.println(Arrays.toString(asteroidCollision(new int[]{8, -8})));       //
        System.out.println(Arrays.toString(asteroidCollision(new int[]{10, 2, -5})));  // 10
        System.out.println(Arrays.toString(asteroidCollision(new int[]{3, 5, -6, 2, -1, 4}))); // -6,2,4

        System.out.println(Arrays.toString(asteroidCollision(new int[]{-2, -1, 1, 2}))); // -2,-1,1,2
    }

    static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int size : asteroids) {
            if (size > 0) {
                Integer astSize = st.peek();
                st.push(size);

            } else {

                while (!st.isEmpty()) {
                    Integer astSize = st.peek();
                    if (astSize < (size * -1)) {
                        st.pop();
                    } else if (astSize > (size * -1)) {
                        size = 0;
                        break;
                    } else {
                        st.pop();
                        size = 0;
                        break;
                    }
                }

                if (size != 0) {
                    st.push(size);
                }
            }
        }

        int n = st.size();
        int[] arr = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = st.pop();
        }
        return arr;
    }

}
