package leetcode.practice3;

// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/

import gcl65_2.common.ListNode;

public class DeleteTheMiddleNodeOfALinkedList {

    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }

        ListNode p = null;
        ListNode s = head;
        ListNode f = head;

        while (f.next != null && f.next.next != null) {
            p = s;
            s = s.next;
            f = f.next.next;
        }
        if (f.next != null) {
            s.next = s.next.next;
        } else {
            p.next = s.next;
        }
        return head;
    }
}
