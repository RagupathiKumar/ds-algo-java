package leetcode.practice2;

// https://leetcode.com/problems/pascals-triangle/

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args) {
        List<List<Integer>> triangle = generate2(5);
        for (List<Integer> row : triangle) {
            System.out.println(row);
        }
    }

    static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        generate(numRows, new ArrayList<>(), triangle);
        return triangle;
    }

    static void generate(int numRows, List<Integer> prevRow, List<List<Integer>> triangle) {
        // base case
        if (triangle.size() == numRows) {
            return;
        }

        // recursive case
        List<Integer> currRow = new ArrayList<>();
        if (triangle.size() == 0) {
            currRow.add(1);
        } else {
            int n = prevRow.size();
            for (int i = 0; i < n + 1; i++) {
                currRow.add((i - 1 < 0 ? 0 : prevRow.get(i - 1)) + (i > n - 1 ? 0 : prevRow.get(i)));
            }
        }
        triangle.add(currRow);

        generate(numRows, currRow, triangle);
    }

    static List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        List<Integer> prevRow = null;
        for (int i = 0; i < numRows; i++) {
            List<Integer> currRow = new ArrayList<>();
            if (i == 0) {
                currRow.add(1);
            } else {
                int n = prevRow.size();
                for (int j = 0; j < n + 1; j++) {
                    currRow.add((j - 1 < 0 ? 0 : prevRow.get(j - 1)) + (j > n - 1 ? 0 : prevRow.get(j)));
                }
            }
            triangle.add(currRow);
            prevRow = currRow;
        }

        return triangle;
    }
}
