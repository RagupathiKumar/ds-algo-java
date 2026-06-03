package gcl65_2.Session8;

import gcl65_2.common.ListNode;

// https://leetcode.com/problems/rotate-list/description/
public class RotateList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        head = rotateRight2(head, 2);

        ListNode head2 = new ListNode(0, new ListNode(1, new ListNode(2, null)));
        head2 = rotateRight2(head2, 4);

        ListNode head3 = new ListNode(1, new ListNode(2, new ListNode(3, null))); // [2,3,1]
        head3 = rotateRight2(head3, 2000000000);

        System.out.println();
    }

    static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        for (int i = 0; i < k; i++) {
            fast = fast.next;
            if (fast == null) {
                fast = head;
            }
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }

    static ListNode rotateRight2(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        int n = 0;
        for (ListNode curr = head; curr != null; curr = curr.next) {
            n++;
        }
        k = (n >= k) ? k : (k % n);

        ListNode slow = head;
        ListNode fast = head;

        for (int i = 0; i < k; i++) {
            fast = fast.next;
            if (fast == null) {
                fast = head;
            }
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }

}
