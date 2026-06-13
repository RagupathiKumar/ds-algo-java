package gcl65.Session5;

import java.util.ArrayList;
import java.util.Arrays;
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

        subsets(new int[]{1, 2, 3, 4});
        System.out.println();

        int[] arr = {6, 5, 1, 2, 4, 0};
        int[] result = mergeSort(arr);
        System.out.println(Arrays.toString(result));

        int[][] mat = {
                {1, 1, 1, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 1, 0, 0, 1}
        };
        System.out.println(numOfIslands(mat));;
    }

    private static int numOfIslands(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;

        int count = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (mat[r][c] == 1) {
                    count++;
                    dfs(mat, r, rows, c, cols);
                }
            }
        }
        return count;
    }

    private static void dfs(int[][] mat, int r, int rows, int c, int cols) {
        // base case
        if (r < 0 || r >= rows || c < 0 || c >= cols || mat[r][c] != 1) {
            return;
        }

        // recursive case
        mat[r][c] = 2;
        dfs(mat, r, rows, c - 1, cols); // left
        dfs(mat, r - 1, rows, c, cols); // up
        dfs(mat, r, rows, c + 1, cols); // right
        dfs(mat, r + 1, rows, c, cols); // down
    }

    private static int[] mergeSort(int[] arr) {
        int s = 0, e = arr.length - 1;
        return mergeSort(arr, s, e);
    }

    private static int[] mergeSort(int[] arr, int s, int e) {
        // base case
        if (s == e) {
            return new int[]{arr[s]};
        }

        // recursive case
        // divide
        int m = s + (e - s) / 2;
        int[] left = mergeSort(arr, s, m);
        int[] right = mergeSort(arr, m + 1, e);

        // conquer
        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int l = 0, r = 0, n = left.length, m = right.length;
        int[] temp = new int[n + m];
        int i = 0;

        while (l < n && r < m) {
            if (left[l] < right[r]) {
                temp[i++] = left[l++];
            } else {
                temp[i++] = right[r++];
            }
        }

        while (l < n) {
            temp[i++] = left[l++];
        }

        while (r < m) {
            temp[i++] = right[r++];
        }

        return temp;
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
        return a * pow(a, b - 1);
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
