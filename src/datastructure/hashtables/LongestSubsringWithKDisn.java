package datastructure.hashtables;

/*
* We can traverse our string using two pointers: a left pointer, and a right pointer.
* Together, these pointers represent the current substring that we are considering.
* Furthermore, we can keep a hashmap to store the frequency of each character in our substring.
* On each step, we try to extend our substring by moving our right pointer forwards.
* As we move our right pointer forward, we can check whether or not our substring already
* contains the new character being processed at our right pointer by checking whether or not
* its frequency in our hashmap is equal to zero. If so, this character does not contribute
* anything to our distinct characters count. Conversely, if the character is not already in our
* hashmap, then it is a distinct character, and we must increment our counter. If our count of
* distinct characters ever exceeds k, then we must move the left pointer forward to evict
* some of the characters of our substring. While moving the left pointer forward, we decrement
* the frequency of the character being evicted. If the frequency of a character ever reaches zero,
* then we can decrement our counter. While traversing our string, we take the maximal length over
* all valid strings to be our answer. This is computed on-the-fly. The overall runtime of this
* algorithm is O(N) where N is the length of our string since we visit each character
* at most twice (once by the left pointer and once by the right pointer).
* */
public class LongestSubsringWithKDisn {

    public static void main(String[] args) {
        LongestSubsringWithKDisn l = new LongestSubsringWithKDisn();
        System.out.println(l.longestSubstringWithAtMostKDistinctCharacters("hello", 1));
    }

    public int longestSubstringWithAtMostKDistinctCharacters(String s, int k) {
        // Initializes the table for mapping characters to occurences
        int[] map = new int[128];
        int right = 0, left = 0, numDistinct = 0, max = 0;

        // We will utilize a left and right pointer to traverse our string
        while (right < s.length()) {
            if (map[s.charAt(right)] == 0) {
                numDistinct++;
            }
            map[s.charAt(right)]++;

            // If our distinct character counter exceeds k, then we move the left pointer forward until we are within our bound
            while (numDistinct > k) {
                map[s.charAt(left)]--;
                if (map[s.charAt(left)] == 0) {
                    numDistinct--;
                }
                left++;
            }

            // If the current window is greater than the max window, we update the max
            max = Math.max(right - left + 1, max);
            right++;
        }

        return max;
    }
}
