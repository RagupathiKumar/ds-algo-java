package gcl65.Session12;

public class KthSmallestElementInBST {

    public static void main(String[] args) {
        int smallest = new KthSmallestElementInBST().kthSmallest(new TreeNode(1), 1);
        System.out.println(smallest);
    }

    private int value = -1;
    private int cnt = 0;

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return value;
    }

    private void inOrder(TreeNode root, int k) {

        if (root == null || cnt == k) {
            return;
        }

        inOrder(root.left, k);
        if (cnt < k) {
            value = root.val;
            cnt++;
        }
        inOrder(root.right, k);
    }

}
