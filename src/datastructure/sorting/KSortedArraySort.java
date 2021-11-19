package datastructure.sorting;

import java.util.PriorityQueue;

class KSortedArraySort {
    public int[] sortNearlySortedArray(int[] arr, int k) {

        // We create a minimum priority queue
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int n = arr.length;

        // Insert the first k elements in the minimum priority queue
        for (int i = 0; i < k && i < n; i++) {
            minHeap.add(arr[i]);
        }

        // As the array is k sorted
        // Make two pointers- For pushing element in priority queue
        // And for insertion in array
        int readIndex = k;
        int placementIndex = 0;

        // Loop till there is element to push to minimum priority queue
        while (readIndex < n) {

            // Push the element at read index to priority queue
            minHeap.add(arr[readIndex]);
            readIndex++;

            // Place the element at top of priority queue to the placement index
            // And pop that element from priority queue
            arr[placementIndex] = minHeap.poll();
            placementIndex++;
        }

        /*
         * Empty out the rest of the heap & do placements.
         */
        while (!minHeap.isEmpty()) {
            arr[placementIndex] = minHeap.poll();
            placementIndex++;
        }

        return arr;
    }
}
