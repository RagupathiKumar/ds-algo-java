package gcl65_2.Session5;

class IncDecSequence{

    public static void main(String[] args) {
        decreasingOrder(6);
        System.out.println();
        increasingOrder(6);
    }

    private static void decreasingOrder(int n) {
        // base case
        if (n == 0) return;

        // recursive case
        System.out.print(n + " ");
        decreasingOrder(n - 1);
    }

    private static void increasingOrder(int n) {
        // base case
        if (n == 0) return;

        // recursive case
        increasingOrder(n - 1);
        System.out.print(n + " ");
    }
}  