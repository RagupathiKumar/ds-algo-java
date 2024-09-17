package gcl65.Session2;

import java.util.Arrays;

public class TestSession2_Matrix {

    public static void main(String[] args) {

        int[][] mat1 = {
                {1, 4, 7, 10},
                {2, 5, 8, 11},
                {3, 6, 9, 12}
        };
        printWave(mat1); // 1 2 3 6 5 4 7 8 9 12 11 10
        System.out.println();

        int[][] mat2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        printSpiral(mat2); // 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10

        int[][] mat3 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotateImage(mat3);
    }

    private static void printWave(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        for (int col = 0; col < cols; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < rows; row++) {
                    System.out.print(mat[row][col] + " ");
                }
            } else {
                for (int row = rows - 1; row >= 0; row--) {
                    System.out.print(mat[row][col] + " ");
                }
            }
            // System.out.println();
        }
    }

    private static void printSpiral(int[][] mat) {

        int sRow = 0, eRow = mat.length - 1;
        int sCol = 0, eCol = mat[0].length - 1;

        while (sRow <= eRow && sCol <= eCol) {
            for (int col = sCol; col <= eCol; col++) {
                System.out.print(mat[sRow][col] + " ");
            }
            sRow++;

            for (int row = sRow; row <= eRow; row++) {
                System.out.print(mat[row][eCol] + " ");
            }
            eCol--;

            for (int col = eCol; col >= sCol; col--) {
                System.out.print(mat[eRow][col] + " ");
            }
            eRow--;

            for (int row = eRow; row >= sRow ; row--) {
                System.out.print(mat[row][sCol] + " ");
            }
            sCol++;
        }
    }

    private static void rotateImage(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;

        System.out.println();
        for (int[] row : mat) {
            System.out.println(Arrays.toString(row));
        }

        // transpose
        for (int row = 0; row < rows; row++) {
            for (int col = row; col < cols; col++) {
                int temp = mat[row][col];
                mat[row][col] = mat[col][row];
                mat[col][row] = temp;
            }
        }

        // reverse rows
        for (int row = 0; row < rows; row++) {
            for (int col1 = 0, col2 = cols - 1; col1 < col2; col1++, col2--) { // not very readable
                int temp = mat[row][col1];
                mat[row][col1] = mat[row][col2];
                mat[row][col2] = temp;
            }
        }

        System.out.println();
        for (int[] row : mat) {
            System.out.println(Arrays.toString(row));
        }
    }
}