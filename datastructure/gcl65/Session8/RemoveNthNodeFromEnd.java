package gcl65.Session8;

public class RemoveNthNodeFromEnd {

    public static void main(String[] args) {

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));

        ListNode listNode = new RemoveNthNodeFromEnd().removeNthFromEnd(head, 2);
        for (ListNode node = listNode; node != null; node = node.next) {
            System.out.print(node.val + " -> ");
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        ListNode prev = null;
        ListNode slow = head;

        while (fast != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }

        if (prev == null) {
            return slow.next;
        }

        prev.next = slow.next;
        return head;
    }

}
