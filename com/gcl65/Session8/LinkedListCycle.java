package gcl65.Session8;

public class LinkedListCycle {

    public static void main(String[] args) {

        ListNode node = new ListNode(6, null);
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, node)))));
        node.next = head;

        System.out.println(new LinkedListCycle().hasCycle(head));

        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        System.out.println(new LinkedListCycle().hasCycle(head));
    }

    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

}
