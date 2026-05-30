package leetcode.medium;

// https://leetcode.com/problems/reorder-list/

public class ReorderList {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        reorderList(head);

        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        reorderList(head2);

        System.out.println();
    }

    static void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null) {
            fast = fast.next;
            if (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }

        ListNode prev = slow;
        slow = slow.next;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        ListNode curr = head;
        while (curr != fast && curr.next != fast) {
            ListNode next1 = curr.next;
            ListNode next2 = fast.next;
            curr.next = fast;
            fast.next = next1;
            curr = next1;
            fast = next2;
        }
        if (curr != fast) {
            curr.next = fast;
        }
        fast.next = null;
    }

}
