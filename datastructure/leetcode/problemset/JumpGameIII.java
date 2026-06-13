package leetcode.problemset;

// https://leetcode.com/problems/jump-game-iii/

public class JumpGameIII {

    public static void main(String[] args) {
        System.out.println(canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 5));
        System.out.println(canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 0));
        System.out.println(canReach(new int[]{3, 0, 2, 1, 2}, 2));
    }

    static boolean canReach(int[] arr, int start) {
        return canReach(arr, start, new int[arr.length]);
    }

    private static boolean canReach(int[] arr, int i, int[] visited) {
        // base case
        if (i < 0 || i > arr.length - 1 || visited[i] == 1) {
            return false;
        } else if (arr[i] == 0) {
            return true;
        }

        // recursive case
        visited[i] = 1;
        return canReach(arr, i + arr[i], visited) || canReach(arr, i - arr[i], visited);
    }

}
