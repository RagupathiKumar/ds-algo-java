package gcl65_2.Session2;

import static java.lang.System.out;

class RotateImage{

    public static void main(String[] args) {
        int[][] mat =
                {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        print(mat);
        transpose(mat);
        reverse(mat);
        print(mat);
    }

    private static void reverse(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        for (int row = 0; row < n; row++) {
            int s = 0, e = m - 1;
            while (s < e) {
                int temp = mat[row][s];
                mat[row][s] = mat[row][e];
                mat[row][e] = temp;
                s++;
                e--;
            }
        }
    }

    private static void transpose(int[][] mat) { // convert row to col by diagonal swapping
        int n = mat.length, m = mat[0].length;
        for (int row = 0; row < n; row++) {
            for (int col = row; col < m; col++) {
                int temp = mat[row][col];
                mat[row][col] = mat[col][row];
                mat[col][row] = temp;
            }
        }
    }

    private static void print(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                out.print(mat[row][col] + " ");
            }
            out.println();
        }
        out.println();
    }

}  