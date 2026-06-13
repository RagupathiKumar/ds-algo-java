package gcl65_2.Session1;

// https://leetcode.com/problems/climbing-stairs/

public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs2(2));
        System.out.println(climbStairs2(3));
        System.out.println(climbStairs2(5));
    }

    static int climbStairs2(int n) {
        int a = 1, b = 1;
        for (int i = 1; i < n; i++) {
            int t = b + a;
            a = b;
            b = t;
        }
        return b;
    }

    // TIME OUT
    static int climbStairs(int n) {
        return climbStairs(n, 0);
    }

    private static int climbStairs(int n, int i) {
        // base case
        if (i == n) {
            return 1;
        } else if (i > n) {
            return 0;
        }

        // recursive case
        int cnt = 0;
        for (int j = 1; j <= 2; j++) {
            cnt += climbStairs(n, i + j);
        }
        return cnt;
    }

}
