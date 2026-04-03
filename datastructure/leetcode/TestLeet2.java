package leetcode;

public class TestLeet2 {

    public boolean isPerfectSquare(int num) {
        int s = 0, e = num / 2;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            long target = (long) mid * mid;
            if (target < num) {
                s = mid + 1;
            } else if (target > num) {
                e = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public int guessNumber(int n) {
        int s = 1, e = n, pick = 0;
        while (s <= e) {
            pick = s + (e - s) / 2;
            int target = guessNumber(pick);
            if (target < 0) {
                e = pick - 1;
            } else if (target > 0) {
                s = pick + 1;
            } else {
                break;
            }
        }
        return pick;
    }

    public int arrangeCoins(int n) {
        int minStairs = 1, maxStairs = n, resultStairs = 0;
        while (minStairs <= maxStairs) {
            int stairs = minStairs + (maxStairs - minStairs) / 2;
            long coins = ((long) stairs * (stairs + 1)) / 2;
            if (coins > n) {
                maxStairs = stairs - 1;
            } else if (coins < n) {
                resultStairs = stairs;
                minStairs = stairs + 1;
            } else {
                resultStairs = stairs;
                break;
            }
        }
        return resultStairs;
    }

    public int search(int[] nums, int target) {
        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (target < nums[m]) {
                e = m - 1;
            } else if (target > nums[m]) {
                s = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length, s = 0, e = n - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (target < letters[m]) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return letters[(e + 1 < n) ? e + 1 : 0];
    }

    public int islandPerimeter(int[][] grid) {
        int n = grid.length, m = grid[0].length, p = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 1) {
                    p += (c - 1 < 0 || grid[r][c - 1] == 0) ? 1 : 0;
                    p += (r - 1 < 0 || grid[r - 1][c] == 0) ? 1 : 0;
                    p += (c + 1 > m - 1 || grid[r][c + 1] == 0) ? 1 : 0;
                    p += (r + 1 > n - 1 || grid[r + 1][c] == 0) ? 1 : 0;
                }
            }
        }
        return p;
    }

    public int[][] imageSmoother(int[][] img) {
        int n = img.length, m = img[0].length;
        int[][] result = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int s1 = Math.max(i - 1, 0), e1 = Math.min(i + 1, n - 1);
                int s2 = Math.max(j - 1, 0), e2 = Math.min(j + 1, m - 1);
                int div = 0;
                for (int r = s1; r <= e1 ; r++) {
                    for (int c = s2; c <= e2 ; c++) {
                        result[i][j] += img[r][c];
                        div++;
                    }
                }
                result[i][j] /= ((e1 - s1 + 1) * (e2 - s2 + 1));
            }
        }

        return result;
    }

    public int[][] transpose(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] result = new int[m][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                result[c][r] = matrix[r][c];
            }
        }
        return result;
    }

    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        for (int r = 0; r < n; r++) {
            int sc = 0, ec = n - 1;
            while (sc <= ec) {
                int t = image[r][sc];
                image[r][sc++] = image[r][ec] ^ 1;
                image[r][ec--] = t ^ 1;

            }
        }
        return image;
    }

}
