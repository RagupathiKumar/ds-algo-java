package gcl65.Session11;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.right = new TreeNode(8);

        // p = 6, q = 7 -- ans = 5
        TreeNode node = new LowestCommonAncestor().lowestCommonAncestor(root, root.left.left, root.left.right.left);
        System.out.println(node.val);

        // p = 5, q = 4 -- edge case -- ans = 5
        node = new LowestCommonAncestor().lowestCommonAncestor(root, root.left, root.left.right.right);
        System.out.println(node.val);
    }

    // pre-order traversal
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }

        // recursive case
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}
