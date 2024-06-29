package udemyds.linkedlist;

public class LinkedList<T extends Comparable<T>> implements List<T> {

    private Node<T> head;
    private int size;

    @Override
    public void insert(T data) {
        if (head == null) {
            head = new Node<>(data);
        } else {
            insertBeginning(data);
        }
        size ++;
    }

    private void insertBeginning(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNext(head);
        head = newNode;
    }

    private void insertAtEnd(T data, Node<T> node) {
        if (node.getNextNode() != null) {
            insertAtEnd(data, node.getNextNode());
        } else {
            Node<T> newNode = new Node<>(data);
            node.setNext(newNode);
        }
    }

    @Override
    public void remove(T data) {
        if (head == null) return;

        if (head.getData().compareTo(data) == 0){
            head = head.getNextNode();
        }else{
            remove(data, head, head.getNextNode());
        }
    }

    private void remove(T data, Node<T> previousNode, Node<T> actualNode) {

        while (actualNode != null){
            if (actualNode.getData().compareTo(data) == 0){
                size --;
                previousNode.setNext(actualNode.getNextNode());
                actualNode = null;
                return;
            }

            previousNode = actualNode;
            actualNode = actualNode.getNextNode();
        }
    }

    @Override
    public void traverse() {

        if (head == null) {return;}

        Node<T> actualNode = head;

        while (actualNode != null) {
            System.out.println(actualNode);
            actualNode = actualNode.getNextNode();
        }
    }

    @Override
    public int size() {
        return size;
    }
}
