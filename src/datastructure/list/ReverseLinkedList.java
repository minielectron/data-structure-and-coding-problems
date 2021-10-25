package datastructure.list;

public class ReverseLinkedList {

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        print(reverse(head));
    }

    public static void print(Node head){
        while (head != null){
            System.out.println(head.data);
            head = head.next;
        }
    }

    public static Node reverse(Node head){

        Node current = head;
        Node prev = null;
        Node next = null;

        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }
        head = prev;
        return head;
    }

}


class Node{
    int data;
    Node next = null;

    public Node(int data){
        this.data = data;
    }
}