package recursions;

import java.util.Random;

public class SelectionAlgorithms {

    // These are inplace algorithms
    // To find kth largest or smallest number in O(n)

    // Quick select algorithm [Hoare algorithm]
    // O(n) is best case , O(n^2) in worst case


    public void partition(int[] arr, int startIndex, int lastIndex){
        Random random = new Random();
        int pivot = random.nextInt(startIndex, lastIndex);
    }

    public void swap(int arr, int fromIndex, int toIndex){

    }
}
