package gcl65.Session12;

import java.util.*;

public class TopViewOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(60);
        root.right.left = new TreeNode(90);
        root.right.right = new TreeNode(100);

        System.out.println(new TopViewOfBinaryTree().topView(root));
    }

    private List<Integer> topView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Deque<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            TreeNode node = pair.node;
            int hd = pair.hd;

            if (!map.containsKey(hd)) {
                map.put(hd, node.val);
            }

            if (node.left != null) {
                q.add(new Pair(node.left, hd - 1));
            }

            if (node.right != null) {
                q.add(new Pair(node.right, hd + 1));
            }
        }

        return new ArrayList<>(map.values());
    }
}
