package datastructure.searching;

import java.util.HashSet;
import java.util.Set;

/*Given two sorted arrays, return a new array that represents their intersection.

Example 1:
Input:
[1,2,3,5]
[1,2]

Output:
[1,2]*/
public class IntersectionOfTwoArray {
    public int[] intersection(int[] nums1, int[] nums2) {

        // Create a Set for storing the elements which are common
        Set<Integer> intersection = new HashSet<>();

        int ptr1 = 0;
        int ptr2 = 0;

        //Iterate all the elemnts of both the array
        while (ptr1 < nums1.length && ptr2 < nums2.length) {

            // If the elements are same, Add it to the set
            // And Increment both the pointers
            if (nums1[ptr1] == nums2[ptr2]) {
                intersection.add(nums1[ptr1]);

                ptr1++;
                ptr2++;
            }
            // If element of first array is less than element of second array increment ptr1
            else if (nums1[ptr1] < nums2[ptr2]) {
                ptr1++;
            }
            // Else increment ptr2
            else {
                ptr2++;
            }
        }

        //Return the ans after converting it to array
        return setToArray(intersection);
    }

    //Helper function for converting set to array
    private int[] setToArray(Set<Integer> set) {
        int[] array = new int[set.size()];

        int index = 0;
        for (int item : set) {
            array[index] = item;
            index++;
        }

        return array;
    }

}
