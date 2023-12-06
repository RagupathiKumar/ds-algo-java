package com.leetcode;

// TODO : incomplete
public class AddTwoNumbers {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(2, new ListNode(4, new ListNode(3))); // 243
        ListNode node2 = new ListNode(5, new ListNode(6, new ListNode(4))); // 564
        ListNode node = addTwoNumbers(node1, node2);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2, int div) {

        if (l1 == null && l2 == null) {
            return null;
        }

        int sum = l1.val + l2.val + div;
        int rem = sum % 10;     // second digit

        ListNode node = addTwoNumbers(l1.next, l2.next, div);

        div = sum / 10;         // first digit
        return new ListNode(rem, node);
    }

}
