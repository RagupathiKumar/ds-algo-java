package leetcode.practice3;

import gcl65_2.common.ListNode;

public class MaximumTwinSumOfALinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(5, new ListNode(4, new ListNode(2, new ListNode(1)))); // 6
        System.out.println(new MaximumTwinSumOfALinkedList().pairSum(head));

        ListNode head2 = new ListNode(4, new ListNode(2, new ListNode(2, new ListNode(3)))); // 7
        System.out.println(new MaximumTwinSumOfALinkedList().pairSum(head2));
    }

    private int pairSum(ListNode head) {
        ListNode mid = mid(head);
        ListNode head2 = mid.next;

        head2 = reverse(head2);

        int max = Integer.MIN_VALUE;
        while (head2 != null) {
            max = Math.max(head.val + head2.val, max);
            head = head.next;
            head2 = head2.next;
        }
        return max;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private ListNode mid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
