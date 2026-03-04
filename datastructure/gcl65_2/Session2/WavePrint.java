package gcl65_2.Session2;

class WavePrint{
    public static void main(String[] args) {

        int[][] mat = {
                {1, 4, 7, 10},
                {2, 5, 8, 11},
                {3, 6, 9, 12}
        };
        int n = mat.length, m = mat[0].length;

        for (int col = 0; col < m; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < n; row++) {
                    System.out.print(mat[row][col] + ", ");
                }
            } else {
                for (int row = n - 1; row >= 0; row--) {
                    System.out.print(mat[row][col] + ", ");
                }
            }
        }

    }
}  