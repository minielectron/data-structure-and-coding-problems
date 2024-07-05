package udemyds.avltree;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class App {

    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();

        tree.insert(12);
        tree.insert(4);
        tree.insert(20);
        tree.insert(1);
        tree.insert(5);
        tree.insert(23);

        tree.remove(23);
        tree.remove(20);
//        tree.traverse();

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }

}
