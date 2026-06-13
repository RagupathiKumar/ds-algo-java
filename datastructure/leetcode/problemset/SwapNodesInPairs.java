package leetcode.problemset;

// https://leetcode.com/problems/swap-nodes-in-pairs/

public class SwapNodesInPairs {

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
        head = swapPairs2(head);

        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        head2 = swapPairs2(head2);

        System.out.println();
    }

    static ListNode swapPairs(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            ListNode next = curr.next;
            ListNode temp = next.next;
            curr.next = temp;
            next.next = curr;

            if (prev == null) {
                head = next;
            } else {
                prev.next = next;
            }

            prev = curr;
            curr = temp;
        }
        return head;
    }

    static ListNode swapPairs2(ListNode head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }

        // recursive case
        ListNode next = head.next;
        ListNode temp = next.next;

        head.next = temp;
        next.next = head;

        head.next = swapPairs2(temp);
        return next;
    }
}
