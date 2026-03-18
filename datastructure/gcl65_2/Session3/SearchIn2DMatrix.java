package gcl65_2.Session3;

class SearchIn2DMatrix{

    public static void main(String[] args) {

        int[][] mat = {
                {1, 2, 3, 5},
                {6, 7, 9, 10},
                {11, 13, 15, 17},
                {20, 25, 27, 30}
        };

        System.out.println(find(mat, 27));
        System.out.println(find(mat, 1));
        System.out.println(find(mat, 30));
        System.out.println(find(mat, 0));
        System.out.println(find(mat, 33));
        System.out.println(find(mat, 8));
    }

    private static boolean find(int[][] mat, int target) {
        int n = mat.length, m = mat[0].length;
        int s = 0, e = n * m - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            int i = mid / m;
            int j = mid % m;

            if (target < mat[i][j]) {
                e = mid - 1;
            } else if (target > mat[i][j]) {
                s = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}  