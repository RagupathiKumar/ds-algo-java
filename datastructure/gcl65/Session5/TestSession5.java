package gcl65.Session5;

import java.util.ArrayList;
import java.util.List;

public class TestSession5 {

    public static void main(String[] args) {
        System.out.println(fact(5));

        System.out.println(fibonacci(6));

        printInIncSequence(5);
        System.out.println();

        printInDecSequence(5);
        System.out.println();

        System.out.println(pow(2, 5));
        System.out.println(powOptimised(2, 5));

        subsets(new int[] {1, 2, 3, 4});
    }

    private static void subsets(int[] arr) {
        List<Integer> path = new ArrayList<>();
        subsets(arr, path, 0);
    }

    private static void subsets(int[] arr, List<Integer> path, int i) {
        // base case
        if (i >= arr.length) {
            System.out.println(path);
            return;
        }

        // recursive case
        // include element in path
        path.add(arr[i]);
        subsets(arr, path, i + 1);
        path.remove(path.size() - 1); // backtracking

        // exclude element from path
        subsets(arr, path, i + 1);
    }

    private static int powOptimised(int a, int b) {
        // base case
        if (b == 0) {
            return 1;
        }
        // recursive case
        int product;
        if (b % 2 == 0) {
            product = powOptimised(a, b / 2) * powOptimised(a, b / 2);
        } else {
            product = powOptimised(a, b / 2) * powOptimised(a, b / 2) * 2;
        }
        return product;
    }

    private static int pow(int a, int b) {
        // base case
        if (b == 0) {
            return 1;
        }
        // recursive case
        return a * pow(a, b  - 1);
    }

    private static void printInDecSequence(int num) {
        // base case
        if (num == 0) {
            return;
        }
        // recursive case
        System.out.print(num + " ");
        printInDecSequence(num - 1);
    }

    private static void printInIncSequence(int num) {
        // base case
        if (num == 0) {
            return;
        }
        // recursive case
        printInIncSequence(num - 1);
        System.out.print(num + " ");
    }

    public static int fact(int num) {
        // base case
        if (num == 1) {
            return 1;
        }
        // recursive case
        return num * fact(num - 1);
    }

    public static int fibonacci(int num) {
        // base case
        if (num == 0 || num == 1) {
            return num;
        }
        // recursive case
        return fibonacci(num - 1) + fibonacci(num - 2);
    }

}
