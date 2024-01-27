package gcl65.Session5;

public class Power {

    public static void main(String[] args) {
        System.out.println(pow(5, 3));
        System.out.println(powOptimized(5, 3));
    }

    private static int pow(int a, int b) {
        // base case
        if (b == 0) { // if (b == 1) { -- will not work for 5 power 0
            return 1;
        }

        // recursive case
        return a * pow(a, b - 1);
    }

    private static int powOptimized(int a, int b) {
        // base case
        if (b == 0) {
            return 1;
        }

        // recursive case
        if (b % 2 == 0) {
            return powOptimized(a, b / 2) * powOptimized(a, b / 2);
        }
        return powOptimized(a, b / 2) * powOptimized(a, b / 2) * a;
    }

}
