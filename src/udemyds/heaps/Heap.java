package udemyds.heaps;

// We are implementing max heap
public class Heap {

    private final int[] heap;
    private int size = 0;

    public Heap() {
        heap = new int[Constants.CAPACITY];
    }

    private boolean isFull(){
        return size == Constants.CAPACITY;
    }

    public void insert(int data){
        if (isFull()) throw new RuntimeException("Heap is full ...");

        heap[size] = data;
        size++;

        // We have to check heap properties
        // we have to check the nodes from child to root node so it can be logN.
        fixUp(size - 1);
    }

    private void fixUp(int index) {
        // index of parent

        int parentIndex = getParent(index);

        // in worst case we have to consider all the node upto root

        if (index >0  && heap[index] > heap[parentIndex]){
            swap(index, parentIndex);
            fixUp(parentIndex);
        }
    }

    private int getParent(int child){
        return (child - 1) / 2;
    }

    public int max(){
        return heap[0];
    }

    public void heapSort(){
        int n = size;

        for (int i = 0; i < n; i++) {
            int max = poll();
            System.out.println(max);
        }
    }

    public int poll(){
        // Return max and remove that element
        int max = max();
        swap(0, size - 1);
        size --;

        // We have to fix the heap properties if needed
        fixDown(0);
        return max;
    }

    private void fixDown(int index) {

        int largestIndex = getLargestIndex(index);

        // one of the children is larger than the parent sow e have to swap items
        // otherwise the heap properties are not violated
        if (index != largestIndex){
            swap(index, largestIndex);

            // until the heap properties are violated we keep calling the fix down.
            fixDown(largestIndex);
        }

    }

    private int getLargestIndex(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;

        // In max heap the parent is always larger than children
        int largestIndex = index;

        // compare left child with parent
        if (leftChildIndex < size && heap[leftChildIndex] > heap[index]){
            largestIndex = leftChildIndex;
        }

        // compare right child with parent
        if (rightChildIndex < size && heap[rightChildIndex] > heap[largestIndex]){
            largestIndex = rightChildIndex;
        }
        return largestIndex;
    }

    private void swap(int index, int parentIndex) {
        int temp = heap[parentIndex];
        heap[parentIndex] = heap[index];
        heap[index] = temp;
    }
}
