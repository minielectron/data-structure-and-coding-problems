package datastructure.searching;

import java.util.HashMap;
import java.util.Map;

public class FourSum {

    // First Approach:
    /*In this Approach, First we store all possible sum that can be formed
     using 1 element from nums1 and 1 element from nums2 in a HashMap along with its
     frequency. After that for each possible combination of nums3[k]+ nums4[l] , We check
     the frequencies of their additive inverse that exists in the map and add it to the answer.
     Time Complexity - O(n*n) Space Complexity - O(n*n)*/
    public int Four_Sum(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        // Create a HashMap for storing sum of first two arrays
        Map<Integer, Integer> map = new HashMap<>();

        // Declare an ans variable to increment the ans
        int ans = 0;

        // Traverse the first two arrays(1 & 2) in a nested way
        // So as to have all possible combinations
        for (int k : nums1) {
            for (int i : nums2) {
                // Store the sum of elements of both the arrays in the HashMap
                // Along with their frequencies
                int sum = k + i;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        // Traverse the next two (3 and 4) arrays in a nested way
        // So as to have all possible combinations
        for (int j : nums3) {
            for (int k : nums4) {
                // If Additive Inverse exist in the map
                // Add its frequency to the ans
                ans += map.getOrDefault(-1 * (j + k), 0);
            }
        }

        return ans;

    }
}
