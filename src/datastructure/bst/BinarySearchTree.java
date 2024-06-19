package datastructure.bst;

import java.util.LinkedList;
import java.util.Queue;

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

    private void printPreorder(Node root) {
        if (root != null) {
            System.out.print(root.data + ",");
            printInorder(root.left);
            printInorder(root.right);
        }
    }

    public Node createBalancedBSTTreeFromSortedArray(int[] nums) {
        return buildBalancedTree(nums, 0, nums.length);
    }

    // Almost like binary search operation on sorted array
    private Node buildBalancedTree(int[] nums, int start, int end) {

        if (start >= end) {
            return null;
        }

        int mid = start + ((end - start) / 2);

        Node newNode = new Node(nums[mid]);
        newNode.left = buildBalancedTree(nums, start, mid);
        newNode.right = buildBalancedTree(nums, mid + 1, end);

        return newNode;

    }

    public boolean hasRootToLeafPath(Node node, int targetSum) {
        if (node == null) {
            return false;
        }

        boolean isLeaf = node.left == null && node.right == null;


        if (isLeaf && targetSum - node.data == 0) {
            return true;
        }

        return hasRootToLeafPath(node.left, targetSum - node.data) ||
                hasRootToLeafPath(node.right, targetSum - node.data);
    }

    public boolean hasValue(Node node, int targetSum) {
        if (node == null) {
            return false;
        }

        if (node.data - targetSum == 0) {
            return true;
        }

        return hasValue(node.left, targetSum - node.data) ||
                hasValue(node.right, targetSum - node.data);
    }

    public boolean isValidBST(Node root) {
        return isNodeValueInRange(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /*O(n^2)*/
    private boolean isNodeValueInRange(Node node, long min, long max) {
        if (node == null) {
            return true;
        } else if (node.data <= min || node.data >= max) {
            return false;
        }

        return isNodeValueInRange(node.left, min, node.data) &&
                isNodeValueInRange(node.right, node.data, max);
    }

    /*
     * We are using the BFS with augmented data to bound each node within range,
     * This will take o(n), instead of O(n^2) which it will take it non bfs approach.
     * */
    public boolean isBinarySearchTree(Node node) {

        if (node == null) return true; // Considering empty tree to be a valid bst

        AugmentedNode augmentedNode = new AugmentedNode(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
        Queue<AugmentedNode> queue = new LinkedList<>();
        queue.add(augmentedNode);

        while (!queue.isEmpty()) {
            AugmentedNode ag = queue.poll();
            int value = ag.node.data;
            if (value > ag.max || value < ag.min) {
                return false;
            }

            if (ag.node.left != null) {
                queue.add(new AugmentedNode(ag.node.left, augmentedNode.min, value));
            }

            if (ag.node.right != null) {
                queue.add(new AugmentedNode(ag.node.right, value, augmentedNode.max));
            }
        }

        return true;

    }

    static class AugmentedNode {

        Node node = null;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        public AugmentedNode(Node node, int min, int max) {
            this.node = node;
            this.min = min;
            this.max = max;
        }
    }


    public static void main(String[] args) {
        var tree = new BinarySearchTree();
        tree.insert(50);
        tree.root.left = new Node(60);
        tree.root.right = new Node(80);
//        tree.insert(30);
//        tree.insert(20);
//        tree.insert(40);
//        tree.insert(70);
//        tree.insert(60);
//        tree.insert(80);
//        tree.printInorder();
//        print(tree.isBinarySearchTree(tree.root));

        Node node = tree.createBalancedBSTTreeFromSortedArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        tree.printPreorder(node);
    }

    static void print(Object o) {
        System.out.println();
        System.out.println(o);
    }
}
