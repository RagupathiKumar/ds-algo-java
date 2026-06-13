package leetcode.problemset;

// https://leetcode.com/problems/reverse-linked-list-ii/

public class ReverseLinkedListII {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        head = reverseBetween(head, 2, 4);
        System.out.println();

        ListNode head2 = new ListNode(3, new ListNode(5, null));
        head2 = reverseBetween(head2, 1, 2);
        System.out.println();
    }

    static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = null;
        ListNode curr = head;
        int i = 1;
        while (i < left) {
            prev = curr;
            curr = curr.next;
            i++;
        }

        ListNode leftNode = curr;
        ListNode next = curr.next;
        while (i < right) {
            ListNode node = next.next;
            next.next = curr;
            curr = next;
            next = node;
            i++;
        }

        leftNode.next = next;
        if (prev != null) {
            prev.next = curr;
            return head;
        } else {
            return curr;
        }
    }

}
