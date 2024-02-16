package gcl65.Session9;

import gcl65.Session8.ListNode;

public class ReverseNodesInKGroup {

    public static void main(String[] args) {

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        head = new ReverseNodesInKGroup().reverseKGroupChaman(head, 2);
        head.print();
    }

    public ListNode reverseKGroupChaman(ListNode head, int k) {

        if (k <= 1) {
            return head;
        }

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

    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode prev = null;
        ListNode node = head;
        while (node != tail) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        return reverseKGroup(head, head, k, 1);
    }

    private ListNode reverseKGroup(ListNode start, ListNode end, int k, int k1) {

        // base case
        if (end == null) {
            return start;
        }

        // recursive case
        if (k == k1) {

            ListNode endNode = end.next;

            ListNode prev = end.next;
            ListNode node = start;
            while (node != endNode) {
                ListNode next = node.next;
                node.next = prev;
                prev = node;
                node = next;
            }

            start.next = reverseKGroup(endNode, endNode, k, 1);
            return prev;
        }

        return reverseKGroup(start, end.next, k, k1 + 1);
    }

}
