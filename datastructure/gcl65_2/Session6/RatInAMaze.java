package gcl65_2.Session6;

import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {

    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };
        System.out.println(new RatInAMaze().ratInMaze(maze));
    }

    public List<String> ratInMaze(int[][] maze) {
        List<String> result = new ArrayList<>();
        ratInMaze(maze, maze.length, 0, 0, "", result);
        return result;
    }

    private void ratInMaze(int[][] maze, int n, int i, int j, String path, List<String> result) {
        // base case
        if (i < 0 || i == n || j < 0 || j == n || maze[i][j] != 1) {
            return;
        } else if (i == n - 1 && j == n - 1) {
            result.add(path);
            return;
        }

        // recursive case
        maze[i][j] = 2; // visited

        ratInMaze(maze, n, i + 1, j, path + "D", result); // down
        ratInMaze(maze, n, i, j - 1, path + "L", result); // left
        ratInMaze(maze, n, i, j + 1, path + "R", result); // right
        ratInMaze(maze, n, i - 1, j, path + "U", result); // up

        maze[i][j] = 1; // backtracking
    }

}
