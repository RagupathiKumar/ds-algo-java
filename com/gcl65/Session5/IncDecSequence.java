package gcl65.Session5;

public class IncDecSequence {

    public static void main(String[] args) {
        inc(5);
        dec(5);
    }

    private static void dec(int n) {
        // base case
        if (n == 0) {
            return;
        }
        System.out.println(n);
        dec(n - 1);
    }

    private static void inc(int n) {
        // base case
        if (n == 0) {
            return;
        }
        inc(n - 1);
        System.out.println(n);
    }

}
