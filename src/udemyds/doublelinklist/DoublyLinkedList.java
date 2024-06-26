package udemyds.doublelinklist;

public class DoublyLinkedList<T extends Comparable<T>> {
    private Node<T> head;
    private Node<T> tail;

    public void insert(T data) {

        Node<T> newNode = new Node<>(data);
        // first item in the list
        if (tail == null) {
            tail = newNode;
            head = newNode;
        } else {
            newNode.setPrevious(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    public void traverseForward() {
        Node<T> actualNode = head;
        while (actualNode != null) {
            System.out.println(actualNode);
            actualNode = actualNode.getNext();
        }
    }

    public void traverseBackward() {
        Node<T> actualNode = tail;
        while (actualNode != null) {
            System.out.println(actualNode);
            actualNode = actualNode.getPrevious();
        }
    }
}
