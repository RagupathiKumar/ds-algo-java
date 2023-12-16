package gcl65.Session2;

public class WavePrint {

    public static void main(String[] args) {

        int[][] mat = {
                {1, 4, 7, 10},
                {2, 5, 8, 11},
                {3, 6, 9, 12}
        };

        int rowSize = mat.length;
        int colSize = mat[0].length;

        for (int j = 0; j < colSize; j++) {
            if (j % 2 == 0) {
                for (int i = 0; i < rowSize; i++) {
                    System.out.print(mat[i][j] + " ");
                }
            } else {
                for (int i = rowSize - 1; i >= 0; i--) {
                    System.out.print(mat[i][j] + " ");                }
            }
        }
    }
}
