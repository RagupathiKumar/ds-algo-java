package gcl65.Session8;

public class ReverseLinkedList {

    public static void main(String[] args) {

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));

        ListNode listNode = new ReverseLinkedList().reverseListNg(head);

        while (listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }

    }

    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode node = head;

        while (node != null) {
            ListNode nextTemp = node.next;
            node.next = prev;
            prev = node;
            node = nextTemp;
        }

        return prev;
    }

    public ListNode reverseListNg(ListNode head) {
        return reverseListNg(null, head);
    }

    private ListNode reverseListNg(ListNode prev, ListNode node) {

        // base case
        if (node == null) {
            return prev;
        }

        // recursive case
        ListNode nextTemp = node.next;
        node.next = prev;
        return reverseListNg(node, nextTemp);
    }

}
