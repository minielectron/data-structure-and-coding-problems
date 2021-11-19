package datastructure.sorting;


class HeapSort {

    public int[] heapsort(int[] arr) {

        // Find the Length of the array
        int n=arr.length;

        // If length of the array is less than or equal to 1
        // Return the original array as it is obviously sorted
        if(n<=1)
            return arr;

        // Build heap by rearranging the array
        for(int i=(n/2)-1;i>=0;i--)
        {
            heapify(arr,n,i);
        }

        // Extract the element from the heap one by one
        for(int i=n-1;i>0;i--)
        {
            // Move current root to end
            // By swapping the current element with first element
            int temp=arr[i];
            arr[i]=arr[0];
            arr[0]=temp;

            // Call the max heapify for the new reduced heap
            heapify(arr,i,0);
        }

        // Return the sorted array
        return arr;
    }

    // Helper function to heapify a subtree
    // Rooted at index i
    private void heapify(int arr[], int n, int i)
    {
        int max=i; // Initialise max as root

        // Initialise left and right
        int left=2*i+1;
        int right=2*i+2;

        // If left child is larger than root. Make left root
        if(left<n && arr[left]>arr[max])
        {
            max=left;
        }
        // If right child is larger than root. Make right root
        if(right<n && arr[right]>arr[max])
        {
            max=right;
        }

        // If max is not root
        if(max!=i)
        {
            int temp=arr[i];
            arr[i]=arr[max];
            arr[max]=temp;

            // Recursively heapify the affected subtree
            heapify(arr, n, max);
        }

    }
}

