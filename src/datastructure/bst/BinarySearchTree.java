package datastructure.bst;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

interface BST {
    void insert(int data);

    boolean delete(int data);

    boolean search(int data);

    void printInorder();
}

public class BinarySearchTree implements BST {

    private Node root;
    private boolean isNodeFound = false;

    BinarySearchTree() {
        root = null;
    }

    @Override
    public void insert(int data) {
        root = insertToBST(this.root, data);
    }

    private Node insertToBST(Node root, int data) {
        if (root == null) {
            root = new Node(data);
        } else if (data > root.data) {
            root.right = insertToBST(root.right, data);
        } else if (data < root.data) {
            root.left = insertToBST(root.left, data);
        } else {
            throw new IllegalArgumentException("We don't support duplicates");
        }
        return root;
    }

    @Override
    public boolean delete(int data) {
        isNodeFound = false;
        deleteFromBST(root, data);
        return isNodeFound;
    }

    private Node deleteFromBST(Node root, int key) {
        if (root == null) return null;

        // Search the node
        if (key < root.data) {
            root.left = deleteFromBST(root.left, key);
        } else if (key > root.data) {
            root.right = deleteFromBST(root.right, key);
        } else {
            isNodeFound = true;
            // We found the node to be deleted
            // When both left and right subtree is not null
            // Three cases are possible
            // 1. When left subtree is null
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                //2. When right subtree is null
                return root.left;
            } else {
                //3. When both subtree are not null,
                // we have to find the inorder next node and replace it with root.

                Node nextInorderNode = getNextInorderNode(root, key);
                root.data = nextInorderNode.data;
                root.right = deleteFromBST(root.right, nextInorderNode.data);
            }

        }

        return root;
    }

    private Node getNextInorderNode(Node root, int key) {
        if (root == null) {
            return null;
        }

        Node curr = root.right;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    @Override
    public boolean search(int data) {
        return searchTree(this.root, data);
    }

    private boolean searchTree(Node root, int data) {
        if (root != null) {
            if (root.data == data) return true;
            else {
                if (data < root.data) return searchTree(root.left, data);
                else return searchTree(root.right, data);
            }
        }
        return false;
    }

    public boolean isBST() {
        Node wn = this.root;
        if (wn != null) {
            return testBST(wn);
        } else {
            return false;
        }
    }

    private boolean testBST(Node n) {
        if (n != null) {
            var isRightInvalid =  n.right != null && n.right.data < n.data;
            var isLeftInvalid =  n.left != null && n.left.data < n.data;
            return !isRightInvalid && !isLeftInvalid;
        } else
            return testBST(n.left) && testBST(n.right);

    }

    @Override
    public void printInorder() {
        printInorder(this.root);
    }

    private void printInorder(Node root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.data + ",");
            printInorder(root.right);
        }
    }


    public static void main(String[] args) {
        var tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.printInorder();
        print(tree.delete(20));
        print(tree.delete(80));
        print(tree.delete(100));
        print(tree.delete(40));
        tree.printInorder();
        print(tree.search(0));
        print(tree.isBST());
    }

    static void print(Object o) {
        System.out.println(o);
    }
}
