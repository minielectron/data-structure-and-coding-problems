package udemyds.bst;

public class TreeComparator<T extends Comparable<T>> {

    public boolean isSameTree(Node<T> node1, Node<T> node2) {

        if (node1 == null || node2 == null)
            return node1 == node2;

        if (node1.getData().compareTo(node2.getData()) != 0) return false;

        return isSameTree(node1.getLeftChild(), node2.getLeftChild()) && isSameTree(node1.getRightChild(), node2.getRightChild());
    }
}
