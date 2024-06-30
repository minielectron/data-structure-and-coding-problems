package udemyds.queue;

// ADT with linked list under the hood
public class Queue<T extends Comparable<T>> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    // O(1)
    public void enqueue(T data) {
        size++;
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            // There are no items in the queue
            head = newNode;
        } else {
            // There are items in the list, adding the item to last
            tail.setNextNode(newNode);
        }
        tail = newNode;
    }

    public Node<T> poll() {
        return tail;
    }

    // O(1)
    public Node<T> dequeue() {
        if (head == null) {
            // There are no nodes in the queue
            return null;
        }
        size--;
        Node<T> current = head;
        head = head.getNextNode();
        current.setNextNode(null);
        return current;
    }

    public void traverse() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.getNextNode();
        }
    }
}
