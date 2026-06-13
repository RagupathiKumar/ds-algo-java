package gcl65.Session9;

import gcl65.Session8.ListNode;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(2, new ListNode(1, null))))));
        System.out.println(new PalindromeLinkedList().isPalindrome(head));
        System.out.println(new PalindromeLinkedList().isPalindrome(new ListNode(1, new ListNode(2, new ListNode(1, null)))));
    }

    public boolean isPalindrome(ListNode head) {

        if (head == null) {
            return false;
        }

        ListNode mid = mid(head);
        ListNode list2 = mid.next;
        mid.next = null;

        list2 = reverse(list2);

        ListNode node1 = head;
        ListNode node2 = list2;
        while (node1 != null && node2 != null) {
            if (node1.val != node2.val) {
                return false;
            }
            node1 = node1.next;
            node2 = node2.next;
        }

        return true;
    }

    private ListNode mid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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

}
