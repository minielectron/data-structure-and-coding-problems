package udemyds.heaps;

public class ValidateHeap {

    public boolean isMinHeap(int [] heap){
        // leaf nodes do not have any children
        // if 2*i+2 >= N then we know that node is a leaf node(no need to consider)
        // so we have to rearrange the equation to get how many nodes to consider

        for (int i = 0; i < (heap.length - 2)/2; i++) {
            if (heap[i] > heap[2*i + 1] || heap[i] > heap[2*i + 2])
                return false;
        }

        return true;
    }

    public boolean isMaxHeap(int [] heap){
        // leaf nodes do not have any children
        // if 2*i+2 >= N then we know that node is a leaf node(no need to consider)
        // so we have to rearrange the equation to get how many nodes to consider

        for (int i = 0; i < (heap.length - 2)/2; i++) {
            if (heap[i] < heap[2*i + 1] || heap[i] < heap[2*i + 2])
                return false;
        }

        return true;
    }
}
