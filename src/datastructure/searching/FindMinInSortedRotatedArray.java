package datastructure.searching;

/*
* Given a rotated sorted array, find the minimum element.
*
* A "rotated" array is an array that has had each item shifted to the left or
*  right by k units (where k is a positive integer) while maintaining positional integrity
* of every element in the original array.

Example 1:
Input: [4, 5, 6, 7, 1, 2]
Output: 1*/

public class FindMinInSortedRotatedArray {

    public int findMin(int[] nums) {

        // Make a left pointer , right pointer and mid for performing binary search
        // Inititalize left=0 and right = size-1 as lower and upper bounds
        int left = 0;
        int right = nums.length - 1;
        int mid;

        // Perform Binary Search
        while (left < right) {

            // Take the middle value.
            // This method is preferred for taking the middle to avoid integer overflow
            mid = left + ((right - left) / 2);

            // If mid element is greater than right element. than update left
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else { // Else update right
                right = mid;
            }
        }

        // If the array is empty return -1
        // Else return nums[left]
        if (nums.length > 0) {
            return nums[left];
        } else {
            return -1;
        }
    }

}
