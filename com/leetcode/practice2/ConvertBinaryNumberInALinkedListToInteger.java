package leetcode.practice2;

// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/description/

public class ConvertBinaryNumberInALinkedListToInteger {

    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int v, ListNode n) {
            val = v;
            next = n;
        }
    }

    public static void main(String[] args) {
        System.out.println(getDecimalValue(new ListNode(1, new ListNode(0, new ListNode(1, null)))));;
    }

    static int getDecimalValue(ListNode head) {
        int pow = 0;
        for (ListNode curr = head; curr != null; curr = curr.next) {
            pow++;
        }

        int decimalValue = 0;
        ListNode curr = head;
        for (int p = pow - 1; p >= 0; p--) {
            decimalValue += curr.val * Math.pow(2, p);
            curr = curr.next;
        }
        return decimalValue;
    }

}
