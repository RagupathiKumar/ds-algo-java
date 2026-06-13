package gcl65.Session8;

public class MiddleOfTheLinkedList {

    public static void main(String[] args) {

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));

        ListNode listNode = new MiddleOfTheLinkedList().middleNodeNg(head);

        while (listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
    }

    public ListNode middleNodeNg(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode middleNode(ListNode head) {

        int cnt = 0;
        for (ListNode listNode = head; listNode != null; listNode = listNode.next) {
            cnt++;
        }

        cnt /= 2;
        ListNode listNode = head;
        while (cnt > 0) {
            listNode = listNode.next;
            cnt--;
        }

        return listNode;
    }

}
