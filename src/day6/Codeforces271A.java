package day6;

import java.util.Scanner;

public class Codeforces271A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        for (int i = year; i <= 9999; i++) {
            int temp = i + 1;
            if (hasAllUniqueDigit(temp)) {
                System.out.println(temp);
                break;
            }
        }
    }

    static boolean hasAllUniqueDigit(int year) {
        int a = year % 10;
        year /= 10;
        int b = year % 10;
        year /= 10;
        int c = year % 10;
        year /= 10;
        int d = year % 10;
        return (a != b && a != c && a != d && b != c && b != d && c != d);
    }
}
