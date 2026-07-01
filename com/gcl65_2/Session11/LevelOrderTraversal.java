package gcl65_2.Session11;

import gcl65.Session11.TreeNode;

import java.util.*;

public class LevelOrderTraversal {

    public List<Integer> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            result.add(node.val);
            if (Objects.nonNull(node.left)) {
                q.add(node.left);
            }
            if (Objects.nonNull(node.right)) {
                q.add(node.right);
            }
        }

        return result;
    }

}
