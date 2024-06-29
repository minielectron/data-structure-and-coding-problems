package top150;

/**
 * Given a non-negative integer input, return true if input is a power of two. Return false otherwise.
 *
 * Example #1:
 * Input: 4
 * Output: true
 * Explanation: The number 4 is a power of two.
 *
 * Example #2:
 * Input: 17
 * Output: false
 * Explanation: The number 17 is not a power of two.
 *
 * Constraints:  Your solution should run in O(1) time.
 * */
public class PowerOf2 {

    public static void main(String[] args) {
        System.out.println(isPowerOF2(20));
    }
    static boolean isPowerOF2(int n){

        // If number is not even, then it cannot be power of 2.
        if (n % 2 != 0) return false;

        int bits = 0;

        while (n != 0){
            int bit = n & 1;
            System.out.println("current bit = "+ bit);
            if(bit == 1) {
                bits ++;
                if (bits > 1) return false;
            }
            n = n >> 1;
        }
        return bits == 1;
    }
}
