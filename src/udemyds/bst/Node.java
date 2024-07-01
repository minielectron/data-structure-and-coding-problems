package udemyds.bst;

public class Node<T extends Comparable<T>> {

    private Node<T> leftChild;
    private Node<T> rightChild;
    private Node<T> parentChild; // helpful in implementing remove
    private T data;

    public Node(T data, Node<T> parentNode) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
        this.parentChild = parentNode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    public Node<T> getParentNode() {
        return parentChild;
    }

    public void setParentChild(Node<T> parentChild) {
        this.parentChild = parentChild;
    }

    @Override
    public String toString() {
        return "[" + data + "]" ;
    }
}
