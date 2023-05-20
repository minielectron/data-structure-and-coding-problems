package top150.primitives;

import java.util.Arrays;

/** A palindrome is a sequence that reads the same forwards and backward.
 * Given an integer as input, write a function that tests if it is a palindrome.
 * Example 1:
 * Input: 9232
 * Output: false
 *
 * Example 4:
 * Input: -121
 * Output: false
 * */
public class Palindrome {
    // We are given integers means -Int.MAX to +Int.Max

    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        System.out.println(p.checkIfPalindrome(120));
    }

    public boolean checkIfPalindrome(int n){
        int reverse = 0;
        int actual = n;

        while(n > 0){
           reverse = (reverse * 10) + n % 10;
           n /= 10;
        }

        return reverse == actual;

    }

}
