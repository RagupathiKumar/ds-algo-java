package gcl65.Session2;

public class RotateImage {

    public static void main(String[] args) {

        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int rowSize = mat.length;
        int colSize = mat[0].length;

        // step 1 :: convert row to col -- transpose
        for (int r = 0; r < rowSize; r++) {
            for (int c = r; c < colSize; c++) {
                int temp = mat[c][r];
                mat[c][r] = mat[r][c];
                mat[r][c] = temp;
            }
        }

        // step 2 :: reverse each row
        for (int r = 0; r < rowSize; r++) {
            int c1 = 0;
            int c2 = colSize - 1;
            while (c1 < c2) {
                int temp = mat[r][c1];
                mat[r][c1] = mat[r][c2];
                mat[r][c2] = temp;
                c1++;
                c2--;
            }
        }

        // print
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }


    }
}
