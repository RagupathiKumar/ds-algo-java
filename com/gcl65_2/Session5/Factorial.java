package gcl65_2.Session5;

class Factorial{

    public static void main(String[] args) {
        System.out.println(fact(5));
        System.out.println(fact(0));
        System.out.println(fact(1));
    }

    private static int fact(int n) {
        // base case
        if (n == 0) return 1;

        // recursive case
        return n * fact(n - 1);
    }

}  