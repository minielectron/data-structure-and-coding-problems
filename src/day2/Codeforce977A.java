package day2;

import java.util.Scanner;

public class Codeforce977A {

    /*
    if the last digit of the number is non-zero, she decreases the number by one;
if the last digit of the number is zero, she divides the number by 10 (i.e. removes the last digit)
    * */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        while (k-- > 0) {
            if (n % 10 != 0) n--;
            else n /= 10;
        }
        System.out.println(n);
    }
}

/*5
10 4
13 9
100 13
123 456
92 42*/

