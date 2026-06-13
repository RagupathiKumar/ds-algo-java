package gcl65_2.Session5;

// https://leetcode.com/problems/flood-fill/

import java.util.Arrays;

public class FloodFill {

    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        new FloodFill().floodFill(image, 1, 1, 2);
        for (int[] ints : image) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if (original != color) {
            int n = image.length, m = image[0].length;
            floodFill(image, sr, sc, color, original, n, m);
        }
        return image;
    }

    private void floodFill(int[][] image, int sr, int sc, int color, int original, int n, int m) {
        // base case
        if (sr < 0 || sr == n || sc < 0 || sc == m || image[sr][sc] != original) {
            return;
        }

        // recursive case
        image[sr][sc] = color; // filled

        floodFill(image, sr, sc - 1, color, original, n, m); // left
        floodFill(image, sr - 1, sc, color, original, n, m); // up
        floodFill(image, sr, sc + 1, color, original, n, m); // right
        floodFill(image, sr + 1, sc, color, original, n, m); // down
    }

}
