package gcl65.Session2;

public class SpiralPrint {

    public static void main(String[] args) {

        int[][] mat = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int startRow = 0, endRow = mat.length - 1, startCol = 0, endCol = mat[0].length - 1;

        while (true) {

            for (int col = startCol; col <= endCol; col++) {
                System.out.print(mat[startRow][col] + " ");
            }
            startRow++;
            if (startRow > endRow) {
                break;
            }

            for (int row = startRow; row <= endRow; row++) {
                System.out.print(mat[row][endCol] + " ");
            }
            endCol--;
            if (startCol > endCol) {
                break;
            }

            for (int col = endCol; col >= startCol; col--) {
                System.out.print(mat[endRow][col] + " ");
            }
            endRow--;
            if (startRow > endRow) {
                break;
            }

            for (int row = endRow; row >= startRow; row--) {
                System.out.print(mat[row][startCol] + " ");
            }
            startCol++;
            if (startCol > endCol) {
                break;
            }
        }

    }
}
