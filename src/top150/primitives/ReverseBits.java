package top150.primitives;

/**
 * Given an input integer input, return the integer value of input's bits reversed.
 * You will only be reversing the "significant portion" of the binary representation (ignoring leading zeros).
 *
 * Example 1:
 * Input: 1
 * Output: 1
 * Explanation: Under 8 bits 1 can be represented as 00000001.
 * If we only reverse the significant protion of this we yield 00000001 which is 1 in binary.
 *
 * Example 2:
 * Input: 10
 * Output: 5
 * Explanation: 10 is 1010 under base 2, 00001010 under 8 bits (notice how leading 0's do not add value).
 * The reverse of 1010 is 0101, yielding 00000101 which is 5.
 * */

public class ReverseBits {

    public static void main(String[] args) {
        ReverseBits r = new ReverseBits();
        System.out.println(r.reverseBits2(10));
        System.out.println(r.reverseBits2(1));
        System.out.println(1 << 4);
    }

    int reverseBits(int n){
        int position = 0;
        int original = n;

        while (n != 0){
            n = n >> 1;
            position++;
        }

        return original ^ (calculatePowerOf2(position) - 1);
    }

    int reverseBits2(int n){
        int output = 0;

        // 001010 --> 000101
        while (n != 0){
            output <<= 1;
            if ((n & 1) == 1) {
                output |= 1;
            }
            n >>= 1;
        }

        return output;
    }
    int calculatePowerOf2(int n){
        return 1 << n;
    }
}


// 00 101
// 00 010