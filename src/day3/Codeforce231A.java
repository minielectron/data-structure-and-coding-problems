package day3;

import java.util.Scanner;

public class Codeforce231A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 0;
        while (n-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            if (a+b+c > 1) count++;
        }
        System.out.print(count);
    }
}
