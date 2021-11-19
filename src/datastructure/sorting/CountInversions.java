package datastructure.sorting;

class CountInversions {
    public int countInversions(int[] A) {
        return mergesort(A, 0, A.length - 1);
    }

    // Helper function performing merge sort
    private int mergesort(int[] A, int left, int right) {
        int inversions = 0;

        if (right > left) {
            int mid = left + (right - left) / 2;

            // Recursively count the number of inversions in the left and right subarrays.
            inversions += mergesort(A, left, mid);
            inversions += mergesort(A, mid + 1, right);

            // Count the number of inversions between the left and right subarrays.
            inversions += merge(A, left, mid, right);
        }

        return inversions;
    }

    // Merge function to merge 2 sorted arrays
    // in O(n) time
    private int merge(int[] A, int left, int mid, int right) {

        // Create a new array of required size
        int[] B = new int[right - left + 1];

        int i = left, j = mid + 1, placement = 0;
        int inversions = 0;

        // Keep on placing the elemnts in the new array
        // And simultaneously increase the inversion count
        while (i <= mid && j <= right) {
            if (A[i] <= A[j]) {
                B[placement++] = A[i++];
            } else {
                B[placement++] = A[j++];
                inversions += (mid + 1 - i);
            }
        }

        /* Exactly one of the following two while-loops will run. */
        // They place the remaining elements to the new array
        while (i <= mid) B[placement++] = A[i++];
        while (j <= right) B[placement++] = A[j++];

        for (int k = left; k <= right; k++) {
            A[k] = B[k - left];
        }

        return inversions;
    }

    public static void main(String[] args) {
        CountInversions c = new CountInversions();
        int count = c.countInversions(new int[]{1,2,3,4});
        System.out.println(count);
    }
}
