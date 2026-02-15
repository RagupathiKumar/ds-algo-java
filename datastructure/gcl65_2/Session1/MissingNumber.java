package gcl65_2.Session1;

public class MissingNumber {

    public static void main(String[] args) {
        int[] arr = {3, 1, 0, 4};
        int n = arr.length;

        int arraySum = 0;
        for (int a : arr) {
            arraySum += a;
        }

        // approach 1
        int actualSum1 = 0;
        for (int i = 0; i <= n; i++) {
            actualSum1 += i;
        }

        // approach 2
        int actualSum2 = (n * (n + 1)) / 2;

        System.out.println(actualSum1 - arraySum);
        System.out.println(actualSum2 - arraySum);

        // assignment - array value [-n, n] TODO

    }

}
