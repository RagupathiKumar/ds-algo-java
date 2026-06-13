package leetcode.practice2;

// https://leetcode.com/problems/pascals-triangle-ii/

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {

    public static void main(String[] args) {
        System.out.println(getRow(3)); // [1,3,3,1]
        System.out.println(getRow(0)); // [1]
        System.out.println(getRow(1)); // [1,1]
    }

    static List<Integer> getRow(int rowIndex) {
        int[] prevRow = {1};

        for (int i = 1; i <= rowIndex; i++) {
            int[] currRow = new int[i + 1];
            for (int idx = 0; idx < i + 1; idx++) {
                currRow[idx] = (idx - 1 < 0 ? 0 : prevRow[idx - 1]) + (idx >= i ? 0 : prevRow[idx]);
            }
            prevRow = currRow;
        }

        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < prevRow.length; i++) {
            row.add(prevRow[i]);
        }
        return row;
    }

}
