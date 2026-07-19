package leetcode.practice3;

import gcl65.Session11.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        binaryTreePaths(root, "" + root.val, paths);
        return paths;
    }

    private void binaryTreePaths(TreeNode root, String path, List<String> paths) {
        // base case
        if (root.left == null && root.right == null) {
            paths.add(path);
            return;
        }

        // recursive case
        if (root.left != null) {
            binaryTreePaths(root.left, path + "->" + root.left.val, paths);
        }

        if (root.right != null) {
            binaryTreePaths(root.right, path + "->" + root.right.val, paths);
        }
    }
}
