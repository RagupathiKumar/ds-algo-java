package gcl65_2.Session2;

class SpiralPrint {
    public static void main(String[] args) {

        int[][] mat = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int n = mat.length, m = mat[0].length;
        int startRow = 0, endRow = n - 1;
        int startCol = 0, endCol = m - 1;


        while (startRow <= endRow && startCol <= endCol) {
            for (int col = startCol; col <= endCol; col++) {
                System.out.print(mat[startRow][col] + " ");
            }
            startRow++;

            for (int row = startRow; row <= endRow; row++) {
                System.out.print(mat[row][endCol] + " ");
            }
            endCol--;

            for (int col = endCol; col >= startCol; col--) {
                System.out.print(mat[endRow][col] + " ");
            }
            endRow--;

            for (int row = endRow; row >= startRow; row--) {
                System.out.print(mat[row][startCol] + " ");
            }
            startCol++;
        }

    }
}  