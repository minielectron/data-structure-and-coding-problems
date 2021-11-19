package datastructure.sorting;


import java.util.List;

/*
 * Verifying Character Ordering
 * Given a string s representing a new ordering of the lowercase English letters and an array A[]
 * of strings, return true if and only
 * if A[] is sorted in lexicographical order according to the ordering provided in s.
 * Example #1:
Input: s = "hlbcdefgijkmnopqrstuvwxzya", A[] = ["hello", "hey", "a"].
Output: true
Explanation: Under the new ordering, the array A[] is sorted. Note that the letter 'h' comes before the letter 'a',
* and the letter 'l' comes before the letter 'y'.
 * */
public class VerifyCharacterOrdering {
    // Helper Function which
    // Returns true if and only if s1 <= s2.
    private boolean compareStrings(int[] order, String s1, String s2) {
        int n = s1.length(), m = s2.length();

        // Traverse till the minimum size of both the strings
        // Return true and false accordingly
        for (int i = 0; i < n && i < m; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return order[s1.charAt(i) - 'a'] < order[s2.charAt(i) - 'a'];
            }
        }

        // If all characters till min(n,m) were same of both the strings
        return n <= m;
    }

    public boolean verifyOrdering(List<String> A, String ordering) {

        // Create an array for mapping characters
        int[] order = new int[26];

        // Each character is mapped to the index at which it appears.
        for (int i = 0; i < ordering.length(); i++) {
            order[ordering.charAt(i) - 'a'] = i;
        }

        // Loop through each string
        for (int i = 0; i < A.size() - 1; i++) {
            if (!compareStrings(order, A.get(i), A.get(i + 1))) {
                /* The array isn't sorted! */
                return false;
            }
        }

        return true;
    }
}
