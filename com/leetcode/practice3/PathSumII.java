package leetcode.practice3;

import gcl65.Session11.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        pathSum(root, targetSum, 0, path, result);
        return result;
    }

    private void pathSum(TreeNode root, int targetSum, int sum, List<Integer> path, List<List<Integer>> result) {
        // base case
        if (root == null) {
            return;
        }

        // recursive case
        path.add(root.val);

        if (sum + root.val == targetSum && root.left == null && root.right == null) {
            result.add(new ArrayList<>(path));
        }
        pathSum(root.left, targetSum, sum + root.val, path, result);
        pathSum(root.right, targetSum, sum + root.val, path, result);

        path.remove(path.size() - 1);
    }

}
