package leetcode.practice2;

public class RemoveLinkedListElements {

    public class ListNode {
        int val;
        ListNode next;
    }

    public ListNode removeElements(ListNode head, int val) {
        // base case
        if (head == null) {
            return null;
        }

        // recursive case
        if (head.val == val) {
            return removeElements(head.next, val);
        } else {
            head.next = removeElements(head.next, val);
            return head;
        }
    }


}
