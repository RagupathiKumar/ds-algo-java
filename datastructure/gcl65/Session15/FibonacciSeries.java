package gcl65.Session15;

import java.util.Arrays;

// solve it using DP
// Filius Bonacci aka Fibonacci (Paris, Italy)
public class FibonacciSeries {

    public static void main(String[] args) {
        int fibOfValue = 5;
        System.out.println(fibonacci(fibOfValue));
        System.out.println(fibonacciTopDown(fibOfValue));
        System.out.println(filiusBonacciBottomUp(fibOfValue));
        System.out.println(fib(fibOfValue));
    }

    static int fibonacci(int n) {
        // base case
        if (n == 0 || n == 1) {
            return n;
        }

        // recursive case
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    static int fibonacciTopDown(int n) {
        int[] memoizationArray = new int[n + 1];
        Arrays.fill(memoizationArray, -1);
        memoizationArray[0] = 0;
        memoizationArray[1] = 1;

        return fibonacciTopDown(n, memoizationArray);
    }

    static int fibonacciTopDown(int n, int[] memoizationArray) {
        // base case
        if (memoizationArray[n] != -1) {
            return memoizationArray[n];
        }

        // recursive case
        memoizationArray[n] = fibonacciTopDown(n - 1, memoizationArray) + fibonacciTopDown(n - 2, memoizationArray);
        return memoizationArray[n];
    }

    static int filiusBonacciBottomUp(int n) {
        int[] tabulationArray = new int[n + 1];
        Arrays.fill(tabulationArray, 0);
        tabulationArray[1] = 1;

        for (int i = 2; i <= n; i++) {
            tabulationArray[i] = tabulationArray[i - 1] + tabulationArray[i - 2];
        }

        return tabulationArray[n];
    }

    static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int a = 0, b = 1, c = -1;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

}