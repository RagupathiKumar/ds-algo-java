package gcl65.Session8;

public class MiddleOfTheLinkedList {

    public static void main(String[] args) {

        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));

        Node node = new MiddleOfTheLinkedList().middleNodeNg(head);

        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println();
    }

    public Node middleNodeNg(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public Node middleNode(Node head) {

        int cnt = 0;
        for (Node node = head; node != null; node = node.next) {
            cnt++;
        }

        cnt /= 2;
        Node node = head;
        while (cnt > 0) {
            node = node.next;
            cnt--;
        }

        return node;
    }

}
