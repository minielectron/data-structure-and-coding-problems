package recursions;

import java.util.Arrays;

public class BinarySearch {
    public boolean binarySearch(int[] arr, int start, int end, int k) {
        if (start > end) return false;
        int mid = start + ((end - start) / 2);
        if (arr[mid] == k) return true;
        if (arr[mid] < k) {
            return binarySearch(arr, mid + 1, end, k);
        } else if (arr[mid] > k){
            return binarySearch(arr, start, mid - 1, k);
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{3, 4, 2, 1, 6, 9, 7, 8};
        Arrays.sort(input); // items should be always sorted for binary search to work
        BinarySearch search = new BinarySearch();
        System.out.println(search.binarySearch(input, 0, input.length - 1, 6));
        System.out.println(search.binarySearch(input, 0, input.length - 1, 3));
        System.out.println(search.binarySearch(input, 0, input.length - 1, 8));
        System.out.println(search.binarySearch(input, 0, input.length - 1, 20));
    }
}
