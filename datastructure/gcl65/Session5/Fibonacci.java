package gcl65.Session5;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fib(6));
    }

    private static int fib(int n) {
        // base case
        if (n == 0 || n == 1) {
            return n;
        }
        // recursive case
        return fib(n - 1) + fib(n - 2);
    }

}
