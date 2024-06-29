package udemyds.stack;

public class Stack<T extends Comparable<T>> {

    private Node<T> head;
    private int size = 0;

    public void push(T data) {
        size++;
        Node<T> newNode = new Node<>(data);

        if (head != null) {
            newNode.setNext(head);
        }
        head = newNode;
    }

    public Node<T> pop() {
        if (head == null) return null;
        Node<T> temp = head;
        head = head.getNext();
        temp.setNext(null);
        size--;
        return temp;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
