package gcl65_2.Session9;

// https://leetcode.com/problems/reverse-nodes-in-even-length-groups/description/

import gcl65_2.common.ListNode;

public class ReverseNodesInEvenLengthGroups { // NOT COMPLETE

    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(1,new ListNode(0,new ListNode(6,new ListNode(5)))));
        ListNode newHead = reverseEvenLengthGroups(head);
        System.out.println(newHead);

        ListNode head2 = new ListNode(1,new ListNode(1,new ListNode(0,new ListNode(6,new ListNode(5, new ListNode(4))))));
        ListNode newHead2 = reverseEvenLengthGroups(head2);
        System.out.println(newHead2);

        ListNode head3 = new ListNode(1,new ListNode(1,new ListNode(0,new ListNode(6,new ListNode(5, new ListNode(4, new ListNode(9, new ListNode(8))))))));
        ListNode newHead3 = reverseEvenLengthGroups(head3);
        System.out.println(newHead3);
    }

    static ListNode reverseEvenLengthGroups(ListNode head) {

        return head;
    }

    static ListNode reverseEvenLengthGroups(ListNode head, int k) {
        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null) {
            ListNode prevTail = null;
            ListNode tail = curr;
            for (int i = 0; i < k; i++) {
                prevTail = tail;
                if (tail == null) {
                    break;
                }
                tail = tail.next;
            }

            if (k % 2 == 0 || prevTail == null) {
                ListNode newHead = reverse(curr, tail);
                prev.next = newHead;
                curr.next = tail;
                prev = curr;
                curr = tail;
            } else {
                prev = prevTail;
                curr = tail;
            }
            k++;
        }
        return head;
    }

    static ListNode reverse(ListNode head, ListNode tail) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != tail) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
