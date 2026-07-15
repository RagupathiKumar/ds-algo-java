package leetcode.practice3;

import gcl65.Session11.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RecoverBinarySearchTree {

    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inOrder(root, list);

        TreeNode prev = null, curr;
        TreeNode first = null, second = null;
        for (int i = 0, size = list.size(); i < size; i++) {
            curr = list.get(i);
            if (prev != null && prev.val > curr.val) {
                if (first == null) {
                    first = prev;
                }
                second = curr;
            }
            prev = curr;
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inOrder(TreeNode root, List<TreeNode> list) {
        // base case
        if (root == null) {
            return;
        }

        // recursive case
        inOrder(root.left, list);
        list.add(root);
        inOrder(root.right, list);
    }

}
