package gcl65.Session9;

import gcl65.Session8.ListNode;

public class ReorderList {

    public static void main(String[] args) {

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, null))))));

        new ReorderList().reorderList(head);

        for (ListNode node = head; node != null; node = node.next) {
            System.out.print(node.val + " -> ");
        }
        System.out.println();
    }


    public void reorderList(ListNode head) {

        if (head == null) {
            return;
        }

        ListNode mid = mid(head);
        ListNode list2 = mid.next;
        mid.next = null;

        list2 = reverse(list2);

        merge(head, list2);
    }

    private ListNode mid(ListNode head) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return prev;
    }

    private ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode node = head;

        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
    }

    private void merge(ListNode list1, ListNode list2) {
        ListNode node1 = list1;
        ListNode node2 = list2;
        while (node1 != null && node2 != null) {
            ListNode next1 = node1.next;
            ListNode next2 = node2.next;
            node1.next = node2;
            node2.next = next1;
            node1 = next1;
            node2 = next2;
        }
    }

}
