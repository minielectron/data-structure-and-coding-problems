package udemyds.doublelinklist;

public class Node <T extends Comparable<T>>{
    private T data;
    private Node<T> next;
    private Node<T> previous;

    public Node(T data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
