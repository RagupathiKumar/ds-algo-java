package gcl65_2.Session5;

// Fibpnacci Number at ith position
class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fib(0));
        System.out.println(fib(1));
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
        System.out.println(fib(5));
        System.out.println(fib(6));
        System.out.println(fib(7));

        System.out.println(fib(7));
    }

    private static int fib(int i) {
        // base case
        if (i == 1 || i == 0) {
            return i;
        }

        // recursive case
        return fib(i - 1) + fib(i - 2);
    }

    private static int fib2(int n) {
        if (n == 0 || n == 1) return n;

        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

}  