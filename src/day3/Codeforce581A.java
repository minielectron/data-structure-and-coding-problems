package day3;

import java.util.Scanner;

public class Codeforce581A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int count;
        int x = Math.abs(a - b);
        count = Math.min(a, b);
        System.out.print(count + " " + x / 2);
    }
}
