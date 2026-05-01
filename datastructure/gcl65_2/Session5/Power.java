package gcl65_2.Session5;

class Power{

    public static void main(String[] args) {
        System.out.println(pow(5, 8));

        System.out.println(pow2(5, 8));
        System.out.println(pow2(5, 11));
    }

    private static int pow(int a, int b) {
        // base case
        if (b == 0) return 1;

        // recursive
        return a * pow(a, b - 1);
    }

    private static int pow2(int a, int b) {
        // base case
        if (b == 0) return 1;

        // recursive case
        int halfPow = pow2(a, b / 2);
        if (b % 2 == 0) {
            return halfPow * halfPow;
        } else {
            return halfPow * halfPow * a;
        }
    }
}  