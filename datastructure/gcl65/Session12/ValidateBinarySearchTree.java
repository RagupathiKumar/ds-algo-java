package gcl65.Session12;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {

    // inOrder and two pointer tech -- START
    public boolean isValidBST2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);

        int size = list.size(), prev = 0;
        for (int i = 1; i < size; i++, prev++) {
            if (list.get(prev) >= list.get(i)) {
                return false;
            }
        }

        return true;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        // base case
        if (root == null) {
            return;
        }

        // recursive case
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
    // END

    // Chaman's tech -- START
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        // base case
        if (root == null) {
            return true;
        }

        // recursive case
        return min < root.val && root.val < max
                && isValidBST(root.left, min, root.val)
                && isValidBST(root.right, root.val, max);
    }
    // END
}
