package udemyds.bst;

public class App {


    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(12);
        bst.insert(4);
        bst.insert(20);
        bst.insert(1);
        bst.insert(8);
        bst.insert(16);
        bst.insert(27);

        BinarySearchTree<Integer> bst2 = new BinarySearchTree<>();
        bst.insert(10);
        bst.insert(4);
        bst.insert(20);
        bst.insert(1);
        bst.insert(8);
        bst.insert(16);
        bst.insert(27);


        System.out.println(bst.kthSmallest(bst.getRoot(), 3));
        System.out.println(bst.getMin());
        System.out.println(bst.getMax());

        TreeComparator<Integer> comparator = new TreeComparator<>();
        boolean isSame = comparator.isSameTree(bst.getRoot(), bst2.getRoot());
        System.out.println(isSame);
    }
}
