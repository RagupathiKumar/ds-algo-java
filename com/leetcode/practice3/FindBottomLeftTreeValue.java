package leetcode.practice3;

import gcl65.Session11.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {

    public int findBottomLeftValue(TreeNode root) {
        int leftMost = -1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode first = null;
            for (int i = 0, size = q.size(); i < size; i++) {
                TreeNode node = q.poll();
                if (first == null) {
                    first = node;
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            leftMost = first.val;
        }
        return leftMost;
    }

}
