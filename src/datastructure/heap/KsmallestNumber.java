package datastructure.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KsmallestNumber {
    /*Given an integer array, return the smallest K integers in the array.
 q
    Example 1:
    Input:
    2
    [3, 1, -2, 5, 7]

    Output:
    [-2, 1]
    */

    public static void main(String[] args) {
        KsmallestNumber ks = new KsmallestNumber();
        int [] input = {3, 1, -2, 5, 7};
        List<Integer> output = ks.kSmallestElements(input, 3);
        System.out.println(output);
    }

    public List<Integer> kSmallestElements(int[] elements, int k) {
        /*
         * If we want the k smallest items, we don't care for large items. So max heap. use Collections.reverse order for it.
         * If we want the k largest items, we don't care for small items. So min heap. remove reverse order.
         */
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());

        for (int element : elements) {
            maxHeap.add(element);

            if (maxHeap.size() == k + 1) {
                maxHeap.poll(); // over capacity by 1, eject the largest item
            }
        }

        // Format to list just so we aren't returning a raw priority queue

        return new ArrayList<>(maxHeap);
    }


}
