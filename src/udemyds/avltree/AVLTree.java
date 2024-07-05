package udemyds.avltree;


public class AVLTree<T extends Comparable<T>> implements Tree<T> {

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

        // settle the violation
        updateHeight(node);
        settleViolations(node);
    }

    private int treeSize(udemyds.bst.Node<T> node) {
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

        if (data.compareTo(node.getData()) < 0) {
            remove(data, node.getLeftChild());
        } else if (data.compareTo(node.getData()) > 0) {
            remove(data, node.getRightChild());
        } else {
            // We have a match, three cases are possible here
            // 1. leaf node

            if (node.getLeftChild() == null && node.getRightChild() == null) {

                System.out.println("Removing a leaf node ...");
                Node<T> parent = node.getParentNode();

                if (parent != null && parent.getLeftChild() == node) {
                    parent.setLeftChild(null);
                }

                if (parent != null && parent.getRightChild() == node) {
                    parent.setRightChild(null);
                }

                if (parent == null) {
                    root = null;
                }

                node = null; // eligible for gc

                updateHeight(parent);
                settleViolations(parent);
            }

            // 2. node with one child

            else if (node.getLeftChild() == null && node.getRightChild() != null) {
                // node has left child but not right child

                System.out.println("Removing node with one child ...");
                Node<T> parent = node.getParentNode();

                if (parent != null && parent.getLeftChild() == node) {
                    parent.setLeftChild(node.getRightChild());
                } else if (parent != null && parent.getRightChild() == node) {
                    parent.setRightChild(node.getRightChild());
                }

                if (parent == null) {
                    root = node.getRightChild();
                }

                node.getRightChild().setParentNode(node);
                node = null;
                updateHeight(parent);
                settleViolations(parent);
            } else if (node.getLeftChild() != null && node.getRightChild() == null) {
                // node has left child but not right child
                System.out.println("Removing left child ...");
                Node<T> parent = node.getParentNode();

                if (parent != null && parent.getLeftChild() == node) {
                    parent.setLeftChild(node.getLeftChild());
                } else if (parent != null && parent.getRightChild() == node) {
                    parent.setRightChild(node.getLeftChild());
                }

                if (parent == null) {
                    root = node.getLeftChild();
                }

                node.getLeftChild().setParentNode(node);
                node = null;
                updateHeight(parent);
                settleViolations(parent);
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

        // settle the violations
    }


    private Node<T> findPredecessor(Node<T> node) {

        if (node.getRightChild() != null) {
            return findPredecessor(node.getRightChild());
        }
        return node;
    }

    @Override
    public void traverse() {
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


    public T getMin() {
        if (root == null) {
            return null;
        }
        return getMin(root);
    }


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

    private void updateHeight(Node<T> node) {
        node.setHeight(Math.max(height(node.getLeftChild()), height(node.getRightChild())) + 1);
    }

    private int height(Node<T> node) {
        if (node == null) return -1;

        return node.getHeight();
    }


    // balance factor

    private int getBalance(Node<T> node) {
        if (node == null) return 0;
        return height(node.getLeftChild()) - height(node.getRightChild());
    }

    private void settleViolations(Node<T> node) {
        // We have to check up to root O(logN)
        while (node != null) {
            settleViolationsHelper(node);
            node = node.getParentNode();
        }
    }

    private void settleViolationsHelper(Node<T> node) {
        int balance = getBalance(node);

        // we know the tree is LEFT HEAVY but it can be left-right heavy or left-left heavy
        if (balance > 1) {
            // left right heavy situtation: left rotation
            if (getBalance(node.getLeftChild()) < 0) {
                leftRotation(node.getLeftChild());
            }
            // double left heavy situation only single right rotation needed.
            rightRotation(node);
        }

        // we know the tree is RIGHT HEAVY but it can be right-left heavy or right-right heavy
        if (balance < -1) {
            // right-left heavy situtation: left rotation
            if (getBalance(node.getRightChild()) > 0) {
                rightRotation(node.getRightChild());
            }
            // double left heavy situation only single right rotation needed.
            leftRotation(node);
        }
    }

    // It can be done in O(1)
    private void rightRotation(Node<T> node) {

        System.out.println("Rotating right at node "+node);
        // This is new root node
        Node<T> tempLeftChild = node.getLeftChild();
        Node<T> grandChild = tempLeftChild.getRightChild();

        // make rotations, the new root will be tempLeftChild
        tempLeftChild.setRightChild(node);
        node.setLeftChild(grandChild);

        if (grandChild != null) {
            grandChild.setParentNode(node);
        }

        // We have to handle the parents for the root node
        Node<T> tempParent = node.getParentNode();
        node.setParentNode(tempLeftChild);
        tempLeftChild.setParentNode(tempParent);

        if (tempLeftChild.getParentNode() != null && tempLeftChild.getParentNode().getLeftChild() == node) {
            tempLeftChild.getParentNode().setLeftChild(tempLeftChild);
        }

        if (tempLeftChild.getParentNode() != null && tempLeftChild.getParentNode().getRightChild() == node) {
            tempLeftChild.getParentNode().setRightChild(tempLeftChild);
        }

        // no parents are rotation
        if (node == root) {
            root = tempLeftChild;
        }

        updateHeight(node);
        updateHeight(tempLeftChild);
    }

    // It can be done in O(1)
    private void leftRotation(Node<T> node) {

        System.out.println("Rotating left at node "+node);

        // This is new root node
        Node<T> tempRightChild = node.getRightChild();
        Node<T> grandChild = tempRightChild.getLeftChild();

        // make rotations, the new root will be tempRightChild
        tempRightChild.setLeftChild(node);
        node.setRightChild(grandChild);

        if (grandChild != null) {
            grandChild.setParentNode(node);
        }

        // We have to handle the parents for the root node
        Node<T> tempParent = node.getParentNode();
        node.setParentNode(tempRightChild);
        tempRightChild.setParentNode(tempParent);

        if (tempRightChild.getParentNode() != null && tempRightChild.getParentNode().getLeftChild() == node) {
            tempRightChild.getParentNode().setLeftChild(tempRightChild);
        }

        if (tempRightChild.getParentNode() != null && tempRightChild.getParentNode().getRightChild() == node) {
            tempRightChild.getParentNode().setRightChild(tempRightChild);
        }

        // no parents are rotation
        if (node == root) {
            root = tempRightChild;
        }

        updateHeight(node);
        updateHeight(tempRightChild);
    }
}
