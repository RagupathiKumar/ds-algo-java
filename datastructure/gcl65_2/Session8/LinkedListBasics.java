package gcl65_2.Session8;

public class LinkedListBasics {

    static class Node {
        int data;
        Node next;
        Node() {}
    }

    public static void main(String[] args) {
        LinkedListBasics ll = new LinkedListBasics();

        Node head = null;
        head = ll.insertAtHead(head, 3);
        head = ll.insertAtHead(head, 2);
        head = ll.insertAtHead(head, 1);
        ll.print(head);

        Node head2 = null;
        head2 = ll.insertAtTail(head2, 1);
        head2 = ll.insertAtTail(head2, 2);
        head2 = ll.insertAtTail(head2, 3);
        ll.print(head2);

        Node head3 = null;
        head3 = ll.insertAtPos(head3, 1, 2);
        head3 = ll.insertAtPos(head3, 3, 2);
        head3 = ll.insertAtPos(head3, 2, 2);
        head3 = ll.insertAtPos(head3, 0, 1);
        head3 = ll.insertAtPos(head3, 4, 10);
        head3 = ll.insertAtPos(head3, 6, 10);
        head3 = ll.insertAtPos(head3, 5, 5);
        ll.print(head3);

        head3 = ll.deleteAtHead(head3);
        ll.print(head3);

        head3 = ll.deleteAtTail(head3);
        ll.print(head3);

        System.out.println(ll.searchIterative(head3, 3));
        System.out.println(ll.searchIterative(head3, 7));

        System.out.println(ll.searchRecursive(head3, 3));
        System.out.println(ll.searchRecursive(head3, 7));
    }

    private boolean searchRecursive(Node head, int target) {
        // base case
        if (head == null) {
            return false;
        } else if (head.data == target) {
            return true;
        }

        // recursive case
        return searchRecursive(head.next, target);
    }

    private boolean searchIterative(Node head, int target) {
        Node curr = head;
        while (curr != null) {
            if (curr.data == target) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    private Node deleteAtTail(Node head) {
        Node prev = null;
        Node curr = head;

        if (curr == null || curr.next == null) {
            return prev;
        }

        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = curr.next;
        return head;
    }

    private Node deleteAtHead(Node head) {
        if (head == null) {
            return head;
        }
        return head.next;
    }

    private void print(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    private Node insertAtPos(Node head, int num, int pos) {
        Node node = new Node();
        node.data = num;

        if (head == null) {
            return node;
        }

        Node curr = head;
        Node prev = null;
        int i = 1;
        while (i < pos && curr != null) {
            i++;
            prev = curr;
            curr = curr.next;
        }

        if (curr == head) {
            node.next = curr;
            return node;
        }
        prev.next = node;
        node.next = curr;
        return head;
    }

    private Node insertAtTail(Node head, int num) {
        Node node = new Node();
        node.data = num;

        if (head == null) {
            return node;
        }

        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        tail.next = node;
        return head;
    }

    private Node insertAtHead(Node head, int num) {
        Node node = new Node();
        node.data = num;
        node.next = head;
        return node;
    }

}
