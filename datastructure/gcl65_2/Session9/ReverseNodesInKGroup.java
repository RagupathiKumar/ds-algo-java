package gcl65_2.Session9;

// https://leetcode.com/problems/reverse-nodes-in-k-group/description/

import gcl65_2.common.ListNode;

public class ReverseNodesInKGroup {

    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5,
                                                new ListNode(6,
                                                        new ListNode(7,
                                                                new ListNode(8))))))));
        ListNode newHead = reverseKGroup(head, 1);
        System.out.println(newHead);
    }

    static ListNode reverseKGroup(ListNode head, int k) {
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }

        ListNode newHead = reverse(head, tail);
        head.next = reverseKGroup(tail, k);
        return newHead;
    }

    static ListNode reverse(ListNode head, ListNode tail) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != tail) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
