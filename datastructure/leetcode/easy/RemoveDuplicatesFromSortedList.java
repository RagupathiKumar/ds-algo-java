package leetcode.easy;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list/

public class RemoveDuplicatesFromSortedList {

    public class ListNode {
        int val;
        ListNode next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }

        // recursive case
        if (head.val == head.next.val) {
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }

}
