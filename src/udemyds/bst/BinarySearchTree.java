package udemyds.bst;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {
    private Node<T> root;
    private int size;

    @Override
    public void insert(T data) {

        if (root == null) {
            // when there is no nodes in the tree
            root = new Node<>(data, null);
        } else {
            // There are already items in the bst
            insert(data, root);
        }
    }

    private void insert(T data, Node<T> node) {
        if (data.compareTo(node.getData()) < 0) {
            if (node.getLeftChild() != null) {
                insert(data, node.getLeftChild());
            } else {
                node.setLeftChild(new Node<>(data, node));
            }
        } else {
            if (node.getRightChild() != null) {
                insert(data, node.getRightChild());
            } else {
                node.setRightChild(new Node<>(data, node));
            }
        }
    }

    public Node<T> kthSmallest(Node<T>  node, int k){

        // number of node in left subtree.
        // +1 because of root node addition to subtree
        int n = treeSize(node.getLeftChild()) + 1 ;

        // when we find kth smallest item
        if (n == k) return node;

        if (n > k) return kthSmallest(node.getLeftChild(), k);

        return kthSmallest(node.getRightChild(), k - n);

    }

    private int treeSize (Node<T> node){
        if (node == null) return 0;

        return treeSize(node.getLeftChild()) + treeSize(node.getRightChild()) + 1;
    }

    @Override
    public void remove(T data) {

        // if no nodes in the tree
        if (root == null) return;

        remove(data, root);
    }

    private void remove(T data, Node<T> node) {
        if (node == null) return;

        if (data.compareTo(node.getData()) < 0){
            remove(data, node.getLeftChild());
        } else if (data.compareTo(node.getData()) > 0){
            remove(data, node.getRightChild());
        }else {
            // We have a match, three cases are possible here
            // 1. leaf node

            if (node.getLeftChild() == null && node.getRightChild() == null){
                Node<T> parent = node.getParentNode();

                if (parent != null && parent.getLeftChild() == node){
                    parent.setLeftChild(null);
                }

                if (parent != null && parent.getRightChild() == node){
                    parent.setRightChild(null);
                }

                if (parent == null){
                    root = null;
                }

                node = null; // eligible for gc
            }

            // 2. node with one child

            else if (node.getLeftChild() == null &&  node.getRightChild() != null) {
                // node has left child but not right child

                Node<T> parent = node.getParentNode();

                if (parent != null && parent.getLeftChild() == node){
                    parent.setLeftChild(node.getRightChild());
                }else if (parent != null && parent.getRightChild() == node){
                    parent.setRightChild(node.getRightChild());
                }

                if (parent == null){
                    root = node.getRightChild();
                }

                node.getRightChild().setParentChild(node);
                node = null;
            }

            else if (node.getLeftChild() != null &&  node.getRightChild() == null) {
                // node has left child but not right child

                Node<T> parent = node.getParentNode();

                if (parent != null && parent.getLeftChild() == node){
                    parent.setLeftChild(node.getLeftChild());
                }else if (parent != null && parent.getRightChild() == node){
                    parent.setRightChild(node.getLeftChild());
                }

                if (parent == null){
                    root = node.getLeftChild();
                }

                node.getLeftChild().setParentChild(node);
                node = null;
            }

            // 3. node with both the child

            else {
                Node<T> predecessor = findPredecessor(node.getLeftChild());

                // swap the values
                T temp = predecessor.getData();
                predecessor.setData(node.getData());
                node.setData(temp);
                remove(data, predecessor);
            }
        }
    }

    private Node<T> findPredecessor(Node<T> node) {

        if (node.getRightChild() != null){
            return findPredecessor(node.getRightChild());
        }
        return node;
    }

    @Override
    public void traversal() {
        if (root == null) return;
        if (root.getLeftChild() != null)
            inorder(root);
    }

    public void inorder(Node<T> node) {
        if (node.getLeftChild() != null)
            inorder(node.getLeftChild());

        System.out.println(node);

        if (node.getRightChild() != null)
            inorder(node.getRightChild());
    }

    @Override
    public T getMin() {
        if (root == null) {
            return null;
        }
        return getMin(root);
    }

    @Override
    public T getMax() {
        if (root == null) {
            return null;
        }
        return getMax(root);
    }

    private T getMax(Node<T> node) {
        if (node.getRightChild() != null) {
            return getMax(node.getRightChild());
        }
        return node.getData();
    }

    private T getMin(Node<T> node) {
        if (node.getLeftChild() != null) {
            return getMax(node.getLeftChild());
        }
        return node.getData();
    }

    public Node<T> getRoot() {
        return root;
    }

    public int sum(Node<Integer> node){

        if (node == null) return 0;

        int left = sum(node.getLeftChild()) ;
        int right = sum(node.getRightChild()) ;
//        System.out.println("Considering node left ->" + left);
//        System.out.println("Considering node right ->" + right);
//        System.out.println("Considering node total sum ->" + (left + right + node.getData()));
        return left + right + node.getData();
    }
}
