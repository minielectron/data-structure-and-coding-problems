package day5;

import java.util.Scanner;

/**
 * Petya loves lucky numbers. We all know that lucky numbers are the positive integers whose decimal representations contain only the lucky digits 4 and 7. For example, numbers 47, 744, 4 are lucky and 5, 17, 467 are not.
 * <p>
 * Unfortunately, not all numbers are lucky. Petya calls a number nearly lucky if the number of lucky digits in it is a lucky number. He wonders whether number n is a nearly lucky number.
 */
public class Codeforce110a {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        int count = 0;
        while (n > 0) {
            if (n % 10 == 4 || n % 10 == 7) {
                count++;
            }
            n = n / 10;
        }

        if (count == 7 || count == 4)
            System.out.println("YES");
        else System.out.println("NO");
    }
}
